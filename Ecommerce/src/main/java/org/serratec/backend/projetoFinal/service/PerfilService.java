package org.serratec.backend.projetoFinal.service;

import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.Perfil;
import org.serratec.backend.projetoFinal.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {
	@Autowired
	private PerfilRepository perfilRepository;

	public Perfil buscar(Long id) {
		Optional<Perfil> perfil = perfilRepository.findById(id);
		return perfil.get();
	}

}
