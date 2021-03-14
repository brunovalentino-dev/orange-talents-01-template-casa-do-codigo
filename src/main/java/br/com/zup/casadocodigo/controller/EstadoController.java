package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.request.NovoEstadoRequest;
import br.com.zup.casadocodigo.controller.response.NovoEstadoResponse;
import br.com.zup.casadocodigo.model.Estado;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String cadastrarNovoEstado(@RequestBody @Valid NovoEstadoRequest request) {
		Estado estado = request.toEntity(entityManager);
		
		entityManager.persist(estado);
		
		return new NovoEstadoResponse(estado).toString();
	}
	
}
