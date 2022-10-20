package org.serratec.ecommerce.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;

	@NotNull(message = "Digite a data do pedido:")
	@Column(nullable = false, name = "data_pedido")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPedido;

	@NotNull(message = "Digite a data de entrega:")
	@Column(name = "data_entrega")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEntrega;

	@NotNull(message = "Digite a data de envio:")
	@Column(name = "data_envio")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEnvio;

	@Size(max = 20, message = "Esse atributo não pode ter mais que 20 caracter")
	@Column(nullable = true, length = 20)
	private String status;

	@NotNull(message = "Digite o valor total")
	@Column(name = "valor_total")
	private Double valorTotal;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	public Pedido() {
		super();
	}

	public Pedido(Long id, @NotNull(message = "Digite a data do pedido:") LocalDate dataPedido,
			@NotNull(message = "Digite a data de entrega:") LocalDate dataEntrega,
			@NotNull(message = "Digite a data de envio:") LocalDate dataEnvio,
			@Size(max = 20, message = "Esse atributo não pode ter mais que 20 caracter") String status,
			@NotNull(message = "Digite o valor total") Double valorTotal, Cliente cliente) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
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

}
