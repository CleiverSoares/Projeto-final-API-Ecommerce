package org.serratec.ecommerce.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@NotBlank(message = "Prencher nome")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String nome;

	@Size(max = 200)
	@Column(nullable = true, length = 200)
	private String descricao;

	@NotNull
	@Column(nullable = false, name = "qtd_estoque")
	private Integer qtdEstoque;

	@NotBlank
	@Column(nullable = false, name = "data_cadatro")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeCadastro;

	@NotNull
	@Column(nullable = false, name = "valor_unitario")
	private Double valorUnitario;

	@Lob
	@Column(nullable = false)
	private byte[] imagem;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;

	public Produto() {
		super();
	}

	public Produto(Long id, @NotBlank(message = "Prencher nome") @Size(max = 30) String nome,
			@Size(max = 200) String descricao, @NotNull Integer qtdEstoque, @NotBlank LocalDate dataDeCadastro,
			@NotNull Double valorUnitario, byte[] imagem, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataDeCadastro = dataDeCadastro;
		this.valorUnitario = valorUnitario;
		this.imagem = imagem;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(LocalDate dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
