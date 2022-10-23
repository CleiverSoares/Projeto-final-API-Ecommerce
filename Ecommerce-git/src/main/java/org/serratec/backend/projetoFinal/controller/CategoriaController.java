package org.serratec.backend.projetoFinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Categoria;
import org.serratec.backend.projetoFinal.mail.MailConfig;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	MailConfig mailConfig;

	@Autowired
	private CategoriaService service;

	@GetMapping
	public ResponseEntity<List<Categoria>> retornaTodos() {
		List<Categoria> todasCategorias = service.retornaTodasCategorias();
		System.out.println();
		if (!todasCategorias.isEmpty()) {
			return ResponseEntity.ok(todasCategorias);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getCategoria(@PathVariable Long id) {
		Optional<Categoria> categoriaExistente = service.encontrarCategoria(id);
		if (categoriaExistente.isPresent()) {
			return ResponseEntity.ok(categoriaExistente.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria categoria) {
		Categoria categoriaSalva = service.salvarCategoria(categoria);
		return new ResponseEntity<>(categoriaSalva, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
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
	public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
		Optional<Categoria> categoriaExistente = service.encontrarCategoria(id);
		if (categoriaExistente.isPresent()) {
			service.deletarCategoria(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
