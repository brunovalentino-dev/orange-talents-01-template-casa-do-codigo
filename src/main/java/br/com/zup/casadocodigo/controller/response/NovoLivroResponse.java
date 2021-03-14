package br.com.zup.casadocodigo.controller.response;

import br.com.zup.casadocodigo.model.Livro;

public class NovoLivroResponse {

	private String titulo;

	public NovoLivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
	}

	@Override
	public String toString() {
		return "O livro " + titulo + " foi cadastrado com sucesso!";
	}
	
}
