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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@GetMapping
	@ApiOperation(value = "Lista todas os pedidos", notes = "Listagem de pedidos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os pedidos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<List<PedidoDTO>> retornaTodasPedidos() {
		List<PedidoDTO> todosPedidos = service.retornaTodasPedidos();
		if (!todosPedidos.isEmpty()) {
			return ResponseEntity.ok(todosPedidos);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma pedido", notes = "Pedido")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um pedido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Long id) throws PedidoException {
		return ResponseEntity.ok(service.encontrarPedidoDTO(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere os dados de um pedido", notes = "Inserir pedido")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Pedido adcionado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Pedido> salvar(@Valid @RequestBody PedidoInserirDTO pedido) throws EmailException {
		Pedido pedidoSalva = service.salvarPedido(pedido);
		return new ResponseEntity<>(pedidoSalva, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza dados de um pedido", notes = "Atualizar pedido")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Pedido atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
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
	@ApiOperation(value = "Remove um pedido", notes = "Remover pedido")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Pedido removido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
		Optional<Pedido> pedidoExistente = service.encontrarPedido(id);
		if (pedidoExistente.isPresent()) {
			service.deletarPedido(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
