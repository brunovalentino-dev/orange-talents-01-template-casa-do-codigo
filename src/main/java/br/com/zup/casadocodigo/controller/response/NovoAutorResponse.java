package br.com.zup.casadocodigo.controller.response;

import br.com.zup.casadocodigo.model.Autor;

public class NovoAutorResponse {

	private String nome;
	private String descricao;

	public NovoAutorResponse(Autor autor) {
		this.nome = autor.getNome();
		this.descricao = autor.getDescricao();
	}

	@Override
	public String toString() {
		return "O autor " + nome + " foi cadastrado com sucesso!"
				+ "\nDescrição: " + descricao;
	}
	
}
