package org.serratec.backend.projetoFinal.dto;

import org.serratec.backend.projetoFinal.domain.ItemPedido;
import org.serratec.backend.projetoFinal.domain.Produto;

public class ItemPedidoRelatorioDTO {

	private String NomeProduto;
	
	private Integer quantidade;

	private Double precoVenda;

	private Double percentualDesconto;

	private Double valorBruto;

	private Double valorLiquido;
	

	public ItemPedidoRelatorioDTO(Produto produto, ItemPedido itemPedido) {
		super();
		this.NomeProduto = produto.getNome();
		this.quantidade = itemPedido.getQuantidade();
		this.precoVenda = itemPedido.getPrecoVenda();
		this.percentualDesconto = itemPedido.getPercentualDesconto();
		this.valorBruto = itemPedido.getValorBruto();
		this.valorLiquido = itemPedido.getValorLiquido();
		
	}
	public ItemPedidoRelatorioDTO( ItemPedido itemPedido) {
	super();
		this.NomeProduto = itemPedido.getProduto().getNome();
		this.quantidade = itemPedido.getQuantidade();
		this.precoVenda = itemPedido.getPrecoVenda();
		this.percentualDesconto = itemPedido.getPercentualDesconto();
		this.valorBruto = itemPedido.getValorBruto();
		this.valorLiquido = itemPedido.getValorLiquido();
		
	}
	
	


	public ItemPedidoRelatorioDTO() {
		super();
	}






	public String getNomeProduto() {
		return NomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		NomeProduto = nomeProduto;
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



	@Override
	public String toString() {
		return "ItemPedidoRelatorioDTO [NomeProduto=" + NomeProduto + ", quantidade=" + quantidade + ", precoVenda="
				+ precoVenda + ", percentualDesconto=" + percentualDesconto + ", valorBruto=" + valorBruto
				+ ", valorLiquido=" + valorLiquido + "]";
	}

	
	 

}
