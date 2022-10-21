package org.serratec.backend.projetoFinal.dto;

import java.time.LocalDate;

public class ClienteInserirDto {
    


    private String nomeCompleto;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;
    private String cep;
    private String numero;
    private String email;
    
    
    

    public ClienteInserirDto() {
        super();
    }



    public ClienteInserirDto(Long id, String nomeCompleto, String cpf, String telefone, LocalDate dataNascimento,
            String cep, String numero, String email) {
        super();
       
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.numero = numero;
        this.email = email;
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
