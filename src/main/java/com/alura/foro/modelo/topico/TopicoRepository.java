package com.alura.foro.modelo.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    //Page<Medico> findByActivoTrue(Pageable paginacion);
    Page<Topico> findByActivoTrue(Pageable pageable);
}
