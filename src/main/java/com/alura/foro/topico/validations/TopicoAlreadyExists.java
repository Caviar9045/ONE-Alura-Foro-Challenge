package com.alura.foro.topico.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alura.foro.config.errors.IntegrityValidator;
import com.alura.foro.topico.DataUpdateTopico;
import com.alura.foro.topico.TopicoRepository;
import com.alura.foro.topico.utils.DataNewTopico;

import jakarta.validation.ValidationException;

@Component
public class TopicoAlreadyExists implements TopicosValidator{

	@Autowired
	private TopicoRepository topicoRepository;
	
	public void validate(DataNewTopico dataNewTopico) {
		if(dataNewTopico.titulo() == null) {
			return;
		}
		var TopicoAlreadyExits = topicoRepository.existsByTituloAndMensaje(dataNewTopico.titulo(), dataNewTopico.mensaje());
		if(TopicoAlreadyExits) {
			throw new IntegrityValidator("Error: Cannot create. Duplicated titulo and mensaje.");
		}
	}

	public void validate(DataUpdateTopico dataUpdateTopico) {
		if(dataUpdateTopico.titulo() == null) {
			return;
		}
		if(dataUpdateTopico.mensaje() == null) {
			return;
		}

		if(dataUpdateTopico.estatus() == null) {
			return;
		}
		var TopicoAlreadyExits = topicoRepository.existsByTituloAndMensaje(dataUpdateTopico.titulo(), dataUpdateTopico.mensaje());
		if(TopicoAlreadyExits) {
			throw new IntegrityValidator("Error: Cannot update. Reason: Duplicated titulo and mensaje.");
		}
	}
	
}
