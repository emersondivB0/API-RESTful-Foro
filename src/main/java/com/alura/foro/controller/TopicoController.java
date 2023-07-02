package com.alura.foro.controller;

import com.alura.foro.modelo.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    /*
    @GetMapping
    public List<DatosListadoTopico> listadoTopicos() {
        return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();
    }
    */
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 5) Pageable pageable) {
        Page<DatosListadoTopico> page = topicoRepository.findByActivoTrue(pageable).map(DatosListadoTopico::new);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid Topico topico) {
        System.out.println("Hay Request joven");
        Topico nuevoTopico = topicoRepository.save(topico);
        return ResponseEntity.ok(nuevoTopico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
       Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
       topico.actualizarDatos(datosActualizarTopico);
       return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje()));
    }

    @DeleteMapping("/admin/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity ocultarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/activar/{id}")
    @Transactional
    public ResponseEntity activarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.activarTopico();
        return ResponseEntity.noContent().build();
    }

}
