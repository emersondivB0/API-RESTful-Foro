package com.alura.foro.modelo.usuario;

import com.alura.foro.modelo.curso.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@Table(name= "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private boolean activo;

    public Usuario(DatosRegistroUsuario datosRegistroUsuario) {
        this.nombre = datosRegistroUsuario.nombre();
        this.email = datosRegistroUsuario.email();
        this.password = datosRegistroUsuario.password();
        this.activo = true;
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario) {
        if (datosActualizarUsuario.nombre() != null) {
            this.nombre = datosActualizarUsuario.nombre();
        }
        if (datosActualizarUsuario.email() != null) {
            this.email = datosActualizarUsuario.email();
        }
        if (datosActualizarUsuario.password() != null) {
            this.password = datosActualizarUsuario.password();
        }
    }

    public void desactivarUsuario() {
        this.activo = false;
    }
    public void activarUsuario() {
        this.activo = true;
    }


}
