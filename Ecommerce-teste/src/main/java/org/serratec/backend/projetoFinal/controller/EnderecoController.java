package org.serratec.backend.projetoFinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.serratec.backend.projetoFinal.domain.Endereco;
import org.serratec.backend.projetoFinal.service.EnderecoService;
import org.serratec.backend.projetoFinal.service.EnderecoViaCepService;
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
@RequestMapping("/api/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private EnderecoViaCepService viaCepService;

	@GetMapping
	@ApiOperation(value = "Lista todas os endereços", notes = "Listagem de endereços")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os endereços"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<List<Endereco>> listarTodos() {
		Optional<List<Endereco>> endereco = enderecoService.listarTodosService();
		if (endereco.isPresent()) {
			return ResponseEntity.ok(endereco.get());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma endereço", notes = "Endereço")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um endereço"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Endereco> listar(@PathVariable Long id) {
		Optional<Endereco> endereco = enderecoService.listarService(id);
		if (endereco.isPresent()) {
			return ResponseEntity.ok(endereco.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere os dados de um endreço", notes = "Inserir endereço")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Endereço adcionado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> cadastrarEndereco(@Valid @RequestBody Endereco endereco) {
		enderecoService.cadastrarService(endereco);
		return ResponseEntity.status(201).build();
	}

	@PostMapping("/cadastrarPorCep")
	public ResponseEntity<Endereco> cadastrarEnderecoPorCep(@PathParam("cep") String cep,
			@PathParam("numero") String numero, @PathParam("complemento") String complemento) {
		Endereco enderecoViaCepSite = viaCepService.buscarService(cep, numero);
		if (enderecoViaCepSite != null) {
			if (complemento != null) {
				enderecoViaCepSite.setComplemento(complemento);
			}
			enderecoService.cadastrarService(enderecoViaCepSite);
			return ResponseEntity.status(201).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza dados de um endereço", notes = "Atualizar endereço")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Endereço atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @Valid @RequestBody Endereco dadosEndereco) {
		Optional<Endereco> endereco = enderecoService.atualizarService(id, dadosEndereco);
		if (!endereco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(endereco.get());
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um endereço", notes = "Remover endereço")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Endereço removido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		boolean foiDeletada = enderecoService.deletar(id);
		if (!foiDeletada) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
