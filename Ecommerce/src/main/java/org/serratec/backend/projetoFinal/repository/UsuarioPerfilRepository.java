package org.serratec.backend.projetoFinal.repository;

import org.serratec.backend.projetoFinal.domain.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, Long>{

}
