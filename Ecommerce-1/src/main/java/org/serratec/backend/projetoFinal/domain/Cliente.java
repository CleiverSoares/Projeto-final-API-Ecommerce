package org.serratec.backend.projetoFinal.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.serratec.backend.projetoFinal.dto.ClienteInserirDto;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @NotBlank(message = "Prencher seu nome completo")
    @Size(max = 60)
    @Column(nullable = false, length = 60, name = "nome_completo") 
    private String nomeCompleto;

    @Email(message = "Prencher email")
    @Size(max = 30)
    @Column(nullable = false, length = 30)
    private String email;

    @NotBlank(message = "Prencher cpf")
    @Size(max = 14)
    @Column(nullable = false, length = 14)
    private String cpf;

    @Size(max = 11)
    @Column(nullable = true, length = 11)
    private String telefone;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = true, name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;
    
    

    public Cliente( ) {
        super();
    }



    public Cliente(ClienteInserirDto clienteInserirDto, Endereco endereco) {
        super();
        this.nomeCompleto = clienteInserirDto.getNomeCompleto();
        this.email = clienteInserirDto.getEmail();
        this.cpf = clienteInserirDto.getCpf();
        this.telefone = clienteInserirDto.getTelefone();
        this.dataNascimento = clienteInserirDto.getDataNascimento();
        this.endereco = endereco;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, email, endereco, id, nomeCompleto, telefone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
                && Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
                && Objects.equals(nomeCompleto, other.nomeCompleto) && Objects.equals(telefone, other.telefone);
    }


    

}