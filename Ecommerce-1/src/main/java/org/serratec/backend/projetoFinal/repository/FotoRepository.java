package org.serratec.backend.projetoFinal.repository;

import java.util.Optional;

import org.serratec.backend.projetoFinal.domain.Foto;
import org.serratec.backend.projetoFinal.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {
	public Optional<Foto> findByProduto(Produto produto);
}
