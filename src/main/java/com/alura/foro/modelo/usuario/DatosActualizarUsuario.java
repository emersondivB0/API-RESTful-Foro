package com.alura.foro.modelo.usuario;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuario(@NotNull Long id, String nombre, String email, String password) {
}
