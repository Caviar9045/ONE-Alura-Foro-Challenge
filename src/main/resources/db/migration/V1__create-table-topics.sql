CREATE TABLE topics (
	id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    mensaje VARCHAR(500) NOT NULL,
    fecha_creacion DATE NOT NULL,
    estatus VARCHAR(50) NOT NULL,
    autor VARCHAR(50) NOT NULL,
    curso VARCHAR(50) NOT NULL
    );