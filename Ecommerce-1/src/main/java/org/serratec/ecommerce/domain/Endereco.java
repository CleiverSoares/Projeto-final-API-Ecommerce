package org.serratec.ecommerce.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Long id;

	@NotBlank
	@Size(max = 8)
	@Column(name = "cep", length = 8, nullable = false)
	private String cep;

	@NotBlank
	@Size(max = 80)
	@Column(name = "rua", length = 80, nullable = false)
	private String rua;

	@NotBlank
	@Size(max = 50)
	@Column(name = "bairro", length = 50, nullable = false)
	private String bairro;

	@NotBlank
	@Size(max = 20)
	@Column(name = "numero", length = 20, nullable = false)
	private String numero;

	@Column(name = "complemento", length = 80, nullable = true)
	private String complemento;

	@NotBlank
	@Size(max = 2)
	@Column(name = "uf", length = 2, nullable = false)
	private String uf;

	public Endereco() {
		super();
	}

	public Endereco(Long id, @NotBlank @Size(max = 8) String cep, @NotBlank @Size(max = 80) String rua,
			@NotBlank @Size(max = 50) String bairro, @NotBlank @Size(max = 20) String numero, String complemento,
			@NotBlank @Size(max = 2) String uf) {
		super();
		this.id = id;
		this.cep = cep;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}

}
