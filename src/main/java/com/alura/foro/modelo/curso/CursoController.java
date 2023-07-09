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
    public void eliminarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        cursoRepository.delete(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> ocultarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        curso.desactivarCurso();
        cursoRepository.save(curso);
        return ResponseEntity.ok(curso);
    }

    @PutMapping("/activar/{id}")
    @Transactional
    public ResponseEntity<Curso> activarCurso(@PathVariable Long id) {
        Curso curso = cursoRepository.getReferenceById(id);
        curso.activarCurso();
        cursoRepository.save(curso);
        return ResponseEntity.ok(curso);
    }
}
