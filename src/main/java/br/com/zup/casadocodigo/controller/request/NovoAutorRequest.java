package br.com.zup.casadocodigo.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.validation.annotation.ValorUnico;

public class NovoAutorRequest {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	@ValorUnico(campo = "email", dominio = Autor.class)
	private String email;
	
	@NotBlank
	@Length(max = 400)
	private String descricao;
	
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email,
			@NotBlank @Length(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toEntity() {
		return new Autor(this.nome, this.email, this.descricao); 
	}

}
