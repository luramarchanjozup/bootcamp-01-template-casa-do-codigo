package com.casaDoCodigo.Nicolle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.apache.tomcat.util.http.LegacyCookieProcessor;

@SpringBootApplication
public class CasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasaApplication.class, args);
	}
	
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> cookieProcessorCustomizer() {
		return (factory) -> factory.addContextCustomizers((context) -> context.setCookieProcessor(new LegacyCookieProcessor()));
		
	}

}
