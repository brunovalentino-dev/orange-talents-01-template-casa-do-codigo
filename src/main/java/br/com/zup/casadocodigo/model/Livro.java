package br.com.zup.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true, nullable = false)
	private String titulo;
	
	@NotBlank
	@Column(nullable = false)
	@Length(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull
	@Column(nullable = false)
	@Min(value = 20L)
	private BigDecimal preco;
	
	@NotNull
	@Column(nullable = false)
	@Min(value = 100)
	private int numeroDePaginas;
	
	@NotBlank
	@Column(unique = true, nullable = false)
	private String isbn;
	
	@NotNull @Future	
	@Column(nullable = false) @JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	private LocalDate dataDePublicacao;
	
	@NotNull
	@ManyToOne
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	private Autor autor;
	
	@Deprecated
	public Livro() {}

	public Livro(String titulo, String resumo, String sumario, BigDecimal preco,
			int numeroDePaginas, String isbn, LocalDate dataDePublicacao, 
			Categoria categoria, Autor autor) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.categoria = categoria;
		this.autor = autor;
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

	public LocalDate getDataDePublicacao() {
		return dataDePublicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numeroDePaginas=" + numeroDePaginas + ", isbn=" + isbn + ", dataDePublicacao="
				+ dataDePublicacao + ", categoria=" + categoria + ", autor=" + autor + "]";
	}
	
}
