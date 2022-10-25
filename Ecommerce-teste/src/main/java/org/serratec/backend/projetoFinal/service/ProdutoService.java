package org.serratec.backend.projetoFinal.service;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Produto;
import org.serratec.backend.projetoFinal.dto.ProdutoDTO;
import org.serratec.backend.projetoFinal.dto.ProdutoInserirDTO;
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

	public List<ProdutoDTO> buscarTodos() {
		List<Produto> listaProduto = produtoRepository.findAll();
		List<ProdutoDTO> listaProdutoDTO = new ArrayList<>();
		for (Produto produto : listaProduto) {
			ProdutoDTO produtoDTO = new ProdutoDTO();
			transformarEntityEmDto(produto, produtoDTO);
			listaProdutoDTO.add(produtoDTO);
		}
		return listaProdutoDTO;
	}

	public ProdutoDTO transformarEntityEmDto(Produto produto, ProdutoDTO produtoDTO) {
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

	public ProdutoDTO buscarPorId(Long id) throws ProdutoException {
		Optional<Produto> produto = produtoRepository.findById(id);
		Produto produtoNoBanco = new Produto();
		ProdutoDTO produtoDTO = new ProdutoDTO();
		if (produto.isPresent()) {
			produtoNoBanco = produto.get();
			transformarEntityEmDto(produtoNoBanco, produtoDTO);
			return produtoDTO;
		}
		throw new ProdutoException("O id informado não foi encontrado!");
	}

	public String atualizarProduto(Long id, ProdutoInserirDTO produtoInserirDto) throws ProdutoException {
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

	public ProdutoInserirDTO adicionarImagemUri(@Valid Produto produto) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/produto/{id}/foto")
				.buildAndExpand(produto.getId()).toUri();
		ProdutoInserirDTO produtoInserirDTO = new ProdutoInserirDTO();
		produtoInserirDTO.setNome(produto.getNome());
		produtoInserirDTO.setUrl(uri.toString());
		produtoInserirDTO.setValorUnitario(produto.getValorUnitario());
		produtoInserirDTO.setDescricao(produto.getDescricao());
		produtoInserirDTO.setQtdEstoque(produto.getQtdEstoque());
		produtoInserirDTO.setCategoria(produto.getCategoria());
		return produtoInserirDTO;
	}

	public Produto buscarEntidade(Long id) {
		return produtoRepository.findById(id).get();
	}

	@Transactional
	public ProdutoInserirDTO inserir(@Valid Produto produto, MultipartFile file) throws IOException {
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