package org.serratec.ecommerce.repository;

import org.serratec.ecommerce.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Long>{

}