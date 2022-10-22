package org.serratec.backend.projetoFinal.dto;

import java.time.LocalDate;
import java.util.Objects;

import org.serratec.backend.projetoFinal.domain.Categoria;

public class ProdutoInserirDto {

	private Long idProduto;
	private String nome;
	private String descricao;
	private Integer qtdEstoque;
	private LocalDate dataCadastro;
	private Integer valorUnitario;
	private Categoria categoria;
	private String email;
	private String url;

	public ProdutoInserirDto(Long idProduto, String nome, String descricao, Integer qtdEstoque, LocalDate dataCadastro,
			Integer valorUnitario, Categoria categoria, String email, String url) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.categoria = categoria;
		this.email = email;
		this.url = url;
	}


	public ProdutoInserirDto() {
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
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

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Integer getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Integer valorUnitario) {
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
		return Objects.hash(descricao, idProduto);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		return Objects.equals(descricao, other.descricao) && Objects.equals(idProduto, other.idProduto);
	}

}
