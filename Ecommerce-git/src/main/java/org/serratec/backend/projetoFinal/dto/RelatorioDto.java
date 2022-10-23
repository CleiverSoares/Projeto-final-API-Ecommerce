package org.serratec.backend.projetoFinal.dto;

import java.time.LocalDate;

import org.serratec.backend.projetoFinal.domain.ItemPedido;
import org.serratec.backend.projetoFinal.domain.Pedido;
import org.serratec.backend.projetoFinal.domain.Produto;

public class RelatorioDto {

	private Long idPedido;
	private LocalDate dataPedido;
	private Double valorTotal;
	private Long codigoProduto;
	private String nomeProduto;
	private Integer precoVenda;
	private Integer quantidade;
	private Integer valorBruto;
	private Integer percentualDesconto;
	private Integer valorLiquido;



	public RelatorioDto(Pedido pedido) {
		this.idPedido = pedido.getId();
		this.dataPedido = pedido.getDataPedido();
		this.valorTotal = pedido.getValorTotal();

	}

	public RelatorioDto(Produto produto) {
		this.codigoProduto = produto.getId();
		this.nomeProduto = produto.getNome();

	}

	public RelatorioDto(ItemPedido itemPedido) {
		this.precoVenda = itemPedido.getPrecoVenda();
		this.quantidade = itemPedido.getQuantidade();
		this.valorBruto = itemPedido.getValorBruto();
		this.percentualDesconto = itemPedido.getPercentualDesconto();
		this.valorLiquido = itemPedido.getValorLiquido();

	}

	public RelatorioDto(Long idPedido, LocalDate dataPedido, Double valorTotal, Long codigoProduto, String nomeProduto,
			Integer precoVenda, Integer quantidade, Integer valorBruto, Integer percentualDesconto,
			Integer valorLiquido) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.codigoProduto = codigoProduto;
		this.nomeProduto = nomeProduto;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.valorBruto = valorBruto;
		this.percentualDesconto = percentualDesconto;
		this.valorLiquido = valorLiquido;
	}

	
	
	@Override
	public String toString() {
		return "RelatorioDto [idPedido=" + idPedido + ", dataPedido=" + dataPedido + ", valorTotal=" + valorTotal
				+ ", codigoProduto=" + codigoProduto + ", nomeProduto=" + nomeProduto + ", precoVenda=" + precoVenda
				+ ", quantidade=" + quantidade + ", valorBruto=" + valorBruto + ", percentualDesconto="
				+ percentualDesconto + ", valorLiquido=" + valorLiquido + "]";
	}

	public RelatorioDto() {
		super();
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Integer precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Integer valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Integer getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Integer percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Integer getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Integer valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

}
