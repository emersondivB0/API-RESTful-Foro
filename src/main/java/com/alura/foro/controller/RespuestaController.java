package com.alura.foro.controller;

import com.alura.foro.modelo.respuesta.DatosListadoRespuestas;
import com.alura.foro.modelo.respuesta.Respuesta;
import com.alura.foro.modelo.respuesta.RespuestaRepository;
import com.alura.foro.modelo.topico.TopicoRepository;
import com.alura.foro.modelo.topico.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/responds")
public class RespuestaController {
    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private TopicoRepository topicoRepository;
    @GetMapping
    public ResponseEntity<Page<DatosListadoRespuestas>> listadoRespuestas(@PageableDefault Pageable pageable) {
        Page<DatosListadoRespuestas> page =
                respuestaRepository.findByActivoTrue(pageable).map(DatosListadoRespuestas::new);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Respuesta> crearRespuesta(@RequestBody @Valid Respuesta respuesta,
                                                    @RequestParam("topico_id") Long topico_id) {
        Topico responderTopico = topicoRepository.getReferenceById(topico_id);
        Respuesta nuevaRespuesta = respuestaRepository.save(respuesta);
        nuevaRespuesta.setTopico(responderTopico);
        return ResponseEntity.ok(nuevaRespuesta);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desactivarRespuesta(@PathVariable Long id) {
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        respuesta.desactivarRespuesta();
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/activar/{id}")
    @Transactional
    public ResponseEntity activarRespuesta(@PathVariable Long id) {
        Respuesta respuesta = respuestaRepository.getReferenceById(id);
        respuesta.activarRespuesta();
        return ResponseEntity.noContent().build();
    }

}
