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

INSERT INTO cursos (nombre, descripcion, autor_id)
VALUES
    ("Spring Boot", "Creación de API Rest con Java y Spring Boot", FLOOR(RAND() * 10) + 1),
    ("JavaScript Avanzado", "Desarrollo de aplicaciones web interactivas con JavaScript", FLOOR(RAND() * 10) + 1),
    ("Python para Ciencia de Datos", "Introducción al análisis de datos con Python", FLOOR(RAND() * 10) + 1),
    ("Introducción a la Programación", "Conceptos fundamentales de programación con ejemplos prácticos", FLOOR(RAND() * 10) + 1),
    ("Diseño Web Responsive", "Creación de sitios web adaptables a diferentes dispositivos", FLOOR(RAND() * 10) + 1),
    ("Desarrollo de Aplicaciones Móviles", "Creación de aplicaciones móviles para iOS y Android", FLOOR(RAND() * 10) + 1),
    ("Bases de Datos Relacionales", "Fundamentos de diseño y administración de bases de datos relacionales", FLOOR(RAND() * 10) + 1),
    ("Desarrollo de Videojuegos", "Introducción a la creación de videojuegos utilizando motores populares", FLOOR(RAND() * 10) + 1),
    ("Machine Learning", "Aplicaciones prácticas de algoritmos de aprendizaje automático", FLOOR(RAND() * 10) + 1),
    ("Desarrollo de Aplicaciones Web con Django", "Creación de aplicaciones web utilizando el framework Django", FLOOR(RAND() * 10) + 1);

UPDATE topicos SET activo = 1 WHERE id = 5;
SELECT * FROM topicos;
SELECT * FROM usuarios;