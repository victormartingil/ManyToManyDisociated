package com.app.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.jpa.converter.Converter;
import com.app.jpa.db.entity.Autor;
import com.app.jpa.dto.AutorDto;
import com.app.jpa.repository.AutorRepository;

@Service
public class AutorServiceImpl extends CrudServiceImpl<Autor, AutorDto, AutorRepository> {

	@Autowired
	public AutorServiceImpl(AutorRepository repository, Converter<Autor, AutorDto> converter) {
		super(repository, converter);
	}

}
