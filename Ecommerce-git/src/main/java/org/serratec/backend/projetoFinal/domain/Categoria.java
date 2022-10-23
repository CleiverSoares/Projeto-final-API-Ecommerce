package org.serratec.backend.projetoFinal.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.serratec.backend.projetoFinal.enums.NomeCategoria;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id;

//	@NotBlank(message = "Preencha o nome")
//	@Size(min = 3, max = 30, message = "Nome da categoria deve ser entre {min} e {max} caracteres")
	@Column(nullable = false, length = 30, unique = true, name = "nome")
	@NotNull(message = "Nome categoria deve ser selecionado")
//	@Enumerated(EnumType.STRING)
	private NomeCategoria nomeCategoria;

	@Size(min = 3, max = 200, message = "Descrição deve ser entre {min} e {max} caracteres")
	@Column(length = 200)
	private String descricao;

	public Long getId() {
		return id;
	}

	public NomeCategoria getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(NomeCategoria nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id);
	}

}
