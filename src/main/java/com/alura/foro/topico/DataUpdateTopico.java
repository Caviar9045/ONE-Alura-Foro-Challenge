package com.alura.foro.topico;

import com.alura.foro.modelo.StatusTopico;

import jakarta.validation.constraints.NotNull;

public record DataUpdateTopico(
		String titulo, 
		String mensaje, 
		StatusTopico estatus) {

}
