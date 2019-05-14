package tech.tfrabaioli.SpringApp.config;

import java.text.ParseException;
import tech.tfrabaioli.SpringApp.services.EmailService;
import tech.tfrabaioli.SpringApp.services.MockEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import tech.tfrabaioli.SpringApp.services.DBService;



@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
		
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}