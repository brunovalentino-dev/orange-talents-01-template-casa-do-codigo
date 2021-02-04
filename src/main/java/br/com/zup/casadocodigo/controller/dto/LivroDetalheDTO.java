package br.com.zup.casadocodigo.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zup.casadocodigo.model.Livro;

public class LivroDetalheDTO {

	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private int numeroDePaginas;
	private String isbn;
	private AutorDTO autor;
	private LocalDate dataDePublicacao;

	public LivroDetalheDTO(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroDePaginas = livro.getNumeroDePaginas();
		this.isbn = livro.getIsbn();
		this.autor = new AutorDTO(livro.getAutor()); 	
		this.dataDePublicacao = livro.getDataDePublicacao();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}
	
}
