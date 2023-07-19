package com.alura.foro.modelo.respuesta;

import com.alura.foro.modelo.curso.Curso;
import com.alura.foro.modelo.topico.Topico;
import com.alura.foro.modelo.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Data
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private Boolean solucion = false;
    @Column(name = "topico_id")
    private int topico_id;
    @Column(name = "usuario_id")
    private int usuario_id;
    @Column(name = "curso_id")
    private int curso_id;
    private boolean activo = true;
    @ManyToOne
    @JoinColumn(name = "topico_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Topico topico;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Curso curso;

    public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta,Topico topico, Usuario usuario, Curso curso) {
        this.mensaje = datosRegistroRespuesta.mensaje();
        this.solucion = datosRegistroRespuesta.solucion();
        this.topico_id = datosRegistroRespuesta.topico_id();
        this.usuario_id = datosRegistroRespuesta.usuario_id();
        this.curso_id = datosRegistroRespuesta.curso_id();
        this.topico = topico;
        this.usuario = usuario;
        this.curso = curso;
    }

    public void actualizarRespuesta(DatosActualizarRespuesta datosActualizarRespuesta) {
        if (datosActualizarRespuesta.mensaje() != null) {
            this.mensaje = datosActualizarRespuesta.mensaje();
        }
        if (datosActualizarRespuesta.solucion() !=null) {
            this.solucion = datosActualizarRespuesta.solucion();
        }
    }

    public void desactivarRespuesta() {
        this.activo = false;
    }

    public void activarRespuesta() { this.activo = true; }

}
