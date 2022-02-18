package com.whiteam.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.whiteam.service","com.whiteam.controller","com.whiteam.init"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	//Bean para que cree un template para que luego use el autowired del servicio
	//Load balanced es necesario para que entienda que la direccion del template no es
	//la direccion estatica sino el nombre del servicio en eureka
	@LoadBalanced
	@Bean RestTemplate template() {
		RestTemplate template = new RestTemplate();
		template.getInterceptors()
		//añado un encabecado de autenticacion con esos credenciales
		.add(new BasicAuthenticationInterceptor("user1","user1"));
		return template;
	}
}
