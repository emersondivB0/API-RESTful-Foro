package com.alura.foro.modelo.curso;

import com.alura.foro.modelo.usuario.DatosRespuestaUsuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public ResponseEntity<Page<DatosListadoCurso>> listadoCursos(Pageable pageable) {
        Page<DatosListadoCurso> page = cursoRepository.findByActivoTrue(pageable).map(DatosListadoCurso::new);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody @Valid Curso curso) {
        Curso nuevoCurso = cursoRepository.save(curso);
        return ResponseEntity.ok(nuevoCurso);
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizarCurso(@RequestBody @Valid DatosActualizarCurso datosActualizarCurso) {
        Curso curso = cursoRepository.getReferenceById(datosActualizarCurso.id());
        curso.actualizarDatos(datosActualizarCurso);
        return ResponseEntity.ok(new DatosRespuestaCurso(curso.getId(), curso.getNombre(), curso.getCategoria()));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        cursoRepository.delete(curso);
        return ResponseEntity.ok().build();
    }

    /*
    This code will return a 200 OK status code if the Curso object was deleted successfully.
    If the Curso object was not found, the method will return a 404 Not Found status code.
    In both DeleteMappings
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> ocultarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        curso.desactivarCurso();
        cursoRepository.save(curso);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/activar/{id}")
    @Transactional
    public ResponseEntity<Curso> activarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        curso.activarCurso();
        cursoRepository.save(curso);
        return ResponseEntity.noContent().build();
    }
}
