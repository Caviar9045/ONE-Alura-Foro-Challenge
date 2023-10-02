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
public class CreateTopicoService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	List<TopicosValidator> validators;
	
	public DataTopicoContent createTopico(DataNewTopico data) {
		
		validators.forEach(v -> v.validate(data));
		
		var user = userRepository.findById(data.autor_id()).get();
		var curso = cursoRepository.findById(data.curso_id()).get();
		var topico = new Topico(data.titulo(), data.mensaje(), data.fechaCreacion(), data.estatus(),  user, curso);
		
		topicoRepository.save(topico);
		
		return new DataTopicoContent(topico);
		
	}

}
