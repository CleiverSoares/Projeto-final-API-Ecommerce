package org.serratec.backend.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.backend.projetoFinal.domain.Cliente;
import org.serratec.backend.projetoFinal.domain.Endereco;
import org.serratec.backend.projetoFinal.dto.ClienteInserirDTO;
import org.serratec.backend.projetoFinal.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

//	@Autowired
//	private MailConfig mailConfig;

	@Autowired
	private EnderecoViaCepService enderecoViaCepService;

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

//	public List<ClienteDto> findAll() {
//		List<Cliente> clientes = clienteRepository.findAll();
//		return ClienteDto.convert(clientes);
//	}

	public Cliente buscarCliente(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return cliente.get();
		}
		return null;
	}

	public Cliente inserir(@Valid ClienteInserirDTO clienteInserirDTO) {
		Endereco endereco = enderecoViaCepService.buscarService(clienteInserirDTO.getCep(),
				clienteInserirDTO.getNumero());
		Cliente cliente = new Cliente(clienteInserirDTO, endereco);
		Cliente clienteDb = clienteRepository.save(cliente);
		return clienteDb;
	}

	public Cliente atualizar(Long id, Cliente cliente) {
		Optional<Cliente> cliente1 = clienteRepository.findById(id);
		if (cliente1.isPresent()) {
			if (null != cliente.getTelefone()) {
				cliente1.get().setTelefone(cliente.getTelefone());
			}
			if (null != cliente.getCpf()) {
				cliente1.get().setCpf(cliente.getCpf());
			}
			if (null != cliente.getNomeCompleto()) {
				cliente1.get().setNomeCompleto(cliente.getNomeCompleto());
			}
			if (null != cliente.getEmail()) {
				cliente1.get().setEmail(cliente.getEmail());
			}
			if (null != cliente.getEndereco()) {
				cliente1.get().setEndereco(cliente.getEndereco());
			}
			if (null != cliente.getDataNascimento()) {
				cliente1.get().setDataNascimento(cliente.getDataNascimento());
			}
		} else {
			return null;
		}
		return clienteRepository.save(cliente1.get());
	}

	public boolean delete(Long id) {
		if (!clienteRepository.existsById(id)) {
			return false;
		}
		clienteRepository.deleteById(id);
		return true;
	}

}
