package com.alura.foro.modelo.usuario;

import com.alura.foro.modelo.curso.DatosListadoCurso;

public record DatosListadoUsuario(Long id, String nombre, String email) {
    public DatosListadoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail());
    }
}
