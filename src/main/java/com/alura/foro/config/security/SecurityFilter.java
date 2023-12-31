package com.alura.foro.config.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.alura.foro.user.UserRepository;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Obtener el token del header
		var authHeader = request.getHeader("Authorization");
		if (authHeader != null) {
			var token = authHeader.replace("Bearer ", "");
			var userName = tokenService.getSubject(token);
			if (userName != null) {
				// Token valido
				var usuario = userRepository.findByEmail(userName);
				// Forzamos inicio de sesion
				var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		filterChain.doFilter(request, response);
	}
}
