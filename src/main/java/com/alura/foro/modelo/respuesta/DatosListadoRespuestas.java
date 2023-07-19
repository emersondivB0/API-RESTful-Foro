package com.alura.foro.modelo.respuesta;

import com.alura.foro.modelo.curso.DatosListadoCurso;
import com.alura.foro.modelo.topico.DatosListadoTopico;
import com.alura.foro.modelo.usuario.DatosListadoUsuario;

public record DatosListadoRespuestas(Long id, String mensaje, DatosListadoTopico topico, DatosListadoUsuario usuario,
                                     DatosListadoCurso curso) {
    public  DatosListadoRespuestas(Respuesta respuesta) {
        this(respuesta.getId(), respuesta.getMensaje(),
                new DatosListadoTopico(respuesta.getTopico()),
                new DatosListadoUsuario(respuesta.getUsuario()),
                        new DatosListadoCurso(respuesta.getCurso()));
    }
}
