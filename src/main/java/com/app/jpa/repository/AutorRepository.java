package com.app.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.jpa.db.entity.Autor;

public interface AutorRepository extends CrudRepository<Autor, Long>{

}
