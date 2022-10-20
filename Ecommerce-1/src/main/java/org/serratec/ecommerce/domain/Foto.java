package org.serratec.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_foto")
	private Long id;
	@Lob
	private byte[] dados;
	private String tipo;
	private String nome;
	
//	@OneToOne
//	@JoinColumn(name = "id_funcionario")
//	private Funcionario funcionario;
//
//	public Foto() {
//	}
//
//	public Foto(Long id, byte[] dados, String tipo, String nome, Funcionario funcionario) {
//		this.id = id;
//		this.dados = dados;
//		this.tipo = tipo;
//		this.nome = nome;
//		this.funcionario = funcionario;
//	}
}