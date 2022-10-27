package org.serratec.backend.projetoFinal.dto;

import java.time.LocalDate;
import java.util.List;

import org.serratec.backend.projetoFinal.domain.Cliente;
import org.serratec.backend.projetoFinal.domain.Pedido;

public class PedidoDTO {

	private Long id;

	private LocalDate dataPedido;

	private LocalDate dataEntrega;

	private LocalDate dataEnvio;

	private String status;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

//	@OneToMany(mappedBy = "pedido")
	private List<ItemPedidoDTO> itemPedido;

	public PedidoDTO(Pedido pedido, List<ItemPedidoDTO> itemPedido) {
		super();
		this.id = pedido.getId();
		this.dataPedido = pedido.getDataPedido();
		this.dataEntrega = pedido.getDataEntrega();
		this.dataEnvio = pedido.getDataEnvio();
		this.status = pedido.getStatus();
		this.cliente = pedido.getCliente();
		this.itemPedido = itemPedido;
	}
	
	

	public PedidoDTO() {
		super();
	}



	public PedidoDTO(Pedido pedido) {
		super();
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

	public List<ItemPedidoDTO> getItemPedidoDTO() {
		return itemPedido;
	}

	public void setItemPedidoDTO(List<ItemPedidoDTO> itemPedido) {
		this.itemPedido = itemPedido;
	}

}
