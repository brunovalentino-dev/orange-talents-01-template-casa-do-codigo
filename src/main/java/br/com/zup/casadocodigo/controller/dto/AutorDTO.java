package br.com.zup.casadocodigo.controller.dto;

import br.com.zup.casadocodigo.model.Autor;

public class AutorDTO {

	private String nome;
	private String descricao;

	public AutorDTO(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
