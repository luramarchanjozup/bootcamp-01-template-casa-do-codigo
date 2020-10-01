package com.itau.cdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.itau.cdc")
public class Bootcamp01TemplateCasaDoCodigoApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Bootcamp01TemplateCasaDoCodigoApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Bootcamp01TemplateCasaDoCodigoApplication.class, args);
	}

}
