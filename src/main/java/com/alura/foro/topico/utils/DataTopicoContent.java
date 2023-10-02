package com.alura.foro.topico.utils;

import java.time.LocalDateTime;

import com.alura.foro.modelo.StatusTopico;
import com.alura.foro.modelo.Topico;

public record DataTopicoContent(
		Long id, String titulo, String mensaje, LocalDateTime fechaCreacion,
		StatusTopico status, Long idUsuario, Long idCurso) {
	
	public DataTopicoContent(Topico topico) {
		this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getfechaCreacion(), topico.getStatus(),topico.getAutor().getId(), topico.getCurso().getId());
	}

}
