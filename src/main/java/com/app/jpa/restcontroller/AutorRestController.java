package com.app.jpa.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.jpa.db.entity.Autor;
import com.app.jpa.dto.AutorDto;
import com.app.jpa.service.CrudService;

@RestController
@RequestMapping("/api/autores")
public class AutorRestController extends RestCrudController<Autor, AutorDto> {
	
	@Autowired
	public AutorRestController(CrudService<Autor, AutorDto> service) {
		super(service);
    }
		
}