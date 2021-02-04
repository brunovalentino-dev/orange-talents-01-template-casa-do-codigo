package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.request.NovoAutorRequest;
import br.com.zup.casadocodigo.model.Autor;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String cadastrarNovoAutor(@RequestBody @Valid NovoAutorRequest request) {
		Autor novoAutor = request.toEntity();
		
		entityManager.persist(novoAutor);
		
		return novoAutor.toString();
	}
	
}
