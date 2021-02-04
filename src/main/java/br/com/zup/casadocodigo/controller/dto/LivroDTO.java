package br.com.zup.casadocodigo.controller.dto;

public class LivroDTO {

	private Long id;	
	private String titulo;
	
	public LivroDTO(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

}
