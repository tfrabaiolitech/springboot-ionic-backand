package tech.tfrabaioli.SpringApp.services;



import org.springframework.mail.SimpleMailMessage;

import tech.tfrabaioli.SpringApp.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}