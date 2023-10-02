package com.alura.foro.topico.utils;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import com.alura.foro.modelo.StatusTopico;

public record DataNewTopico(
	Long id,
	@NotBlank(message = "Titulo es obligatorio") String titulo,
	@NotBlank(message = "Mensaje es obligatorio") String mensaje,
	LocalDateTime fechaCreacion,
	@NotNull StatusTopico estatus,
	@NotNull Long autor_id,
	@NotNull Long curso_id
	){
}
