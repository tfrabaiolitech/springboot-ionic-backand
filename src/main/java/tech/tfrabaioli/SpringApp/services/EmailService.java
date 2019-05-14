package tech.tfrabaioli.SpringApp.services;



import org.springframework.mail.SimpleMailMessage;
import javax.mail.internet.MimeMessage;

import tech.tfrabaioli.SpringApp.domain.Pedido;

public interface EmailService {
 
	//Versão texto plano
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	//Versão HTML
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	void sendHtmlEmail(MimeMessage msg);
}