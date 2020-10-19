package dev.arielalvesdutrazup.cdc.it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

/**
 * Teste de Integração para carregar o contexto da
 * aplicação.
 */
@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
class CdcApplicationIT {

	@Autowired
	private EntityManager entityManager;

	@Test
	void carregarContexto_deveFuncionar() {
		entityManager.getProperties();
	}
}
