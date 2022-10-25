package org.serratec.backend.projetoFinal.dto;

import org.serratec.backend.projetoFinal.domain.Produto;

public class ItensDto {

	private Integer quantidade;
	private Double percentualDesconto;
	private Produto Produto;

	public ItensDto(Integer quantidade, Double percentualDesconto,
			org.serratec.backend.projetoFinal.domain.Produto produto) {
		super();
		this.quantidade = quantidade;
		this.percentualDesconto = percentualDesconto;
		Produto = produto;
	}

	public ItensDto() {
		super();
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Produto getProduto() {
		return Produto;
	}

	public void setProduto(Produto produto) {
		Produto = produto;
	}

}
