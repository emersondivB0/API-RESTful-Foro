package com.alura.foro.controller;

import com.alura.foro.modelo.topico.DatosListadoTopico;
import com.alura.foro.modelo.topico.Topico;
import com.alura.foro.modelo.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public List<DatosListadoTopico> listadoTopicos() {
        return topicoRepository.findAll().stream().map(DatosListadoTopico::new).toList();
    }

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid Topico topico) {
        System.out.println("Hay Request joven");
        Topico nuevoTopico = topicoRepository.save(topico);
        return ResponseEntity.ok(nuevoTopico);
    }
}
