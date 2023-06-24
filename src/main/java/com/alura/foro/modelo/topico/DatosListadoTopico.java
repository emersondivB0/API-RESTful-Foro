package com.alura.foro.modelo.topico;

import com.alura.foro.modelo.usuario.DatosListadoUsuario;

public record DatosListadoTopico(Long id, String titulo, String mensaje, int curso_id, DatosListadoUsuario autor) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getCurso_id(),
                new DatosListadoUsuario(topico.getAutor()));
    }
}
