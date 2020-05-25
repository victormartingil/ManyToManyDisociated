package com.app.jpa.db.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	@OneToMany (mappedBy="autor", cascade = CascadeType.ALL)
	private Set<JoinLibroAutor> joinLibrosAutores;
	
	public Autor() {
	}
	
	public Autor(long id) {
		this(id, null, new HashSet<>());
	}
	
	public Autor(long id, String nombre, Set<JoinLibroAutor> joinLibrosAutores) {
		this.id = id;
		this.nombre = nombre;
		setJoinLibrosAutores(joinLibrosAutores);
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
	
	public Set<JoinLibroAutor> getJoinLibrosAutores() {
		return joinLibrosAutores;
	}

	public void setJoinLibrosAutores(Set<JoinLibroAutor> joinLibrosAutores) {
		joinLibrosAutores.forEach(element -> {
			element.setAutor(this);
		});
		this.joinLibrosAutores = joinLibrosAutores;
	}

	public void addLibro (JoinLibroAutor joinLibroAutor) {
		if (joinLibrosAutores.contains(joinLibroAutor))
			return;
		joinLibrosAutores.add(joinLibroAutor);
	}
	
	public void removeLibro (JoinLibroAutor joinLibroAutor) {
		if (!joinLibrosAutores.contains(joinLibroAutor))
			return;
		joinLibrosAutores.remove(joinLibroAutor);
	}
	
}
