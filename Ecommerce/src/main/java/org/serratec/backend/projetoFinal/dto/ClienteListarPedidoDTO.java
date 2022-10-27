package org.serratec.backend.projetoFinal.dto;

import org.serratec.backend.projetoFinal.domain.Cliente;

public class ClienteListarPedidoDTO {

	private Long id;

	public ClienteListarPedidoDTO(Cliente cliente) {
		this.id = cliente.getId();
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

}
