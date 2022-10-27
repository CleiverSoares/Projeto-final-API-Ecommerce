package org.serratec.backend.projetoFinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Pedido;
import org.serratec.backend.projetoFinal.dto.PedidoDTO;
import org.serratec.backend.projetoFinal.dto.PedidoInserirDTO;
import org.serratec.backend.projetoFinal.exception.EmailException;
import org.serratec.backend.projetoFinal.exception.PedidoException;
import org.serratec.backend.projetoFinal.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> retornaTodasPedidos() {
		List<PedidoDTO> todosPedidos = service.retornaTodasPedidos();
		if (!todosPedidos.isEmpty()) {
			return ResponseEntity.ok(todosPedidos);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	
	
	public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long id) throws PedidoException {
	        return ResponseEntity.ok(service.encontrarPedidoDTO(id));
	    }
//	public ResponseEntity<Pedido> getPedido(@PathVariable Long id) {
//		Optional<Pedido> pedidoExistente = service.encontrarPedido(id);
//		if (pedidoExistente.isPresent()) {
//			return ResponseEntity.ok(pedidoExistente.get());
//		}
//		return ResponseEntity.notFound().build();
//	}

	
	
	@PostMapping
	public ResponseEntity<Pedido> salvar(@Valid @RequestBody PedidoInserirDTO pedido) throws EmailException {
		Pedido pedidoSalva = service.salvarPedido(pedido);

		return new ResponseEntity<>(pedidoSalva, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @Valid @RequestBody Pedido pedido) {
		Optional<Pedido> pedidoExistente = service.encontrarPedido(id);
		if (!pedidoExistente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		pedido.setId(id);
		service.salvarPedido(pedido);
		return ResponseEntity.ok(pedidoExistente.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
		Optional<Pedido> pedidoExistente = service.encontrarPedido(id);
		if (pedidoExistente.isPresent()) {
			service.deletarPedido(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
