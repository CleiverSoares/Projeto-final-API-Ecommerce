package org.serratec.backend.projetoFinal.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

public class ClienteInserirDto {

	@NotBlank(message = "Prencher o nome completo")
	@Size(max = 60, message = "Tamanho máximo do nome deve ser de {max} caracteres.")
	private String nomeCompleto;

	@CPF(message = "Esse CPF não existe.")
	@NotBlank(message = "Preencha o CPF.")
	@Size(max = 11, message = "Tamanho máximo do CPF deve ser de {max} caracteres.")
	private String cpf;

	@Size(max = 40, message = "Tamanho máximo do telefone deve ser de {max} caracteres.")
	@NotBlank(message = "Preencha o telefone.")
	private String telefone;

	@NotNull(message = "Preencha a data de nascimento.")
	private LocalDate dataNascimento;

	@NotBlank(message = "Preencha o CEP.")
	@Size(max = 10, message = "Tamanho máximo do CEP deve ser de {max} caracteres.")
	private String cep;

	@NotBlank(message = "Preencha o número.")
	@Size(max = 20, message = "Tamanho máximo do número deve ser de {max} caracteres.")
	private String numero;

	@Email(message = "Esse e-mail não existe.")
	@NotBlank(message = "Preencha o e-mail.")
	@Size(max = 80, message = "Tamanho maximo do número deve ser de {max} caracteres.")
	private String email;

	public ClienteInserirDto() {
		super();
	}

	public ClienteInserirDto(
			@NotBlank(message = "Prencher o nome completo") @Size(max = 60, message = "Tamanho máximo do nome deve ser de {max} caracteres.") String nomeCompleto,
			@CPF(message = "Esse CPF não existe.") @NotBlank(message = "Preencha o CPF.") @Size(max = 11, message = "Tamanho máximo do CPF deve ser de {max} caracteres.") String cpf,
			@Size(max = 40, message = "Tamanho máximo do telefone deve ser de {max} caracteres.") @NotBlank(message = "Preencha o telefone.") String telefone,
			@NotNull(message = "Preencha a data de nascimento.") LocalDate dataNascimento,
			@NotBlank(message = "Preencha o CEP.") @Size(max = 10, message = "Tamanho máximo do CEP deve ser de {max} caracteres.") String cep,
			@NotBlank(message = "Preencha o número.") @Size(max = 20, message = "Tamanho máximo do número deve ser de {max} caracteres.") String numero,
			@Email(message = "Esse e-mail não existe.") @NotBlank(message = "Preencha o e-mail.") @Size(max = 80, message = "Tamanho maximo do número deve ser de {max} caracteres.") String email) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.cep = cep;
		this.numero = numero;
		this.email = email;
	}

	@Override
	public String toString() {
		return "ClienteInserirDto \n|| Nome completo: " + nomeCompleto + " || CPF: " + cpf + " || Telefone: " + telefone
				+ " || Data de nascimento: " + dataNascimento + " || CEP: " + cep + " || Número: " + numero
				+ " \n|| E-mail: " + email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
