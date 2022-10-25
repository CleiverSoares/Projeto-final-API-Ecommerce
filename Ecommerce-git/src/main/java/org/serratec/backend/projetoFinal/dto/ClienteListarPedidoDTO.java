package org.serratec.backend.projetoFinal.dto;

import org.serratec.backend.projetoFinal.domain.Cliente;

public class ClienteListarPedidoDTO {

	private Long id;
	private String nomeUsuario;
	private String nomeCompleto;

	public ClienteListarPedidoDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.nomeUsuario = cliente.getNomeCompleto();
	}

	public ClienteListarPedidoDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

}
