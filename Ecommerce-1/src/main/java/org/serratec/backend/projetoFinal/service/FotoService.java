package org.serratec.backend.projetoFinal.service;

import java.io.IOException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.serratec.backend.projetoFinal.domain.Foto;
import org.serratec.backend.projetoFinal.domain.Produto;
import org.serratec.backend.projetoFinal.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoService {
	@Autowired
	private FotoRepository fotoRepository;

	public Foto inserir(Produto produto, MultipartFile file) throws IOException {
		Foto foto = new Foto();
		foto.setNome(file.getName());
		foto.setTipo(file.getContentType());
		foto.setDados(file.getBytes());
		foto.setProduto(produto);
		return fotoRepository.save(foto);
	}

	@Transactional
	public Foto buscarPorIdProduto(Long id) {
		Produto produto = new Produto();
		produto.setId(id);
		Optional<Foto> foto = fotoRepository.findByProduto(produto);
		if (!foto.isPresent()) {
			return null;
		}
		return foto.get();
	}
}