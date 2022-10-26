package org.serratec.backend.projetoFinal.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.ItemPedido;
import org.serratec.backend.projetoFinal.domain.Pedido;
import org.serratec.backend.projetoFinal.dto.ItemPedidoDTO;
import org.serratec.backend.projetoFinal.dto.PedidoDTO;
import org.serratec.backend.projetoFinal.dto.PedidoInserirDTO;
import org.serratec.backend.projetoFinal.dto.PedidoItemInserirDTO;
import org.serratec.backend.projetoFinal.repository.ClienteRepository;
import org.serratec.backend.projetoFinal.repository.PedidoRepository;
import org.serratec.backend.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutoRepository produtoRepository;

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
		pedidoDTO.setCliente(clienteRepository.findById(pedido.getCliente().getId()).get());
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
			itemPedidoDTO.setProdutoDTO(produtoService.adicionarImagemUri(itemPedido.getProduto()));
			itemPedidoDTOs.add(itemPedidoDTO);
		}
		pedidoDTO.setItemPedidoDTO(itemPedidoDTOs);
		return pedidoDTO;
	}

	public Optional<Pedido> encontrarPedido(Long id) {
		return pedidoRepository.findById(id);
	}

	public Pedido salvarPedido(PedidoInserirDTO pedidoInserirDTO) {
		Pedido pedido = new Pedido();
		pedido.setDataEntrega(pedidoInserirDTO.getDataEntrega());
		pedido.setDataEnvio(pedidoInserirDTO.getDataEnvio());
		pedido.setDataPedido(pedidoInserirDTO.getDataPedido());
		pedido.setCliente(pedidoInserirDTO.getCliente());
		pedido.setStatus(pedidoInserirDTO.getStatus());

		Double total = 0.0;
		
		List<ItemPedido> itemPedidos = new ArrayList<>();
		for (PedidoItemInserirDTO pedidoItemInserirDTO : pedidoInserirDTO.getPedidoItemInserirDTO()) {
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setPedido(pedido);
			itemPedido.setPercentualDesconto(pedidoItemInserirDTO.getPercentualDesconto());
			itemPedido.setProduto(produtoRepository.findById(pedidoItemInserirDTO.getProduto().getId()).get());
			
			Double valorDeVenda = itemPedido.getProduto().getValorUnitario();
			Double valorBruto = valorDeVenda * pedidoItemInserirDTO.getQuantidade();
			Double valorLiquido = valorBruto - valorBruto * pedidoItemInserirDTO.getPercentualDesconto();

			total += valorLiquido;
					
			itemPedido.setQuantidade(pedidoItemInserirDTO.getQuantidade());
			itemPedido.setValorBruto(valorBruto);
			itemPedido.setValorLiquido(valorLiquido);
			itemPedido.setPrecoVenda(total);

			itemPedidos.add(itemPedido);

		}

 	    pedido.setValorTotal(total);
		pedido.setItemPedido(itemPedidos);
		
		return pedidoRepository.save(pedido);
	}

	public void deletarPedido(Long id) {
		Optional<Pedido> pedidoExistente = pedidoRepository.findById(id);
		if (pedidoExistente.isPresent())
			pedidoRepository.deleteById(id);
	}

	public void salvarPedido(@Valid Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

}
