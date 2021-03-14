package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.request.NovoPaisRequest;
import br.com.zup.casadocodigo.controller.response.NovoPaisResponse;
import br.com.zup.casadocodigo.model.Pais;

@RestController
@RequestMapping("/paises")
public class PaisController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String cadastrarNovoPais(@RequestBody @Valid NovoPaisRequest request) {
		Pais pais = request.toEntity();
		
		entityManager.persist(pais);

		return new NovoPaisResponse(pais).toString();
	}
	
}
