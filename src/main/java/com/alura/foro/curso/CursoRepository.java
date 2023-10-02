package com.alura.foro.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.alura.foro.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	UserDetails findByNombre(String nombre);
	
}

