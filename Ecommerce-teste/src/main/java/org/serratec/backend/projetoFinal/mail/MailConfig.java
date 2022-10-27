package org.serratec.backend.projetoFinal.mail;

import org.serratec.backend.projetoFinal.dto.ItemPedidoRelatorioDTO;
import org.serratec.backend.projetoFinal.dto.RelatorioDTO;
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

	public void sendEmail(RelatorioDTO relatorioDTO) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("fullstacksoares@gmail.com");
		message.setTo(relatorioDTO.getEmail());
		message.setSubject("Pedido cadastrado com sucesso");
		message.setText(relatorioDTO.toString()+ relatorioDTO.getItemPedidoRelatorioDTOs().toString());
		javaMailSender.send(message);
	}
	

	
	

//	+ relatorioDto.getIdPedido() + relatorioDto.getDataPedido()
//	+ relatorioDto.getValorTotal() + relatorioDto.getCodigoProduto() + relatorioDto.getNomeProduto()
//	+ relatorioDto.getPrecoVenda() + relatorioDto.getQuantidade() + relatorioDto.getValorBruto() 
// 	+ relatorioDto.getPercentualDesconto()+relatorioDto.getValorLiquido() 

}
