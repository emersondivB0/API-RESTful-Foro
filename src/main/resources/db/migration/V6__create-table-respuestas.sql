CREATE TABLE respuestas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    solucion TINYINT DEFAULT 0,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estatus_topico ENUM('NO_RESPONDIDO', 'NO_SOLUCIONADO', 'SOLUCIONADO', 'CERRADO') NOT NULL DEFAULT 'NO_SOLUCIONADO',
    topico_id INT NOT NULL,
    autor_id INT NOT NULL,
    curso_id INT NOT NULL,
    activo TINYINT DEFAULT 1,
    UNIQUE (titulo(255), mensaje(300)),
    FOREIGN KEY (topico_id) REFERENCES topicos(id),
    FOREIGN KEY (autor_id) REFERENCES usuarios(id),
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);