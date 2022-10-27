package org.serratec.backend.projetoFinal.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Produto;
import org.serratec.backend.projetoFinal.dto.ProdutoDTO;
import org.serratec.backend.projetoFinal.dto.ProdutoInserirDTO;
import org.serratec.backend.projetoFinal.exception.ProdutoException;
import org.serratec.backend.projetoFinal.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	@ApiOperation(value = "Lista todas os produtos", notes = "Listagem de produtos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna todos os produtos"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<List<ProdutoDTO>> buscarTodos() {
		return ResponseEntity.ok(produtoService.buscarTodos());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna uma produto", notes = "Produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna um produto"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Long id) throws ProdutoException {
		return ResponseEntity.ok(produtoService.buscarPorId(id));
	}

	@GetMapping("/{id}/foto")
	@ApiOperation(value = "Retorna foto de um produto", notes = "Foto de produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retornar foto"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<byte[]> buscarFoto(@PathVariable Long id) {
		Produto produto = produtoService.buscarEntidade(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", produto.getTipoImagem());
		headers.add("Content-length", String.valueOf(produto.getImagem().length));
		return new ResponseEntity<>(produto.getImagem(), headers, HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Insere os dados de um produto", notes = "Inserir produto")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Produto adcionado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ProdutoDTO inserir(@Valid @RequestPart ProdutoInserirDTO produto, @RequestPart MultipartFile file)
			throws IOException {
		return produtoService.inserir(produto, file);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza dados de um produto", notes = "Atualizar produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Produto atualizado"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<String> atualizarProduto(@PathVariable Long id,
			@Valid @RequestBody ProdutoInserirDTO produtoDTO) throws ProdutoException {
		return ResponseEntity.ok(produtoService.atualizarProduto(id, produtoDTO));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Remove um produto", notes = "Remover produto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Produto removido"),
			@ApiResponse(code = 401, message = "Erro de autenticação"),
			@ApiResponse(code = 403, message = "Não há permissão para acessar o recurso"),
			@ApiResponse(code = 404, message = "Recurso não encontrado"),
			@ApiResponse(code = 505, message = "Exceção interna da aplicação"), })
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		boolean foiDeletado = produtoService.deletar(id);
		if (!foiDeletado) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

}