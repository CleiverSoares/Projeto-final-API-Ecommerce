package org.serratec.backend.projetoFinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Categoria;
import org.serratec.backend.projetoFinal.service.CategoriaService;
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
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping
	@ApiOperation(value = "Lista todas as categorias", notes = "Listagem de categorias")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos as categorias"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<List<Categoria>> retornaTodos() {
		List<Categoria> todasCategorias = service.retornaTodasCategorias();
		System.out.println();
		if (!todasCategorias.isEmpty()) {
			return ResponseEntity.ok(todasCategorias);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma categoria", notes = "Categoria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna uma categoria"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Categoria> getCategoria(@PathVariable Long id) {
		Optional<Categoria> categoriaExistente = service.encontrarCategoria(id);
		if (categoriaExistente.isPresent()) {
			return ResponseEntity.ok(categoriaExistente.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere os dados de uma categoria", notes = "Inserir categoria")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Categoria adcionada"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria categoria) {
		Categoria categoriaSalva = service.salvarCategoria(categoria);
		return new ResponseEntity<>(categoriaSalva, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza dados de uma categoria", notes = "Atualizar categoria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Categoria atualizada"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
		Optional<Categoria> categoriaExistente = service.encontrarCategoria(id);
		if (!categoriaExistente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		categoria.setId(id);
		service.salvarCategoria(categoria);
		return ResponseEntity.ok(categoriaExistente.get());
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove uma categoria", notes = "Remover categoria")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Categoria removida"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
		Optional<Categoria> categoriaExistente = service.encontrarCategoria(id);
		if (categoriaExistente.isPresent()) {
			service.deletarCategoria(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
