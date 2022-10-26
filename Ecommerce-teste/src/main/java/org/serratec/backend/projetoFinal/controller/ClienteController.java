package org.serratec.backend.projetoFinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Cliente;
import org.serratec.backend.projetoFinal.dto.ClienteInserirDTO;
import org.serratec.backend.projetoFinal.mail.MailConfig;
import org.serratec.backend.projetoFinal.service.ClienteService;
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
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	MailConfig mailConfig;

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	@ApiOperation(value = "Lista todas os clientes", notes = "Listagem de clientes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os clientes"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<List<Cliente>> listar() {
		List<Cliente> cliente = clienteService.listar();
		return ResponseEntity.ok(cliente);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma cliente", notes = "Cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um cliente"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) {
		Cliente cliente = clienteService.buscarCliente(id);
		if (null != cliente) {
			return ResponseEntity.ok(cliente);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere os dados de um cliente", notes = "Inserir cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente adcionado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Cliente> inserir(@Valid @RequestBody ClienteInserirDTO clienteInserirDto) {
//		mailConfig.sendEmail("cleiversoares2@gmail.com", "bixo do mato", clienteInserirDto.toString());
		Cliente cliente1 = clienteService.inserir(clienteInserirDto);
		if (null != cliente1) {
			return ResponseEntity.ok(cliente1);
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza dados de um cliente", notes = "Atualizar cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		Cliente cliente1 = clienteService.atualizar(id, cliente);
		if (null != cliente1) {
			return ResponseEntity.ok(cliente1);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um cliente", notes = "Remover cliente")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente removido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		boolean cliente1 = clienteService.delete(id);
		if (false == cliente1) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
