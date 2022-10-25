package org.serratec.backend.projetoFinal.dto;

import org.serratec.backend.projetoFinal.domain.Cliente;

public class ClienteInserirPedidoDTO {

	private Long id;

	public ClienteInserirPedidoDTO(Cliente cliente) {
		this.id = cliente.getId();
	}

	public ClienteInserirPedidoDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
