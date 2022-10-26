package org.serratec.backend.projetoFinal.domain;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@Size(min = 3, max = 30, message = "Nome do produto deve ser entre {min} e {max} caracteres")
	@NotBlank(message = "Preencha o nome")
	@Column(nullable = false, length = 30, unique = true)
	private String nome;

	@Size(min = 3, max = 200, message = "Descriçao deve ser entre {min} e {max} caracteres")
	@Column(nullable = true, length = 200)
	private String descricao;

	@NotNull(message = "Quantidade de estoque deve ser preenchido")
	@Column(nullable = false, name = "qtd_estoque")
	private Integer qtdEstoque;

//	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(nullable = false, name = "data_cadastro ")
	private LocalDate dataCadastro;

	@NotNull(message = "Valor unitário deve ser preenchido")
	@Column(nullable = false, name = "valor_unitario")
	private Double valorUnitario;

	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	@Column(nullable = false)
	private byte[] imagem;

	@Column(length = 80, name = "tipo_imagem")
	private String tipoImagem;

//	@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria categoria;

//	public Produto(ProdutoInserirDto produtoInserirDto, Long id) {
//		super();
//		this.id = id;
//		this.nome = produtoInserirDto.getNome();
//		this.descricao = produtoInserirDto.getDescricao();
//		this.qtdEstoque = produtoInserirDto.getQtdEstoque();
//		this.dataCadastro = LocalDate.now();
//		this.valorUnitario = produtoInserirDto.getValorUnitario();
//		this.categoria = produtoInserirDto.getCategoria();
//	}

	public Produto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoImagem() {
		return tipoImagem;
	}

	public void setTipoImagem(String tipoImagem) {
		this.tipoImagem = tipoImagem;
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
		return Objects.hash(descricao, id);
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
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}

}
