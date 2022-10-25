package org.serratec.backend.projetoFinal.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item_pedido", schema = "public")
public class ItemPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Long id;

	@NotNull
	@Column(nullable = false)
	private Integer quantidade;

	@NotNull
	@Column(name = "preco_venda", nullable = false)
	private Integer precoVenda;

	@NotNull
	@Column(name = "percentual_desconto", nullable = false)
	private Integer percentualDesconto;

	@NotNull
	@Column(name = "valor_bruto", nullable = false)
	private Integer valorBruto;

	@NotNull
	@Column(name = "valor_liquido", nullable = false)
	private Integer valorLiquido;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_produto")
	private Produto produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Integer precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Integer percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Integer getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Integer valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Integer getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Integer valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
