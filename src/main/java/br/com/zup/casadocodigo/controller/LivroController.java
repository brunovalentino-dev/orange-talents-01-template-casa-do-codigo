package br.com.zup.casadocodigo.controller;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.dto.LivroDTO;
import br.com.zup.casadocodigo.controller.request.NovoLivroRequest;
import br.com.zup.casadocodigo.controller.response.NovoLivroResponse;
import br.com.zup.casadocodigo.model.Livro;

@RestController
@RequestMapping("/livros")
public class LivroController {

	private static final String LIVRO_DTO = "br.com.zup.casadocodigo.controller.dto.LivroDTO";
	
	@PersistenceContext
	private EntityManager entityManager;
		
	@PostMapping
	@Transactional
	public String cadastrarNovoLivro(@RequestBody @Valid NovoLivroRequest request) {
		Livro livro = request.toEntity(entityManager);
		
		entityManager.persist(livro);
		
		return new NovoLivroResponse(livro).toString();
	}
	
	@GetMapping
	public List<LivroDTO> buscarLivros() {
		String queryString = 
				"SELECT NEW " + LIVRO_DTO + "(l.id, l.titulo) FROM Livro l ORDER BY l.id ASC";
		
		TypedQuery<LivroDTO> query = entityManager.createQuery(queryString, LivroDTO.class);

		List<LivroDTO> livrosEncontrados = Collections.unmodifiableList(query.getResultList());

		return livrosEncontrados;
	}
	
}
