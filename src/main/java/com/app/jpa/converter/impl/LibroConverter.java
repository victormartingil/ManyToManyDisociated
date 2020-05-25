package com.app.jpa.converter.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.jpa.converter.AbstractConverter;
import com.app.jpa.db.entity.Autor;
import com.app.jpa.db.entity.JoinLibroAutor;
import com.app.jpa.db.entity.Libro;
import com.app.jpa.dto.AutorDto;
import com.app.jpa.dto.JoinLibroAutorDto;
import com.app.jpa.dto.LibroDto;

@Component
public class LibroConverter extends AbstractConverter<Libro, LibroDto>{

	@Autowired
	public LibroConverter () {
	}
	
	public Libro convertDtoToEntity(LibroDto dto) {
		
		Set<JoinLibroAutor> joinLibrosAutores = new HashSet<>();
		if(dto.getJoinLibrosAutores() != null) {
			for(JoinLibroAutorDto element : dto.getJoinLibrosAutores()) {
				joinLibrosAutores.add(new JoinLibroAutor(
											element.getLibro()!=null?new Libro(element.getLibro().getId()):null,
											element.getAutor()!=null?new Autor(element.getAutor().getId()):null,
											element.getEditorial()));
			}
		}
		
		return new Libro (dto.getId(),
							dto.getTitulo(),
							joinLibrosAutores
							);
	}
	
	public LibroDto convertEntityToDto (Libro entity) {
		
		Set<JoinLibroAutorDto> joinLibrosAutores = new HashSet<>();
		if (entity.getJoinLibrosAutores() != null) {
			for (JoinLibroAutor element : entity.getJoinLibrosAutores()) {
				joinLibrosAutores.add(new JoinLibroAutorDto(new LibroDto(element.getLibro().getId()),
															new AutorDto(element.getAutor().getId()),
															element.getEditorial()));
			}
		}
		
		return new LibroDto (entity.getId(),
							entity.getTitulo(),
							joinLibrosAutores);
	}
	
	public Set<LibroDto> convertEntityToDto(Set<Libro> set) {
		if (set == null) {
			return null;
		}
		return set.stream()
				  .map(this::convertEntityToDto)
				  .collect(Collectors.toSet());
	}

	public Set<Libro> convertDtoToEntity(Set<LibroDto> set) {
		if (set == null) {
			return null;
		}
		return set.stream()
				  .map(this::convertDtoToEntity)
				  .collect(Collectors.toSet());
	}
	
	public Optional<LibroDto> convertEntityToDto(Optional<Libro> optional) {
		return optional.map(this::convertEntityToDto);
	}
	
	public void updateEntity (LibroDto dto, Libro entity) {
		entity.setTitulo(dto.getTitulo());
	}

}
