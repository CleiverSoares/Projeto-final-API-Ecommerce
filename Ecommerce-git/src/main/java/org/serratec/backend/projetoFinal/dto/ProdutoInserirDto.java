package org.serratec.backend.projetoFinal.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.serratec.backend.projetoFinal.domain.Categoria;

public class ProdutoInserirDto {

	@NotBlank(message = "Prencher o nome completo")
	@Size(max = 30, message = "Tamanho máximo do nome deve ser de {max} caracteres.")
	private String nome;

	private String url;

	@NotBlank(message = "Prencher a descrição.")
	@Size(max = 200, message = "Tamanho máximo da descrição deve ser de {max} caracteres.")
	private String descricao;

	@NotNull(message = "Preencher a quantidade em estoque.")
	private Integer qtdEstoque;

	@NotNull(message = "Preencher a quantidade em estoque.")
	private Double valorUnitario;

	@NotNull(message = "Preencher a categoria.")
	private Categoria categoria;

	public ProdutoInserirDto(
			@NotBlank(message = "Prencher o nome completo") @Size(max = 30, message = "Tamanho máximo do nome deve ser de {max} caracteres.") String nome,
			String url,
			@NotBlank(message = "Prencher a descrição.") @Size(max = 200, message = "Tamanho máximo da descrição deve ser de {max} caracteres.") String descricao,
			@NotNull(message = "Preencher a quantidade em estoque.") Integer qtdEstoque,
			@NotNull(message = "Preencher a quantidade em estoque.") Double valorUnitario,
			@NotNull(message = "Preencher a categoria.") Categoria categoria) {
		super();
		this.nome = nome;
		this.url = url;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.valorUnitario = valorUnitario;
		this.categoria = categoria;
	}

	public ProdutoInserirDto() {

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoInserirDto other = (ProdutoInserirDto) obj;
		return Objects.equals(descricao, other.descricao);
	}

}
