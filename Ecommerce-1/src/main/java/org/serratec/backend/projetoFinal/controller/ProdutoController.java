package org.serratec.backend.projetoFinal.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Foto;
import org.serratec.backend.projetoFinal.domain.Produto;
import org.serratec.backend.projetoFinal.dto.ProdutoInserirDto;
import org.serratec.backend.projetoFinal.service.FotoService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

//	@Autowired
//	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private FotoService fotoService;

	@GetMapping("/todos")
	public ResponseEntity<List<Produto>> listarTodos() {
		Optional<List<Produto>> produto = produtoService.listarTodosService();

		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<Produto> listar(@PathVariable Long id) {
		Optional<Produto> produto = produtoService.listar(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		return ResponseEntity.notFound().build();
	}

//	@PostMapping("/cadastrar")
//	public ResponseEntity<Void> cadastrarProduto(@Valid @RequestBody Produto produto) {
//		produtoRepository.save(produto);
//		return ResponseEntity.status(201).build();
//	}

//	@PostMapping("/inserir")
//	@ResponseStatus(HttpStatus.CREATED)
//	public ResponseEntity<Produto> inserir(@Valid @RequestBody ClienteInserirDto clienteInserirDto) {
//		Produto produto = produtoService.cadastrarProduto(produto);
//		if (null != produto) {
//			return ResponseEntity.ok(produto);
//		}
//		return ResponseEntity.notFound().build();
//	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto dadosProduto) {
		Optional<Produto> produto = produtoService.atualizarService(id, dadosProduto);
		if (!produto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto.get());
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		boolean foiDeletado = produtoService.deletar(id);
		if (!foiDeletado) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public List<ProdutoInserirDto> listar() {
		return produtoService.listar();
	}

	@GetMapping("/{id}/foto")
	public ResponseEntity<byte[]> buscarFoto(@PathVariable Long id) {
		Foto foto = fotoService.buscarPorIdProduto(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", foto.getTipo());
		headers.add("Content-length", String.valueOf(foto.getDados().length));
		return new ResponseEntity<>(foto.getDados(), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ProdutoInserirDto buscar(@PathVariable Long id) {
		return produtoService.buscar(id);
	}

	@PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ProdutoInserirDto inserir(@RequestPart Produto produto, @RequestPart MultipartFile file)
			throws IOException {
		return produtoService.inserir(produto, file);
	}
}
