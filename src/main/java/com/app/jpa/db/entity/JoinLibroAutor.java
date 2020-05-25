package com.app.jpa.db.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JoinLibroAutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
//	@MapsId("libro_id")
	@JoinColumn(name="libro_id")
	private Libro libro;
	
	@ManyToOne
//	@MapsId("autor_id")
	@JoinColumn(name="autor_id")
	private Autor autor;
	
	private String editorial;
	
	public JoinLibroAutor () {}
	
	public JoinLibroAutor(long id) {
		this (id, null, null, null);
	}
	
	public JoinLibroAutor(Libro libro, Autor autor, String editorial) {
		this(0, libro, autor, editorial);
	}

	public JoinLibroAutor(long id, Libro libro, Autor autor, String editorial) {
		this.id = id;
		this.libro = libro;
		this.autor = autor;
		this.editorial = editorial;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
