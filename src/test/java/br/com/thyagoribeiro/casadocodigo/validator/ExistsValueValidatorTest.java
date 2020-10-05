package br.com.thyagoribeiro.casadocodigo.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.validation.Payload;

import java.lang.annotation.Annotation;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@SpringBootTest
@AutoConfigureMockMvc
public class ExistsValueValidatorTest {

    @MockBean
    EntityManager entityManager;

    @MockBean
    private EntityManagerFactory entityManagerFactory;

    @InjectMocks
    ContainsValueValidator uniqueValueValidator;

    @Test
    @DisplayName("Verifica se retorna erro quando um campo ja existe")
    void isValidTest() throws Exception {

    }

    private ExistsValue criaUniqueValue() {
        return new ExistsValue() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public String message() {
                return "possui valor que ja existe na base";
            }

            @Override
            public Class<?>[] groups() {
                return new Class[0];
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return new Class[0];
            }

            @Override
            public String fieldName() {
                return "teste";
            }

            @Override
            public Class<?> domainClass() {
                return String.class;
            }

            @Override
            public ValueStatus valueStatus() {return ValueStatus.NOT_EXISTS; }
        };

    }

}

