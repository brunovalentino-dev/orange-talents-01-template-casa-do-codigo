package br.com.zup.casadocodigo.controller.response;

import br.com.zup.casadocodigo.model.Pais;

public class NovoPaisResponse {

	private String nome;

	public NovoPaisResponse(Pais pais){		
		this.nome = pais.getNome();
	}

	@Override
	public String toString() {
		return "O país " + nome + " foi cadastrado com sucesso!";
	}	
	
}
