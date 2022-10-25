package org.serratec.backend.projetoFinal.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.serratec.backend.projetoFinal.domain.Pedido;

public class PedidoInserirDTO {

	private Long id;

	@NotNull(message = "Digite uma data valida")
	private LocalDate dataEnvio;

	@NotNull(message = "Digite uma data valida")
	private LocalDate dataEntrega;

	@NotNull(message = "Digite um status valido")
	private String status;

	private LocalDate dataPedido;

	private Double valorTotal;

	private ClienteInserirPedidoDTO cliente;

	public PedidoInserirDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.dataEnvio = pedido.getDataEnvio();
		this.dataEntrega = pedido.getDataEntrega();
		this.status = pedido.getStatus();
		this.dataPedido = pedido.getDataPedido();
		this.cliente = new ClienteInserirPedidoDTO(pedido.getCliente());
		this.valorTotal = pedido.getValorTotal();
	}

	public PedidoInserirDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ClienteInserirPedidoDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteInserirPedidoDTO cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

}
