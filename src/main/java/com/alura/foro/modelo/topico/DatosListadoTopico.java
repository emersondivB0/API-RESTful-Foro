package com.alura.foro.modelo.topico;

import com.alura.foro.modelo.curso.DatosListadoCurso;
import com.alura.foro.modelo.usuario.DatosListadoUsuario;

public record DatosListadoTopico(Long id, String titulo, String mensaje, DatosListadoUsuario autor, DatosListadoCurso curso) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                new DatosListadoUsuario(topico.getAutor()),
                new DatosListadoCurso(topico.getCurso()));
    }
}
