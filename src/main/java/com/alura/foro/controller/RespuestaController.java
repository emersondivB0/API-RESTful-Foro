package com.alura.foro.controller;

import com.alura.foro.modelo.respuesta.DatosListadoRespuestas;
import com.alura.foro.modelo.respuesta.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responds")
public class RespuestaController {
    @Autowired
    private RespuestaRepository respuestaRepository;
    @GetMapping
    public ResponseEntity<Page<DatosListadoRespuestas>> listadoRespuestas(@PageableDefault Pageable pageable) {
        Page<DatosListadoRespuestas> page =
                respuestaRepository.findByActivoTrue(pageable).map(DatosListadoRespuestas::new);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

}
