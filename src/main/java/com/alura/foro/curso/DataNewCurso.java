package com.alura.foro.curso;

import jakarta.validation.constraints.NotBlank;

public record DataNewCurso(
		@NotBlank(message = "Nombre es obligatorio") String nombre,
		@NotBlank(message = "Categoria es obligatorio") String categoria) {
		
}
