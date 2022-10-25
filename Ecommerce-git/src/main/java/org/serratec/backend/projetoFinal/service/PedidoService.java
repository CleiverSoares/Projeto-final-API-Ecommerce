package org.serratec.backend.projetoFinal.service;

import java.lang.module.FindException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.Cliente;
import org.serratec.backend.projetoFinal.domain.Pedido;
import org.serratec.backend.projetoFinal.dto.PedidoDTO;
import org.serratec.backend.projetoFinal.dto.PedidoInserirDTO;
import org.serratec.backend.projetoFinal.exception.PedidoException;
import org.serratec.backend.projetoFinal.repository.ClienteRepository;
import org.serratec.backend.projetoFinal.repository.PedidoRepository;
import org.serratec.backend.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	public List<PedidoDTO> listarTodos() {
//		List<Pedido> pedidos = pedidoRepository.findAll();
//		return pedidos.stream().map(pedido -> new ModelMapper().map(pedido, PedidoDTO.class))
//				.collect(Collectors.toList());
		List<Pedido> pedidos = pedidoRepository.findAll();
		List<PedidoDTO> pedidoDTOs = new ArrayList<>();

		for (Pedido pedido : pedidos) {
			pedidoDTOs.add(new PedidoDTO(pedido));
		}
		return pedidoDTOs;
	}

	public PedidoDTO listarPorId(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (!pedido.isPresent()) {
			return null;
		}
		return new PedidoDTO(pedido.get());
	}

	public PedidoDTO cadastrar(PedidoInserirDTO pedido) {
		Optional<Cliente> cliente = clienteRepository.findById(pedido.getCliente().getId());
		if (!cliente.isPresent()) {
			throw new FindException("Id de cliente não encontrado");
		}
		Pedido novoPedido = new Pedido();
		novoPedido.setDataPedido(LocalDate.now());
		novoPedido.setValorTotal(pedido.getValorTotal());
		novoPedido.setDataEnvio(pedido.getDataEnvio());
		novoPedido.setDataEntrega(pedido.getDataEntrega());
		novoPedido.setStatus(pedido.getStatus());
		novoPedido.setCliente(cliente.get());
		novoPedido = pedidoRepository.save(novoPedido);
		return new PedidoDTO(novoPedido);
	}

	public String deletarPorId(Long id) throws PedidoException {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (pedido.isPresent()) {
			pedidoRepository.deleteById(id);
			return "O pedido id: " + pedido.get() + " foi deletado com sucesso!";
		}
		throw new PedidoException("O id informado não foi encontrado!");
	}

//	public List<RelatorioDTO> relatorioProdutosMaisVendidos() {
//		return pedidoRepository.relatorioProdutosMaisVendidos();
//	}
}
