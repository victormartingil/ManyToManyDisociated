package com.app.jpa.db.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(JoinLibroAutorId.class)
public class JoinLibroAutor {

	@Id
	@ManyToOne
	@JoinColumn(name="libro_id")
	private Libro libro;
	
	@Id
	@ManyToOne
	@JoinColumn(name="autor_id")
	private Autor autor;
	
	private String editorial;
	
	public JoinLibroAutor () {}
	
	public JoinLibroAutor(Libro libro, Autor autor, String editorial) {
		this.libro = libro;
		this.autor = autor;
		this.editorial = editorial;
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

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

}
