package com.alura.foro.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.foro.curso.CursoRepository;
import com.alura.foro.curso.DataNewCurso;
import com.alura.foro.curso.DataResponseCurso;
import com.alura.foro.modelo.Curso;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController	
@RequestMapping("/curso")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@PostMapping
	public ResponseEntity<DataResponseCurso> createTopico(@RequestBody @Valid DataNewCurso dataNewCurso, UriComponentsBuilder uriComponentsBuilder){
		Curso curso = cursoRepository.save(new Curso(dataNewCurso));
		DataResponseCurso dataResponseCurso = new DataResponseCurso(curso.getId(), curso.getNombre(), curso.getCategoria());
		URI url = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri(); 
		return ResponseEntity.created(url).body(dataResponseCurso);
	}
	
	
}
