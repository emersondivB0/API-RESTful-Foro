use foro_alura;
insert into usuarios (nombre, email, password) values ("Emerson González", "emerson.dvlmt@gmail.com", "123");
select * from usuarios;
insert into cursos (nombre, descripcion, autor_id) values ("Spring Boot", "Creación de API Rest con Java y Spring Boot",
1);
select * from cursos;
select * from topicos;
INSERT INTO usuarios (nombre, email, password)
VALUES 
    ("Juan Pérez", "juan@example.com", "contraseña123"),
    ("María López", "maria@example.com", "123456"),
    ("Carlos Gómez", "carlos@example.com", "secreto"),
    ("Laura Ramírez", "laura@example.com", "contraseña123"),
    ("Pedro Martínez", "pedro@example.com", "abc123"),
    ("Ana Sánchez", "ana@example.com", "pass123"),
    ("Diego Rodríguez", "diego@example.com", "password"),
    ("Sofía Hernández", "sofia@example.com", "987654"),
    ("Ricardo Silva", "ricardo@example.com", "qwerty"),
    ("Isabel Torres", "isabel@example.com", "pass1234");

INSERT INTO cursos (nombre, categoria)
VALUES
    ("Spring Boot", "Creación de API Rest con Java y Spring Boot"),
    ("JavaScript Avanzado", "Desarrollo de aplicaciones web interactivas con JavaScript"),
    ("Python para Ciencia de Datos", "Introducción al análisis de datos con Python"),
    ("Introducción a la Programación", "Conceptos fundamentales de programación con ejemplos prácticos"),
    ("Diseño Web Responsive", "Creación de sitios web adaptables a diferentes dispositivos"),
    ("Desarrollo de Aplicaciones Móviles", "Creación de aplicaciones móviles para iOS y Android"),
    ("Bases de Datos Relacionales", "Fundamentos de diseño y administración de bases de datos relacionales"),
    ("Desarrollo de Videojuegos", "Introducción a la creación de videojuegos utilizando motores populares"),
    ("Machine Learning", "Aplicaciones prácticas de algoritmos de aprendizaje automático"),
    ("Desarrollo de Aplicaciones Web con Django", "Creación de aplicaciones web utilizando el framework Django");

UPDATE topicos SET activo = 1 WHERE id = 5;
UPDATE usuarios SET activo = 1;
UPDATE topicos SET activo = 1;
SELECT * FROM topicos;
SELECT * FROM usuarios;

CREATE TABLE flyway_schema_history (
    version VARCHAR(50) NOT NULL,
    description VARCHAR(200) NOT NULL,
    type VARCHAR(20) NOT NULL,
    script VARCHAR(1000) NOT NULL,
    checksum INT,
    installed_by VARCHAR(100) NOT NULL,
    installed_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    execution_time INT NOT NULL,
    success BOOLEAN NOT NULL
);

-- Add the baseline version
INSERT INTO flyway_schema_history (version, description, type, script, checksum, installed_by, installed_on, execution_time, success)
VALUES ('1', 'Baseline', 'BASELINE', 'V1__baseline.sql', 0, 'flyway', CURRENT_TIMESTAMP, 0, true);
