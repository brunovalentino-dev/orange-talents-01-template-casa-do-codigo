package br.com.zup.casadocodigo.controller.request;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.validation.annotation.RegistroExistente;
import br.com.zup.casadocodigo.validation.annotation.ValorUnico;

public class NovoEstadoRequest {

	@NotBlank
	@ValorUnico(campo = "nome", dominio = Estado.class)
	private String nome;
	
	@NotNull
	@RegistroExistente(campo = "id", dominio = Pais.class)	
	private Long paisId;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public NovoEstadoRequest(@NotBlank String nome, @NotNull Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}
	
	public Estado toEntity(EntityManager entityManager) {
		Pais pais = entityManager.find(Pais.class, this.paisId);
		
		return new Estado(this.nome, pais);
	}
	
}
