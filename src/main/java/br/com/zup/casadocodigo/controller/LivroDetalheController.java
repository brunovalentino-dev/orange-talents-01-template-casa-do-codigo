package br.com.zup.casadocodigo.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.controller.dto.LivroDetalheDTO;
import br.com.zup.casadocodigo.model.Livro;

@RestController
@RequestMapping("/livros/{id}")
public class LivroDetalheController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("/detalhes")
	public ResponseEntity<?> buscarLivrosPeloID(@PathVariable Long id) {
		Livro livroEncontrado = entityManager.find(Livro.class, id);
		
		if (livroEncontrado != null) {
			return ResponseEntity.ok(new LivroDetalheDTO(livroEncontrado));
		}

		return ResponseEntity.notFound().build();
	}
	
}
