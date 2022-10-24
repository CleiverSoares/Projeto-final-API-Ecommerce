package org.serratec.backend.projetoFinal.service;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Produto;
import org.serratec.backend.projetoFinal.dto.ProdutoInserirDto;
import org.serratec.backend.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FotoService fotoService;

	public Optional<List<Produto>> listarTodosService() {
		Optional<List<Produto>> produto = Optional.ofNullable(produtoRepository.findAll());
		return produto;
	}

	public Optional<Produto> listar(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto;
	}
// ANTIGO
//	public Produto cadastrarProduto(Produto produto) {
//		produtoRepository.save(produto);
//		return produto;
//	}

	public Produto cadastrarProduto(@Valid ProdutoInserirDto produtoInserirDto) {
		Produto produto = new Produto();
		Produto produtoDb = produtoRepository.save(produto);
		produtoRepository.save(produtoDb);
		return produtoDb;
	}

	public Optional<Produto> atualizarService(Long id, Produto dadosProduto) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (!produto.isPresent()) {
			return produto;
		}
		dadosProduto.setId(id);
		produtoRepository.save(dadosProduto);
		return produto;
	}

	public boolean deletar(Long id) {
		if (!produtoRepository.existsById(id)) {
			return false;
		}
		produtoRepository.deleteById(id);
		return true;
	}

	public ProdutoInserirDto adicionarImagemUri(Produto produto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/foto")
				.buildAndExpand(produto.getId()).toUri();
		ProdutoInserirDto dto = new ProdutoInserirDto();
		dto.setNome(produto.getNome());
		dto.setUrl(uri.toString());
		return dto;
	}

	public List<ProdutoInserirDto> listar() {
		List<ProdutoInserirDto> produtoInserirDtos = produtoRepository.findAll().stream()
				.map(f -> adicionarImagemUri(f)).collect(Collectors.toList());
		return produtoInserirDtos;
	}

	public ProdutoInserirDto buscar(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return adicionarImagemUri(produto.get());
	}
	
	public ProdutoInserirDto inserir(Produto produto, MultipartFile file) throws IOException {
		System.out.println("opa");
		produto = produtoRepository.save(produto);
		fotoService.inserir(produto, file);
		return adicionarImagemUri(produto);
	}

}