package br.com.zup.casadocodigo.controller.response;

import br.com.zup.casadocodigo.model.Estado;

public class NovoEstadoResponse {

	private String nome;

	public NovoEstadoResponse(Estado estado) {
		this.nome = estado.getNome();
	}

	@Override
	public String toString() {
		return "O estado " + nome + " foi cadastrado com sucesso!";
	}
	
}
