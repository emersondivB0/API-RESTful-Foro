package com.alura.foro.modelo.topico;

import com.alura.foro.modelo.usuario.DatosRegistroUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotNull
        String mensaje,
        String estatus_topico,
        @NotNull
        int autor_id,
        @NotNull
        int curso_id) {

}
