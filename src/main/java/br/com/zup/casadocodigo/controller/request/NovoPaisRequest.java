package br.com.zup.casadocodigo.controller.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.validation.annotation.ValorUnico;

public class NovoPaisRequest {

	@NotBlank
	@ValorUnico(campo = "nome", dominio = Pais.class)
	private String nome;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public NovoPaisRequest(@NotBlank String nome) {
		this.nome = nome;
	}
	
	public Pais toEntity() {
		return new Pais(this.nome);
	}
	
}
