package br.com.zup.casadocodigo.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;

import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.validation.annotation.DocumentoValido;
import br.com.zup.casadocodigo.validation.annotation.RegistroExistente;

public class NovaCompraRequest {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;	
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@DocumentoValido
	private String documento;	
	
	@NotBlank
	private String rua;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotNull
	@RegistroExistente(campo = "id", dominio = Pais.class)	
	private Long paisId;

	private Long estadoId;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public NovaCompraRequest(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank @Email String email,
			@NotBlank String documento, @NotBlank String rua, @NotBlank String complemento, @NotBlank String cidade,
			@NotNull Long paisId, Long estadoId, @NotBlank String telefone, @NotBlank String cep) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.documento = documento;
		this.rua = rua;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	@Override
	public String toString() {
		return "NovaCompraRequest [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", documento="
				+ documento + ", rua=" + rua + ", complemento=" + complemento + ", cidade=" + cidade + ", paisId="
				+ paisId + ", estadoId=" + estadoId + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

}
