package com.app.jpa.db.entity;

import java.io.Serializable;

public class JoinLibroAutorId implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Libro libro;
	
	private Autor autor;

	public JoinLibroAutorId() {
	}

	public JoinLibroAutorId(Libro libro, Autor autor) {
		this.libro = libro;
		this.autor = autor;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
