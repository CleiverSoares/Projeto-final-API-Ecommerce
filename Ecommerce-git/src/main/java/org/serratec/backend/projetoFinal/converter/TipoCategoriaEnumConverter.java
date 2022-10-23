package org.serratec.backend.projetoFinal.converter;

import javax.persistence.AttributeConverter;

import org.serratec.backend.projetoFinal.enums.NomeCategoria;

public class TipoCategoriaEnumConverter implements AttributeConverter<NomeCategoria, String> {

	@Override
	public String convertToDatabaseColumn(NomeCategoria attribute) {
		return attribute.getTipo();
	}

	@Override
	public NomeCategoria convertToEntityAttribute(String value) {
		if (value == null) {
			return null;
		}
		for (NomeCategoria tipo : NomeCategoria.values()) {
			if (tipo.getTipo().equals(value)) {
				return tipo;
			}
		}
		throw new IllegalArgumentException("O valor " + value + " não é um tipo de artista válido.");
	}

}
