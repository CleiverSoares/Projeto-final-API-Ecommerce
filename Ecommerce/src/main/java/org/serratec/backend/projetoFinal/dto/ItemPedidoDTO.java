package org.serratec.backend.projetoFinal.dto;

import org.serratec.backend.projetoFinal.domain.ItemPedido;

public class ItemPedidoDTO {

	private Long id;

	private Integer quantidade;

	private Double precoVenda;

	private Double percentualDesconto;

	private Double valorBruto;

	private Double valorLiquido;

	private ProdutoDTO produtoDTO;


	public ItemPedidoDTO(ItemPedido ItemPedido, ProdutoDTO produtoDTO) {
		super();
		this.id = ItemPedido.getId();
		this.quantidade = ItemPedido.getQuantidade();
		this.precoVenda = ItemPedido.getPrecoVenda();
		this.percentualDesconto = ItemPedido.getPercentualDesconto();
		this.valorBruto = ItemPedido.getValorBruto();
		this.valorLiquido = ItemPedido.getValorLiquido();
		this.produtoDTO = produtoDTO;
	}

	public ItemPedidoDTO() {
		super();
	}

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

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Double getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Double getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public ProdutoDTO getProdutoDTO() {
		return produtoDTO;
	}

	public void setProdutoDTO(ProdutoDTO produtoDTO) {
		this.produtoDTO = produtoDTO;
	}

}
