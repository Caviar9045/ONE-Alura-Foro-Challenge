CREATE TABLE respuestas (
	id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    mensaje VARCHAR(50) NOT NULL,
    topico VARCHAR(500) NOT NULL,
    fechaCreacion DATE NOT NULL,
    autor VARCHAR(50) NOT NULL,
    solucion BOOLEAN NOT NULL
);