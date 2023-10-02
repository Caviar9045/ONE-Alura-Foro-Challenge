package com.alura.foro.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.config.errors.IntegrityValidator;
import com.alura.foro.modelo.Topico;
import com.alura.foro.topico.CreateTopicoService;
import com.alura.foro.topico.DataResponseTopico;
import com.alura.foro.topico.DataUpdateTopico;
import com.alura.foro.topico.TopicoRepository;
import com.alura.foro.topico.UpdateTopicoService;
import com.alura.foro.topico.utils.DataNewTopico;
import com.alura.foro.topico.utils.DataTopicoContent;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController	
@ResponseBody
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

	@Autowired
	private CreateTopicoService createTopicoService;
	
	@Autowired
	private UpdateTopicoService updateTopicoService;
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DataTopicoContent> createTopico(@RequestBody @Valid DataNewTopico dataNewTopico) throws IntegrityValidator{
		var response = createTopicoService.createTopico(dataNewTopico);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<Page<DataTopicoContent>> topicContentList(@PageableDefault(size = 10) Pageable paged) {
		return ResponseEntity.ok(topicoRepository.findByActiveTrue(paged).map(DataTopicoContent::new));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DataResponseTopico> topicById(@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		var topicData = new DataResponseTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getfechaCreacion().toString(), 
				topico.getStatus().toString(), topico.getAutor().getNombre(), topico.getCurso().getNombre(), topico.getActive());
		return ResponseEntity.ok(topicData);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DataResponseTopico> updateTopico(@PathVariable Long id, @RequestBody @Valid DataUpdateTopico dataUpdateTopico) {
		var response = updateTopicoService.updateTopico(id, dataUpdateTopico);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deteleTopico(@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		topico.deactivateTopic();
		return ResponseEntity.noContent().build();
	}
	
}
