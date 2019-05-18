package tech.tfrabaioli.SpringApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tech.tfrabaioli.SpringApp.services.S3Service;


@SpringBootApplication
public class SpringAppApplication implements CommandLineRunner {
	
	@Autowired
	private S3Service s3Service;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		s3Service.uploadFile("/Users/tfrabaiolitech/Pictures/aws.jpg");
	}	
}
