package com.alura.foro.controller;

import com.alura.foro.modelo.respuesta.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responds")
public class RespuestaController {
    @Autowired
    private RespuestaRepository respuestaRepository;
    
}
