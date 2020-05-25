package com.app.jpa.dto;

import java.util.HashSet;
import java.util.Set;

//@AutorDtoConstraint(groups = {Create.class, Edit.class})
//@AutorDtoDeleteConstrait(groups = {Delete.class})
public class AutorDto {

	private long id;
	
	private String nombre;
	
	private Set<JoinLibroAutorDto> joinLibrosAutores;
	
	public AutorDto() {
	}
	
	public AutorDto(long id) {
		this(id, null, new HashSet<>());
	}
	
	public AutorDto(String nombre) {
		this(0, nombre, new HashSet<>());
	}
	
	public AutorDto(long id, String nombre, Set<JoinLibroAutorDto> joinLibrosAutores) {
		this.id = id;
		this.nombre= nombre;
		this.joinLibrosAutores = joinLibrosAutores;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<JoinLibroAutorDto> getJoinLibrosAutores() {
		return joinLibrosAutores;
	}

	public void setJoinLibrosAutores(Set<JoinLibroAutorDto> joinLibrosAutores) {
		this.joinLibrosAutores = joinLibrosAutores;
	}
	
}
