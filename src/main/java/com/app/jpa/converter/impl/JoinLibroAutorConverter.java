package com.app.jpa.converter.impl;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.jpa.converter.AbstractConverter;
import com.app.jpa.db.entity.JoinLibroAutor;
import com.app.jpa.dto.JoinLibroAutorDto;

@Component
public class JoinLibroAutorConverter extends AbstractConverter<JoinLibroAutor, JoinLibroAutorDto>{

	private LibroConverter libroConverter;
	
	private AutorConverter autorConverter;
	
	@Autowired
	public JoinLibroAutorConverter (LibroConverter libroConverter, AutorConverter autorConverter) {
		this.libroConverter = libroConverter;
		this.autorConverter = autorConverter;
	}
	
	public JoinLibroAutor convertDtoToEntity(JoinLibroAutorDto dto) {
		
		return new JoinLibroAutor (libroConverter.convertDtoToEntity(dto.getLibro()),
								   autorConverter.convertDtoToEntity(dto.getAutor()),
								   dto.getEditorial()
								   );
	}
	
	public JoinLibroAutorDto convertEntityToDto (JoinLibroAutor entity) {
		
		return new JoinLibroAutorDto (libroConverter.convertEntityToDto(entity.getLibro()),
									  autorConverter.convertEntityToDto(entity.getAutor()),
									  entity.getEditorial()
									  );
	}
	
	public Set<JoinLibroAutorDto> convertEntityToDto(Set<JoinLibroAutor> set) {
		if (set == null) {
			return null;
		}
		return set.stream()
				  .map(this::convertEntityToDto)
				  .collect(Collectors.toSet());
	}
	
	public Set<JoinLibroAutor> convertDtoToEntity(Set<JoinLibroAutorDto> set) {
		if (set == null) {
			return null;
		}
		return set.stream()
				  .map(this::convertDtoToEntity)
				  .collect(Collectors.toSet());
	}
	
	public void updateEntity (JoinLibroAutorDto dto, JoinLibroAutor entity) {
		entity.setEditorial(dto.getEditorial());
	}

}
