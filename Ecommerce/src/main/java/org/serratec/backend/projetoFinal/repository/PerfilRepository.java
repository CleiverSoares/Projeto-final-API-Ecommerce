package org.serratec.backend.projetoFinal.repository;

import org.serratec.backend.projetoFinal.domain.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{

}
