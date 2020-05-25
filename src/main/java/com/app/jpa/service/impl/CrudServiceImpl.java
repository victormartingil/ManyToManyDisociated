package com.app.jpa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.jpa.converter.Converter;
import com.app.jpa.service.CrudService;

public abstract class CrudServiceImpl<Entity, Dto, Repository extends CrudRepository<Entity, Long>> implements CrudService<Entity, Dto> {

	protected Repository repository;
	
	protected Converter<Entity, Dto> converter;

	public CrudServiceImpl(Repository repository, Converter<Entity, Dto> converter) {
		this.repository = repository;
		this.converter = converter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dto> findAll() {
		List<Dto> list = new ArrayList<>();
    	list = (List<Dto>) repository.findAll();
    	return list;
	}

	@Override
	public Optional<Dto> findById(long id) {
		return converter.convertEntityToDto(repository.findById(id));
	}

	@Override
	@Transactional
	public void create(Dto dto) {
		
		try {
			if(dto == null) {
	    		throw new NoSuchElementException();
	    	}
			Entity entity = converter.convertDtoToEntity(dto);
			repository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);
	}

}
