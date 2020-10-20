package br.com.thyagoribeiro.casadocodigo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CasaDoCodigoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Validacao de application main")
	void main() {
		CasaDoCodigoApplication.main(new String[] {});
	}

}
