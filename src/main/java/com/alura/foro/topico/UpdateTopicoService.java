package com.alura.foro.topico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alura.foro.curso.CursoRepository;
import com.alura.foro.topico.utils.DataNewTopico;
import com.alura.foro.topico.utils.DataTopicoContent;
import com.alura.foro.topico.validations.TopicosValidator;
import com.alura.foro.user.UserRepository;
import com.alura.foro.modelo.Topico;

@Service
public class UpdateTopicoService {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	List<TopicosValidator> validators;
	
	public DataResponseTopico updateTopico(Long id, DataUpdateTopico data) {
		
		validators.forEach(v -> v.validate(data));
		
		Topico topico = topicoRepository.getReferenceById(id);
		topico.updateTopico(data);
		
		var topicData = new DataResponseTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getfechaCreacion().toString(), 
				topico.getStatus().toString(), topico.getAutor().getNombre(), topico.getCurso().getNombre(), topico.getActive());
		
		return topicData;
		
	}

}
