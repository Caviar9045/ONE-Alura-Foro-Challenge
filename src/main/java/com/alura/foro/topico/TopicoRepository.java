package com.alura.foro.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.foro.modelo.Topico;
import com.alura.foro.topico.utils.DataTopicoContent;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	Boolean existsByTituloAndMensaje(String titulo, String mensaje);

	Page<Topico> findByActiveTrue(Pageable paged);
	
}
