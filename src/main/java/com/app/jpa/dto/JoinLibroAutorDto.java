package com.app.jpa.dto;

//@JoinLibroAutorDtoConstraint(groups = {Create.class, Edit.class})
//@JoinLibroAutorDtoDeleteConstraint(groups = {Delete.class})
public class JoinLibroAutorDto {
	
	private LibroDto libro;
	
	private AutorDto autor;
	
	private String editorial;
	
	public JoinLibroAutorDto () {}
	
	public JoinLibroAutorDto(LibroDto libro, AutorDto autor, String editorial) {
		this.libro = libro;
		this.autor = autor;
		this.editorial = editorial;
	}

	public LibroDto getLibro() {
		return libro;
	}

	public void setLibro(LibroDto libro) {
		this.libro = libro;
	}

	public AutorDto getAutor() {
		return autor;
	}

	public void setAutor(AutorDto autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

}
