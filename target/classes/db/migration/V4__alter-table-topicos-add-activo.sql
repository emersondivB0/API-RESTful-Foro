ALTER TABLE topicos ADD activo tinyint;
UPDATE topicos SET activo = 1;