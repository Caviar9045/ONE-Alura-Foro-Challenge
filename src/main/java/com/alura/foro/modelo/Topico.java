package com.alura.foro.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.alura.foro.topico.DataUpdateTopico;
import com.alura.foro.topico.utils.DataNewTopico;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Table(name = "topics")
@Entity(name = "Topico")
@EqualsAndHashCode(of = "id")
public class Topico {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private StatusTopico estatus = StatusTopico.NO_RESPONDIDO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="autor_id")
	private Usuario autor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Respuesta> respuestas = new ArrayList<>();
	
	private Integer active;

	public Topico(String titulo, String mensaje, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.curso = curso;
		this.active = 1;
	}
	
	public Topico(String titulo, String mensaje, LocalDateTime fecha_creacion, StatusTopico estatus, Usuario usuario, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.fechaCreacion = fecha_creacion;
		this.estatus = estatus;
		this.autor = usuario;
		this.curso = curso;
		this.active = 1;
	}
	
	public Topico(DataNewTopico dataNewTopico) {
		this.titulo = dataNewTopico.titulo();
		this.mensaje = dataNewTopico.mensaje();
		this.fechaCreacion = dataNewTopico.fechaCreacion();
		this.estatus = dataNewTopico.estatus();
		this.active = 1;
	}
	
	

	public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico estatus,
			Usuario autor, Curso curso, List<Respuesta> respuestas) {
		this.id = id;
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.fechaCreacion = fechaCreacion;
		this.estatus = estatus;
		this.autor = autor;
		this.curso = curso;
		this.respuestas = respuestas;
		this.active = 1;
	}
	
	

	public Topico() {
	}

	public Topico(Long id, String titulo, String mensaje, StatusTopico estatus) {
		this.id = id;
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.estatus = estatus;
	}	
	
	public void updateTopico(DataUpdateTopico dataUpdateTopico) {
		if(dataUpdateTopico.titulo() != null) {
			this.titulo = dataUpdateTopico.titulo();
		}
		if(dataUpdateTopico.mensaje() != null) {
			this.mensaje = dataUpdateTopico.mensaje();
		}
		if(dataUpdateTopico.estatus() != null) {
			this.estatus = dataUpdateTopico.estatus();
		}
	}
	
	public void deactivateTopic() {
		this.active = 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getStatus() {
		return estatus;
	}

	public void setStatus(StatusTopico status) {
		this.estatus = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

}
