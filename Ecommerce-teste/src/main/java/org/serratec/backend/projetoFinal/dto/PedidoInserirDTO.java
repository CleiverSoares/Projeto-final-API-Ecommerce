package org.serratec.backend.projetoFinal.dto;

import java.time.LocalDate;
import java.util.List;

import org.serratec.backend.projetoFinal.domain.Cliente;

public class PedidoInserirDTO {

	private LocalDate dataPedido;
	
	private LocalDate dataEntrega;
	
	private LocalDate dataEnvio;
	
	private String status;

	private Cliente cliente;
	
	private List<PedidoItemInserirDTO> pedidoItemInserirDTO;

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public LocalDate getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(LocalDate dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<PedidoItemInserirDTO> getPedidoItemInserirDTO() {
		return pedidoItemInserirDTO;
	}

	public void setPedidoItemInserirDTO(List<PedidoItemInserirDTO> pedidoItemInserirDTO) {
		this.pedidoItemInserirDTO = pedidoItemInserirDTO;
	}

}
