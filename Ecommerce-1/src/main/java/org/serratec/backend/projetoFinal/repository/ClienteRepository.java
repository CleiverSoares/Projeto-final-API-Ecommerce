package org.serratec.backend.projetoFinal.repository;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Cliente;
import org.serratec.backend.projetoFinal.dto.ClienteInserirDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{

    @Valid
    ClienteInserirDto save(@Valid ClienteInserirDto clienteInserirDto);




}


