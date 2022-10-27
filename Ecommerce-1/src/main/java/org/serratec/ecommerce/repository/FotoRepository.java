package org.serratec.ecommerce.repository;

import org.serratec.ecommerce.domain.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

}
