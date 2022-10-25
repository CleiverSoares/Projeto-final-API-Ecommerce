package org.serratec.backend.projetoFinal.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.backend.projetoFinal.domain.ItemPedido;
import org.serratec.backend.projetoFinal.domain.Pedido;

public class PedidoDTO {

	private Long id;
	private LocalDate dataPedido;
	private LocalDate dataEnvio;
	private LocalDate dataEntrega;
	private String status;
	private List<ItemPedido> items = new ArrayList<>();
	private Double valorTotal;
	private ClienteListarPedidoDTO cliente;

	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.dataPedido = pedido.getDataPedido();
		this.dataEnvio = pedido.getDataEnvio();
		this.dataEntrega = pedido.getDataEntrega();
		this.status = pedido.getStatus();
		this.cliente = new ClienteListarPedidoDTO(pedido.getCliente());
		this.valorTotal = pedido.getValorTotal();
		for (ItemPedido item : pedido.getItems()) {
			items.add(item);
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ClienteListarPedidoDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteListarPedidoDTO cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}

//	idPedido”:””,
//	“dataPedido”:””,
//	“dataEntrega”:””,
//	“dataEnvio”:””,
//	“status”:””,
//	“cliente”:{

//package org.serratec.backend.projetoFinal.dto;
//
//import java.time.LocalDate;
//
//import org.serratec.backend.projetoFinal.domain.Cliente;
//
//public class PedidoDTO {
//
//	private LocalDate dataPedido;
//	private LocalDate dataEntrega;
//	private LocalDate dataEnvio;
//	private String status;
//	private Cliente cliente;
////	private List<ItensDto> listaProdutoPedido;
//
//	public PedidoDTO(LocalDate dataPedido, LocalDate dataEntrega, LocalDate dataEnvio, String status, Cliente cliente) {
//		super();
//		this.dataPedido = dataPedido;
//		this.dataEntrega = dataEntrega;
//		this.dataEnvio = dataEnvio;
//		this.status = status;
//		this.cliente = cliente;
//	}
//
//	public PedidoDTO() {
//		super();
//	}
//
//	public LocalDate getDataPedido() {
//		return dataPedido;
//	}
//
//	public void setDataPedido(LocalDate dataPedido) {
//		this.dataPedido = dataPedido;
//	}
//
//	public LocalDate getDataEntrega() {
//		return dataEntrega;
//	}
//
//	public void setDataEntrega(LocalDate dataEntrega) {
//		this.dataEntrega = dataEntrega;
//	}
//
//	public LocalDate getDataEnvio() {
//		return dataEnvio;
//	}
//
//	public void setDataEnvio(LocalDate dataEnvio) {
//		this.dataEnvio = dataEnvio;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public Cliente getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(Cliente cliente) {
//		this.cliente = cliente;
//	}
//
//}
