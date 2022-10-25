package org.serratec.backend.projetoFinal.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Autowired
	private JavaMailSender javaMailSender;

//	@Autowired
//	private RelatorioDto relatorioDto;

	public void sendEmail(String para, String assunto, String texto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("fullstacksoares@gmail.com");
		message.setTo(para);
		message.setSubject(assunto);
		message.setText(texto);
		javaMailSender.send(message);
	}

//	+ relatorioDto.getIdPedido() + relatorioDto.getDataPedido()
//	+ relatorioDto.getValorTotal() + relatorioDto.getCodigoProduto() + relatorioDto.getNomeProduto()
//	+ relatorioDto.getPrecoVenda() + relatorioDto.getQuantidade() + relatorioDto.getValorBruto() 
// 	+ relatorioDto.getPercentualDesconto()+relatorioDto.getValorLiquido() 

}
