package org.serratec.backend.projetoFinal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.ItemPedido;
import org.serratec.backend.projetoFinal.domain.Pedido;
import org.serratec.backend.projetoFinal.dto.ItemPedidoDTO;
import org.serratec.backend.projetoFinal.dto.PedidoDTO;
import org.serratec.backend.projetoFinal.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<PedidoDTO> retornaTodasPedidos() {
		List<Pedido> listaPedido = pedidoRepository.findAll();
		List<PedidoDTO> listaPedidoDTO = new ArrayList<>();
		for (Pedido pedido : listaPedido) {
			PedidoDTO pedidoDTO = new PedidoDTO(pedido);
			PedidoDTO novoPedidoDTO = transformarEntityEmDto(pedido, pedidoDTO);
			listaPedidoDTO.add(novoPedidoDTO);
		}
		return listaPedidoDTO;
	}

	public PedidoDTO transformarEntityEmDto(Pedido pedido, PedidoDTO pedidoDTO) {
		pedidoDTO.setId(pedido.getId());
		pedidoDTO.setDataEntrega(pedido.getDataEntrega());
		pedidoDTO.setDataEnvio(pedido.getDataEnvio());
		pedidoDTO.setStatus(pedido.getStatus());
		pedidoDTO.setCliente(pedido.getCliente());
		pedidoDTO.setDataPedido(LocalDate.now());

		List<ItemPedidoDTO> itemPedidoDTOs = new ArrayList<>();
		for (ItemPedido itemPedido : pedido.getItemPedido()) {
			ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
			itemPedidoDTO.setId(itemPedido.getId());
			itemPedidoDTO.setPercentualDesconto(itemPedido.getPercentualDesconto());
			itemPedidoDTO.setPrecoVenda(itemPedido.getPrecoVenda());
			itemPedidoDTO.setQuantidade(itemPedido.getQuantidade());
			itemPedidoDTO.setValorBruto(itemPedido.getValorBruto());
			itemPedidoDTO.setValorLiquido(itemPedido.getValorLiquido());
//			itemPedidoDTO.setProdutoDTO(itemPedido.getProduto());
			itemPedidoDTOs.add(itemPedidoDTO);

//			ProdutoDTO produtoDTOs = new ProdutoDTO();
//			for (Produto itemPedidoDTO2 : ) {
//				ProdutoDTO produtoDTO = new ProdutoDTO();
//				itemPedidoDTO2.setCategoria(null);
//			}
		}
		pedidoDTO.setItemPedidoDTO(itemPedidoDTOs);
		return pedidoDTO;
	}
//	public PedidoDTO transformarEntityEmDto(Pedido pedido, PedidoDTO pedidoDTO) {
//		pedidoDTO.setId(pedido.getId());
//		pedidoDTO.setDataEntrega(pedido.getDataEntrega());
//		pedidoDTO.setDataEnvio(pedido.getDataEnvio());
//		pedidoDTO.setStatus(pedido.getStatus());
//		pedidoDTO.setCliente(pedido.getCliente());
//		pedidoDTO.setDataPedido(LocalDate.now());
//		
//		List<ItemPedidoDTO> itemPedidoDTOs = new ArrayList<>();
//		for (ItemPedido itemPedido : pedido.getItemPedido()) {
//			ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
//			itemPedidoDTO.setId(itemPedido.getId());
//			itemPedidoDTO.setPercentualDesconto(itemPedido.getPercentualDesconto());
//			itemPedidoDTO.setPrecoVenda(itemPedido.getPrecoVenda());
//			itemPedidoDTO.setQuantidade(itemPedido.getQuantidade());
//			itemPedidoDTO.setValorBruto(itemPedido.getValorBruto());
//			itemPedidoDTO.setValorLiquido(itemPedido.getValorLiquido());
//			itemPedidoDTO.setProdutoDTO(itemPedido.getProduto());
//			itemPedidoDTOs.add(itemPedidoDTO);
//		}
//		pedidoDTO.setItemPedidoDTO(itemPedidoDTOs);
//		return pedidoDTO;
//	}

	public Optional<Pedido> encontrarPedido(Long id) {
		return pedidoRepository.findById(id);
	}

	public Pedido salvarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public void deletarPedido(Long id) {
		Optional<Pedido> pedidoExistente = pedidoRepository.findById(id);
		if (pedidoExistente.isPresent())
			pedidoRepository.deleteById(id);
	}

}
