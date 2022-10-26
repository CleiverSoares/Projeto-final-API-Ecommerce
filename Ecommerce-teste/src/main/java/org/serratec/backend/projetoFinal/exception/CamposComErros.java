package org.serratec.backend.projetoFinal.exception;

public class CamposComErros {

	private String campo;
	private String mensagem;

	public CamposComErros(String campo, String mensagem) {
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "camposComErros \nCampo: " + campo + " || Mensagem: " + mensagem + ".";
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
