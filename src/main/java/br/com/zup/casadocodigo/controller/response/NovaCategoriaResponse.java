package br.com.zup.casadocodigo.controller.response;

import br.com.zup.casadocodigo.model.Categoria;

public class NovaCategoriaResponse {

	private String nome;

	public NovaCategoriaResponse(Categoria categoria) {
		this.nome = categoria.getNome();
	}

	@Override
	public String toString() {
		return "A categoria " + nome + " foi cadastrada com sucesso!";
	}
	
}
