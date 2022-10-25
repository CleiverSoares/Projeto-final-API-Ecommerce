package org.serratec.backend.projetoFinal.controller;

import java.lang.module.FindException;
import java.util.List;

import org.serratec.backend.projetoFinal.dto.PedidoDTO;
import org.serratec.backend.projetoFinal.dto.PedidoInserirDTO;
import org.serratec.backend.projetoFinal.exception.PedidoException;
import org.serratec.backend.projetoFinal.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> listarTodos() {
		return ResponseEntity.ok(pedidoService.listarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long id) throws PedidoException {
		return ResponseEntity.ok(pedidoService.listarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Object> cadastrar(@RequestBody PedidoInserirDTO pedido) {
		try {
			PedidoDTO pedidoDTO = pedidoService.cadastrar(pedido);
			return ResponseEntity.ok(pedidoDTO);
		} catch (FindException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarPorId(@PathVariable Long id) throws PedidoException {
		return ResponseEntity.ok(pedidoService.deletarPorId(id));
	}

}
