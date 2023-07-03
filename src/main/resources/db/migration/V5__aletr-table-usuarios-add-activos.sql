ALTER TABLE usuarios ADD activo tinyint;
UPDATE usuarios SET activo = 1;