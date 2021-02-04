package br.com.zup.casadocodigo.controller.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.validation.annotation.ValorUnico;

public class NovaCategoriaRequest {

	@NotBlank
	@ValorUnico(campo = "nome", dominio = Categoria.class)
	private String nome;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public NovaCategoriaRequest(@NotBlank String nome) {
		this.nome = nome;
	}

	public Categoria toEntity() {
		return new Categoria(this.nome); 
	}
	
}
