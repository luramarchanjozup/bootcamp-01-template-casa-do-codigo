package dev.arielalvesdutrazup.cdc.it.services;

import dev.arielalvesdutrazup.cdc.factories.entities.AutorFactory;
import dev.arielalvesdutrazup.cdc.repositories.AutorRepository;
import dev.arielalvesdutrazup.cdc.services.AutorService;
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
public class AutorServiceIT {

    @Autowired
    private AutorService autorService;

    @Autowired
    private AutorRepository autorRepository;

    @AfterEach
    public void tearDown() {
        autorRepository.deleteAll();
    }

    @Test
    public void cadastrar_deveFuncionar() {
        var autorParaCadastrar = AutorFactory.paraPersistir();

        var autorCadastrado = autorService.cadastrar(autorParaCadastrar);

        assertThat(autorCadastrado).isNotNull();
        assertThat(autorCadastrado.getId()).isNotNull();

        var autorBuscado = autorRepository.findById(autorCadastrado.getId()).get();

        assertThat(autorBuscado).isNotNull();
        assertThat(autorBuscado.getId()).isEqualTo(autorCadastrado.getId());
        assertThat(autorBuscado.getNome()).isEqualTo(autorParaCadastrar.getNome());
        assertThat(autorBuscado.getEmail()).isEqualTo(autorParaCadastrar.getEmail());
        assertThat(autorBuscado.getDescricao()).isEqualTo(autorParaCadastrar.getDescricao());
        assertThat(autorBuscado.getCadastradoEm()).isNotNull();
    }

    @Test
    public void cadastrar_semEmail_deveLancarUmaException() {
        try {
            var autorParaCadastrar = AutorFactory.paraPersistir();
            autorParaCadastrar.setEmail(null);

            autorService.cadastrar(autorParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='E-mail é obrigatório!', propertyPath=email");
        }
    }

    @Test
    public void cadastrar_comEmailInvalido_deveLancarUmaException() {
        try {
            var autorParaCadastrar = AutorFactory.paraPersistir();
            autorParaCadastrar.setEmail("emailinvalido");

            autorService.cadastrar(autorParaCadastrar);
            fail("Esperando uma exceção!");;
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("E-mail deve ter um formato válido!");
        }
    }

    @Test
    public void cadastrar_comEmailDuplicado_deveLancarUmaException() {
        try {
            var autorParaCadastrar = AutorFactory.paraPersistir();

            autorService.cadastrar(autorParaCadastrar);
            autorService.cadastrar(autorParaCadastrar);
            fail("Esperando uma exceção!");;
        } catch (Exception e) {
            assertThat(e.getMessage()).contains("E-mail duplicado!");
        }
    }

    @Test
    public void cadastrar_semNome_deveLancarUmaException() {
        try {
            var autorParaCadastrar = AutorFactory.paraPersistir();
            autorParaCadastrar.setNome(null);

            autorService.cadastrar(autorParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Nome é obrigatório!', propertyPath=nome");
        }
    }

    @Test
    public void cadastrar_semDescricao_deveLancarUmaException() {
        try {
            var autorParaCadastrar = AutorFactory.paraPersistir();
            autorParaCadastrar.setDescricao(null);

            autorService.cadastrar(autorParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Descrição é obrigatória!', propertyPath=descricao");
        }
    }

    @Test
    public void cadastrar_comDescricaoComMaisDe400Caracteres_deveLancarUmaException() {
        try {
            var mensagemGrande = "Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minusdsdss id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reic";
            var autorParaCadastrar = AutorFactory.paraPersistir();
            autorParaCadastrar.setDescricao(mensagemGrande);

            autorService.cadastrar(autorParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Tamanho máximo é de 400 caracteres!', propertyPath=descricao");
        }
    }
}
