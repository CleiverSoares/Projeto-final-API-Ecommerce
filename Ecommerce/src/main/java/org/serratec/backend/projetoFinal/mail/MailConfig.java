package org.serratec.backend.projetoFinal.mail;

import org.serratec.backend.projetoFinal.dto.RelatorioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(RelatorioDTO relatorioDTO) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("fullstacksoares@gmail.com");
		message.setTo(relatorioDTO.getEmail());
		message.setSubject("Pedido cadastrado com sucesso");
		message.setText(relatorioDTO.toString() + relatorioDTO.getItemPedidoRelatorioDTOs().toString());
		javaMailSender.send(message);
	}

}
