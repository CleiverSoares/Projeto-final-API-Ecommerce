package org.serratec.backend.projetoFinal.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projetoFinal.domain.ItemPedido;
import org.serratec.backend.projetoFinal.domain.Pedido;

public class RelatorioDTO {

	private Long idPedido;
	private LocalDate dataPedido;
	private Double valorTotal;
	private List<ItemPedidoRelatorioDTO> itemPedidoRelatorioDTOs;
	private String email;

	public RelatorioDTO(Pedido pedido) {
		super();
		this.idPedido = pedido.getId();
		this.dataPedido = pedido.getDataPedido();
		this.valorTotal = pedido.getValorTotal();
		this.email = pedido.getCliente().getEmail();

		List<ItemPedido> listaItemPedidos = new ArrayList<>(pedido.getItemPedido());
		List<ItemPedidoRelatorioDTO> itemPedidoRelatorioDTO = new ArrayList<>();
		for (ItemPedido itemPedido : listaItemPedidos) {
			itemPedidoRelatorioDTO.add(new ItemPedidoRelatorioDTO(itemPedido));

		}
		this.itemPedidoRelatorioDTOs = itemPedidoRelatorioDTO;

	}

	public RelatorioDTO() {
		super();
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public List<ItemPedidoRelatorioDTO> getItemPedidoRelatorioDTOs() {
		return itemPedidoRelatorioDTOs;
	}

	public void setItemPedidoRelatorioDTOs(List<ItemPedidoRelatorioDTO> itemPedidoRelatorioDTOs) {
		this.itemPedidoRelatorioDTOs = itemPedidoRelatorioDTOs;
	}

	@Override
	public String toString() {
		return "RelatorioDTO [idPedido=" + idPedido + ", dataPedido=" + dataPedido + ", valorTotal=" + valorTotal
				+ ", email=" + email + "]";
	}


	

	
}
