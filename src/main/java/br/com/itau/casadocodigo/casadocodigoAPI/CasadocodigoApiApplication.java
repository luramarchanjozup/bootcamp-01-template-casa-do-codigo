package br.com.itau.casadocodigo.casadocodigoAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class CasadocodigoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadocodigoApiApplication.class, args);
	}

}
