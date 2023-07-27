package com.alura.foro.modelo.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroRespuesta(
        @NotBlank
        String mensaje,
        Boolean solucion,
        @NotNull
        int topico_id,
        @NotNull
        int usuario_id) {
}
