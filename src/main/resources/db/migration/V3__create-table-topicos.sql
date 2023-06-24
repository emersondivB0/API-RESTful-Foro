CREATE TABLE topicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estatus_topico ENUM('NO_RESPONDIDO', 'NO_SOLUCIONADO', 'SOLUCIONADO', 'CERRADO') NOT NULL,
    autor_id INT NOT NULL,
    curso_id INT NOT NULL,
    UNIQUE (titulo(255), mensaje(300)),
    FOREIGN KEY (autor_id) REFERENCES usuarios(id),
    FOREIGN KEY (curso_id) REFERENCES cursos(id)
);