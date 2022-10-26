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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> buscarTodos() {
		return ResponseEntity.ok(produtoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Long id) throws ProdutoException {
		return ResponseEntity.ok(produtoService.buscarPorId(id));
	}

	@GetMapping("/{id}/foto")
	public ResponseEntity<byte[]> buscarFoto(@PathVariable Long id) {
		Produto produto = produtoService.buscarEntidade(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", produto.getTipoImagem());
		headers.add("Content-length", String.valueOf(produto.getImagem().length));
		return new ResponseEntity<>(produto.getImagem(), headers, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> atualizarProduto(@PathVariable Long id,
			@Valid @RequestBody ProdutoInserirDTO produtoDTO) throws ProdutoException {
		return ResponseEntity.ok(produtoService.atualizarProduto(id, produtoDTO));
	}

	@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ProdutoInserirDTO inserir(@Valid @RequestPart Produto produto, @RequestPart MultipartFile file)
			throws IOException {
		return produtoService.inserir(produto, file);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		boolean foiDeletado = produtoService.deletar(id);
		if (!foiDeletado) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

}