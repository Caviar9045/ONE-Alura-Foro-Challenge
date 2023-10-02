package com.alura.foro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.config.security.DataJWTToken;
import com.alura.foro.config.security.TokenService;
import com.alura.foro.modelo.Usuario;
import com.alura.foro.user.DataAuthUser;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<DataJWTToken> autenticarUsuario(@RequestBody @Valid DataAuthUser dataAuthUser) {
		Authentication authToken = new UsernamePasswordAuthenticationToken(dataAuthUser.email(), dataAuthUser.contrasena());
		var usuarioAutenticado = authenticationManager.authenticate(authToken);
		var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
		return ResponseEntity.ok(new DataJWTToken(JWTtoken));
	}
}
