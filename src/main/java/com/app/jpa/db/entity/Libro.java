package com.app.jpa.db.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String titulo;
	
	@OneToMany(mappedBy="libro", cascade = CascadeType.ALL)
	private Set<JoinLibroAutor> joinLibrosAutores;
	
	public Libro() {
	}
	
	public Libro(long id) {
		this(id, null, new HashSet<>());
	}
	
	public Libro (String titulo, Set<JoinLibroAutor> joinLibrosAutores) {
		this(0, titulo, joinLibrosAutores);
	}
	
	public Libro(long id, String titulo, Set<JoinLibroAutor> joinLibrosAutores) {
		this.id = id;
		this.titulo = titulo;
		this.setJoinLibrosAutores(joinLibrosAutores);
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

	public Set<JoinLibroAutor> getJoinLibrosAutores() {
		return joinLibrosAutores;
	}

	public void setJoinLibrosAutores(Set<JoinLibroAutor> joinLibrosAutores) {
		joinLibrosAutores.forEach(element -> {
			element.setLibro(this);
		});
		this.joinLibrosAutores = joinLibrosAutores;
	}

	public void addAutor (JoinLibroAutor joinLibroAutor) {
		if (joinLibrosAutores.contains(joinLibroAutor))
			return;
		joinLibroAutor.setLibro(this);
		joinLibrosAutores.add(joinLibroAutor);
	}
	
	public void removeAutor (JoinLibroAutor joinLibroAutor) {
		if (!joinLibrosAutores.contains(joinLibroAutor))
			return;
		joinLibrosAutores.remove(joinLibroAutor);
		joinLibroAutor.setLibro(null);
	}
}
