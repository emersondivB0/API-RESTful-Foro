package com.alura.foro.modelo.topico;

import com.alura.foro.modelo.curso.Curso;
import com.alura.foro.modelo.usuario.DatosListadoUsuario;
import com.alura.foro.modelo.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Topico")
@Table(name= "topicos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Data
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name = "autor_id")
    private int autor_id;
    @Column(name= "curso_id")
    private int curso_id;

    private boolean activo;

    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusTopico estatus_topico;
    @ManyToOne
    @JoinColumn(name = "autor_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuario autor;
    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Curso curso;

    public Topico(DatosRegistroTopico datosRegistroTopico, Usuario autor, Curso curso) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.estatus_topico = StatusTopico.NO_RESPONDIDO;
        this.autor_id = datosRegistroTopico.autor_id();
        this.curso_id = datosRegistroTopico.curso_id();
        this.autor = autor;
        this.curso = curso;
        this.activo = true;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
    }

    public void desactivarTopico() {
        this.activo = false;

    }

    public void activarTopico() {
        this.activo = true;
    }

}
