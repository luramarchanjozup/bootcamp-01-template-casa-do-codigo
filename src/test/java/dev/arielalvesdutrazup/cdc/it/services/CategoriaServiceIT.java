package dev.arielalvesdutrazup.cdc.it.services;

import dev.arielalvesdutrazup.cdc.factories.entities.CategoriaFactory;
import dev.arielalvesdutrazup.cdc.repositories.CategoriaRepository;
import dev.arielalvesdutrazup.cdc.services.CategoriaService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class CategoriaServiceIT {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @AfterEach
    public void tearDown() {
        categoriaRepository.deleteAll();
    }

    @Test
    public void cadastrar_deveFuncionar() {
        var categoriaParaCadastrar = CategoriaFactory.paraPersistir();

        var categoriaCadastrada = categoriaService.cadastrar(categoriaParaCadastrar);

        assertThat(categoriaCadastrada).isNotNull();
        assertThat(categoriaCadastrada.getId()).isNotNull();

        var categoriaBuscada = categoriaRepository.findById(categoriaCadastrada.getId()).get();

        assertThat(categoriaBuscada).isNotNull();
        assertThat(categoriaBuscada.getId()).isEqualTo(categoriaCadastrada.getId());
        assertThat(categoriaBuscada.getNome()).isEqualTo(categoriaParaCadastrar.getNome());
        assertThat(categoriaBuscada.getCadastradoEm()).isNotNull();
    }

    @Test
    public void cadastrar_semNome_deveLancarUmaException() {
        try {
            var categoriaParaCadastrar = CategoriaFactory.paraPersistir();
            categoriaParaCadastrar.setNome(null);

            categoriaService.cadastrar(categoriaParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).contains("Nome é obrigatório para a consulta!");
        }
    }
    @Test
    public void cadastrar_comNomeDuplicado_deveLancarUmaException() {
        try {
            var categoriaParaCadastrar = CategoriaFactory.paraPersistir();

            categoriaService.cadastrar(categoriaParaCadastrar);
            categoriaService.cadastrar(categoriaParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (Exception e) {
            assertThat(e.getMessage()).contains("Nome duplicado!");
        }
    }

}
