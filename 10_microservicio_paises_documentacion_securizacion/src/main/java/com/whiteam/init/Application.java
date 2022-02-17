package com.whiteam.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.whiteam.service","com.whiteam.controller","com.whiteam.init"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	//Bean para que cree un template para que luego use el autowired del servicio
		@Bean RestTemplate template() {
			return new RestTemplate();
		}

}
