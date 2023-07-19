package com.alura.foro.modelo.respuesta;

import com.alura.foro.modelo.topico.Topico;
import com.alura.foro.modelo.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroRespuesta(
        @NotBlank
        String mensaje,
        @NotNull
        Topico topico,
        Boolean solucion,
        @NotNull
        int topico_id,
        @NotNull
        int usuario_id,
        @NotNull
        int curso_id) {
}
