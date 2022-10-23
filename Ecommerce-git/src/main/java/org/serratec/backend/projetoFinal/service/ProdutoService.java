package org.serratec.backend.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.Produto;
import org.serratec.backend.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

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

//	public Produto cadastrarProduto(@Valid ProdutoInserirDto produtoInserirDto) {
//		Produto produtoDb = produtoRepository.save(produtoInserirDto);
//		produtoRepository.save(produtoDb);
//		return produtoDb;
//	}
	
//	public ProdutoInserirDto adicionarImagemUri(Produto produto) {
//		ProdutoInserirDto dto = new ProdutoInserirDto();
//		dto.setNome(produto.getNome());
//		dto.setDescricao(produto.getDescricao());
//		dto.setQtdEstoque(produto.getQtdEstoque());
//		dto.setValorUnitario(produto.getValorUnitario());
//		dto.getCategoria(produto.getCategoria());
//		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/foto")
//				.buildAndExpand(produto.getId()).toUri();
//		dto.setUrl(uri.toString());
//		return dto;
//
//	}
	
//	public ProdutoInserirDto inserir(ProdutoInserirDto produtoDto, MultipartFile file) throws IOException {
//		produtoDto = produtoRepository.save(produtoDto);
//		return produtoDto;
//	}

	
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

}