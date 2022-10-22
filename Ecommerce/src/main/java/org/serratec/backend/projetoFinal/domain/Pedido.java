package org.serratec.backend.projetoFinal.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;

	@NotBlank(message = "Digete a data do pedido.")
	@Column(name = "data_pedido", nullable = false)
	private LocalDate dataPedido;

	@Column(name = "data_entrega")
	private LocalDate dataEntrega;

	@Column(name = "data_envio")
	private LocalDate dataEnvio;

	@NotBlank(message = "Digete o status")
	@Size(max = 1, message = "Status tem que ser {max} caracter")
	@Column(name = "status", length = 1)
	private String status;

	@Column(name = "valor_total")
	private Double valorTotal;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_pedido")
	private List<ItemPedido> itemPedido;

	public Pedido(Long id, @NotBlank(message = "Digete a data do pedido.") LocalDate dataPedido, LocalDate dataEntrega,
			LocalDate dataEnvio,
			@NotBlank(message = "Digete o status") @Size(max = 1, message = "Status tem que ser {max} caracter") String status,
			Double valorTotal, Cliente cliente, List<ItemPedido> itemPedido) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.itemPedido = itemPedido;
	}

	public Pedido() {
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

}
