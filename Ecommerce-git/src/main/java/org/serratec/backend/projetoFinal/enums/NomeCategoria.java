package org.serratec.backend.projetoFinal.enums;

import org.serratec.backend.projetoFinal.exception.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

//@Embeddable
public enum NomeCategoria {

	ESPORTIVO("Esportivo"), CASUAL("Casual"), SOCIAL("Social"), INFANTIL("Infantil");
//	ESPORTIVO, CASUAL, SOCIAL, INFANTIL;

	private String tipo;

	private NomeCategoria(String tipo) {
		this.tipo = tipo;
	}

	private NomeCategoria() {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@JsonCreator
	public static NomeCategoria verifica(String value) throws EnumValidationException {
		for (NomeCategoria categ : values()) {
			if (value.equals(categ.name())) {
				return categ;
			}
		}
		throw new EnumValidationException("Categoria " + value + " não existe.");
	}
}
