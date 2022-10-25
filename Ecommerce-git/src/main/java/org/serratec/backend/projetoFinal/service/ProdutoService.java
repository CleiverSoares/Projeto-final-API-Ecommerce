package org.serratec.backend.projetoFinal.service;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.Produto;
import org.serratec.backend.projetoFinal.dto.ProdutoDto;
import org.serratec.backend.projetoFinal.dto.ProdutoInserirDto;
import org.serratec.backend.projetoFinal.exception.ProdutoException;
import org.serratec.backend.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<ProdutoDto> buscarTodos() {
		List<Produto> listaProduto = produtoRepository.findAll();
		List<ProdutoDto> listaProdutoDTO = new ArrayList<>();
		for (Produto produto : listaProduto) {
			ProdutoDto produtoDTO = new ProdutoDto();
			transformarEntityEmDto(produto, produtoDTO);
			listaProdutoDTO.add(produtoDTO);
		}
		return listaProdutoDTO;
	}

	public ProdutoDto transformarEntityEmDto(Produto produto, ProdutoDto produtoDTO) {
		produtoDTO.setId(produto.getId());
		produtoDTO.setNome(produto.getNome());
		produtoDTO.setQtdEstoque(produto.getQtdEstoque());
		produtoDTO.setDataCadastro(produto.getDataCadastro());
		produtoDTO.setValorUnitario(produto.getValorUnitario());
		produtoDTO.setDescricao(produto.getDescricao());
		produtoDTO.setQtdEstoque(produto.getQtdEstoque());
		produtoDTO.setCategoria(produto.getCategoria());

		return produtoDTO;
	}

	public ProdutoDto buscarPorId(Long id) throws ProdutoException {
		Optional<Produto> produto = produtoRepository.findById(id);
		Produto produtoNoBanco = new Produto();
		ProdutoDto produtoDTO = new ProdutoDto();
		if (produto.isPresent()) {
			produtoNoBanco = produto.get();
			transformarEntityEmDto(produtoNoBanco, produtoDTO);

			return produtoDTO;
		}
		throw new ProdutoException("O id informado não foi encontrado!");
	}

	public String atualizarProduto(Long id, ProdutoInserirDto produtoInserirDto) throws ProdutoException {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (!produto.isPresent()) {
			throw new ProdutoException("O produto não foi atualizado.");
		}
		Produto produtoDb = new Produto();
		produtoDb.setId(id);
		produtoDb.setNome(produtoInserirDto.getNome());
		produtoDb.setDescricao(produtoInserirDto.getDescricao());
		produtoDb.setQtdEstoque(produtoInserirDto.getQtdEstoque());
		produtoDb.setDataCadastro(produto.get().getDataCadastro());
		produtoDb.setValorUnitario(produtoInserirDto.getValorUnitario());
		produtoDb.setCategoria(produtoInserirDto.getCategoria());
		produtoRepository.save(produtoDb);
		return "O produto com o id " + produtoDb.getId() + " foi atualizado!";
	}

	public ProdutoInserirDto adicionarImagemUri(Produto produto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/foto")
				.buildAndExpand(produto.getId()).toUri();
		ProdutoInserirDto dto = new ProdutoInserirDto();
		dto.setNome(produto.getNome());
		dto.setUrl(uri.toString());
		return dto;
	}

	public Produto buscarEntidade(Long id) {
		return produtoRepository.findById(id).get();
	}

	@Transactional
	public ProdutoInserirDto inserir(Produto produto, MultipartFile file) throws IOException {
		produto.setTipoImagem(file.getContentType());
		produto.setImagem(file.getBytes());
		produto.setDataCadastro(LocalDate.now());
		produto = produtoRepository.save(produto);
		return adicionarImagemUri(produto);
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

}