package com.app.jpa.dto;

import java.util.HashSet;
import java.util.Set;

//@LibroDtoConstraint(groups = {Create.class, Edit.class})
//@LibroDtoDeleteConstrait(groups = {Delete.class})
public class LibroDto {

	private long id;
	
	private String titulo;
	
	private Set<JoinLibroAutorDto> joinLibrosAutores;
	
	public LibroDto() {
	}
	
	public LibroDto(long id) {
		this(id, null, new HashSet<>());
	}
	
	public LibroDto(String titulo, Set<JoinLibroAutorDto> joinLibrosAutores) {
		this(0, titulo, joinLibrosAutores);
	}
	
	public LibroDto(long id, String titulo, Set<JoinLibroAutorDto> joinLibrosAutores) {
		this.id = id;
		this.titulo = titulo;
		this.joinLibrosAutores = joinLibrosAutores;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Set<JoinLibroAutorDto> getJoinLibrosAutores() {
		return joinLibrosAutores;
	}

	public void setJoinLibrosAutores(Set<JoinLibroAutorDto> joinLibrosAutores) {
		this.joinLibrosAutores = joinLibrosAutores;
	}

}
