package com.alura.foro.topico;

import java.time.LocalDateTime;

import com.alura.foro.modelo.Curso;
import com.alura.foro.modelo.StatusTopico;
import com.alura.foro.modelo.Usuario;

public record DataResponseTopico(
		Long id,
		String titulo,
		String mensaje,
		String fechaCreacion,
		String status,
		String autor,
		String curso,
		Integer active
		) {

}
