package com.alura.foro.modelo.usuario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<DatosListadoUsuario> listadoUsuarios() {
        return usuarioRepository.findAll().stream().map(DatosListadoUsuario::new).toList();
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody @Valid Usuario usuario) {
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }
}
