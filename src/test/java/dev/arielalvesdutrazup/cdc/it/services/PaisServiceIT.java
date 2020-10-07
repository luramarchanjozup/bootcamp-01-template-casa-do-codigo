package dev.arielalvesdutrazup.cdc.it.services;

import dev.arielalvesdutrazup.cdc.factories.entities.LivroFactory;
import dev.arielalvesdutrazup.cdc.factories.entities.PaisFactory;
import dev.arielalvesdutrazup.cdc.repositories.PaisRepository;
import dev.arielalvesdutrazup.cdc.services.PaisService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class PaisServiceIT {

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisRepository paisRepository;

    @AfterEach
    public void tearDown() {
        paisRepository.deleteAll();
    }

    @Test
    public void cadastrar_deveFuncionar() {
        var paisParaCadastrar = PaisFactory.paraPersistir();

        var paisCadastrado = paisService.cadastrar(paisParaCadastrar);

        assertThat(paisCadastrado).isNotNull();
        assertThat(paisCadastrado.getId()).isNotNull();

        var paisBuscado = paisRepository.findById(paisCadastrado.getId()).get();

        assertThat(paisBuscado).isNotNull();
        assertThat(paisBuscado.getId()).isEqualTo(paisCadastrado.getId());
        assertThat(paisBuscado.getNome()).isEqualTo(paisParaCadastrar.getNome());
        assertThat(paisBuscado.getCodigo()).isEqualTo(paisParaCadastrar.getCodigo());
        assertThat(paisBuscado.getCadastradoEm()).isNotNull();
    }

    @Test
    public void cadastrar_semNome_deveLancarException() {
        try {
            var paisParaCadastrar = PaisFactory.paraPersistir();
            paisParaCadastrar.setNome(null);

            paisService.cadastrar(paisParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Nome é obrigatório!', propertyPath=nome");
        }
    }

    @Test
    public void cadastrar_comNomeDuplicado_deveLancarException() {
        try {
            var paisParaCadastrar = PaisFactory.paraPersistir();

            paisService.cadastrar(paisParaCadastrar);
            paisService.cadastrar(paisParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains("Nome duplicado!");
        }
    }
}
