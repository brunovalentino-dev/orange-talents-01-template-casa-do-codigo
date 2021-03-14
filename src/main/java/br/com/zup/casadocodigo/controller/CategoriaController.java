package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.request.NovaCategoriaRequest;
import br.com.zup.casadocodigo.controller.response.NovaCategoriaResponse;
import br.com.zup.casadocodigo.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostMapping
	@Transactional
	public String cadastrarNovaCategoria(@RequestBody @Valid NovaCategoriaRequest request) {
		Categoria categoria = request.toEntity();
		
		entityManager.persist(categoria);
		
		return new NovaCategoriaResponse(categoria).toString();
	}
	
}
