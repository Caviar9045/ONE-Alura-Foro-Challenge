package com.alura.foro.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.foro.modelo.Usuario;
import com.alura.foro.user.DataNewUser;
import com.alura.foro.user.DataResponseUser;
import com.alura.foro.user.UserRepository;
import com.alura.foro.user.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController	
@RequestMapping("/user")
@SecurityRequirement(name = "bearer-key")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<DataResponseUser> createTopico(@RequestBody @Valid DataNewUser dataNewUser, UriComponentsBuilder uriComponentsBuilder){
		Usuario user = userRepository.save(new Usuario(dataNewUser.nombre(), dataNewUser.email(),userService.getEcryptedPassword(dataNewUser.contrasena())));

		URI url = uriComponentsBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri(); 
		return ResponseEntity.created(url).build();
	}
	
	
}
