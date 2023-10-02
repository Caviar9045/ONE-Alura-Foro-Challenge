package com.alura.foro.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.alura.foro.modelo.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{

	UserDetails findByEmail(String username);
	
}

