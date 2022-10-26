package org.serratec.backend.projetoFinal.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.serratec.backend.projetoFinal.domain.Cliente;

public class ClienteDTO {

	private Long id;
	private String nomeCompleto;
	private String cpf;
	private String telefone;
	private LocalDate dataNascimento;
	private Integer numero;

	
	public ClienteDTO() {

	}

	public ClienteDTO(Long id, String nomeCompleto, String cpf, String telefone) {
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.telefone = telefone;

	}

	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nomeCompleto = cliente.getNomeCompleto();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();

	}

	public static List<ClienteDTO> convert(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
