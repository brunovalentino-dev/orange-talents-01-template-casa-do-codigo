package br.com.zup.casadocodigo.controller.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.Livro;
import br.com.zup.casadocodigo.validation.annotation.RegistroExistente;
import br.com.zup.casadocodigo.validation.annotation.ValorUnico;

public class NovoLivroRequest {

	@NotBlank
	@ValorUnico(campo = "titulo", dominio = Livro.class)
	private String titulo;
	
	@NotBlank
	@Length(max = 500)
	private String resumo;
	
	private String sumario;
	
	@NotNull
	@Min(value = 20L)
	private BigDecimal preco;
	
	@NotNull
	@Min(value = 100)
	private int numeroDePaginas;
	
	@NotBlank
	@ValorUnico(campo = "isbn", dominio = Livro.class)
	private String isbn;
	
	@NotNull
	@Future
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	private LocalDate dataDePublicacao;
	
	@NotNull	
	@RegistroExistente(campo = "id", dominio = Categoria.class)	
	private Long categoriaId;
	
	@NotNull
	@RegistroExistente(campo = "id", dominio = Autor.class)	
	private Long autorId;

	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public NovoLivroRequest(@NotBlank String titulo, @NotBlank @Length(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroDePaginas, @NotBlank String isbn,
			@NotNull @Future LocalDate dataDePublicacao, @NotNull Long categoriaId, @NotNull Long autorId) {
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroDePaginas = numeroDePaginas;
		this.isbn = isbn;
		this.dataDePublicacao = dataDePublicacao;
		this.categoriaId = categoriaId;
		this.autorId = autorId;
	}

	public Livro toEntity(EntityManager entityManager) {
		Autor autor = entityManager.find(Autor.class, this.autorId);
		Categoria categoria = entityManager.find(Categoria.class, this.categoriaId);
		
		return new Livro(this.titulo, this.resumo, this.sumario,
				this.preco, this.numeroDePaginas, this.isbn,
				this.dataDePublicacao, categoria, autor);
	}
	
}