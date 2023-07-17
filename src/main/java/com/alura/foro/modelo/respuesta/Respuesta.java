package com.alura.foro.modelo.respuesta;

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
    private Topico topico;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private Usuario autor;
    private Boolean solucion = false;
    @Column(name = "usuario_id")
    private int usuario_id;
    @Column(name = "curso_id")
    private int curso_id;

    public Respuesta(DatosRegistroRespuesta )

}
