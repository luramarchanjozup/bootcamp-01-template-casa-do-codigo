package dev.arielalvesdutrazup.cdc.it.services;

import dev.arielalvesdutrazup.cdc.entities.Pais;
import dev.arielalvesdutrazup.cdc.factories.entities.EstadoFactory;
import dev.arielalvesdutrazup.cdc.factories.entities.PaisFactory;
import dev.arielalvesdutrazup.cdc.repositories.EstadoRepository;
import dev.arielalvesdutrazup.cdc.services.EstadoService;
import dev.arielalvesdutrazup.cdc.services.PaisService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class EstadoServiceIT {

    @Autowired
    private PaisService paisService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private EstadoRepository estadoRepository;

    private Pais pais;

    @BeforeEach
    public void setUp() {
        pais = paisService.cadastrar(PaisFactory.paraPersistir());
    }

    @AfterEach
    public void tearDown() {
        estadoRepository.deleteAll();
        paisService.removeTodos();
    }

    @Test
    public void cadastrar_deveFuncionar() {
        var estadoParaCadastrar = EstadoFactory.paraPersistir(pais);

        var estadoCadastrado = estadoService.cadastrar(pais.getId(), estadoParaCadastrar);

        assertThat(estadoCadastrado).isNotNull();
        assertThat(estadoCadastrado.getId()).isNotNull();

        var estadoBuscado = estadoRepository.findById(estadoCadastrado.getId()).get();

        assertThat(estadoBuscado).isNotNull();
        assertThat(estadoBuscado.getId()).isEqualTo(estadoCadastrado.getId());
        assertThat(estadoBuscado.getNome()).isEqualTo(estadoParaCadastrar.getNome());
        assertThat(estadoBuscado.getCodigo()).isEqualTo(estadoParaCadastrar.getCodigo());
        assertThat(estadoBuscado.getPais()).isEqualTo(estadoParaCadastrar.getPais());
        assertThat(estadoBuscado.getCadastradoEm()).isNotNull();
    }

    @Test
    public void cadastrar_semNome_deveLancarException() {
        try {
            var estadoParaCadastrar = EstadoFactory.paraPersistir(pais);
            estadoParaCadastrar.setNome(null);

            estadoService.cadastrar(pais.getId(), estadoParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Nome é obrigatório!', propertyPath=nome");
        }
    }

    @Test
    public void cadastrar_comNomeDuplicado_deveLancarException() {
        try {
            var estadoParaCadastrar = EstadoFactory.paraPersistir(pais);

            estadoService.cadastrar(pais.getId(), estadoParaCadastrar);
            estadoService.cadastrar(pais.getId(), estadoParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains("Nome duplicado!");
        }
    }

    @Test
    public void cadastrar_semPais_deveLancarException() {
        try {
            var estadoParaCadastrar = EstadoFactory.paraPersistir(pais);
            estadoParaCadastrar.setPais(null);

            estadoService.cadastrar(null , estadoParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).contains("O ID do país não pode ser nulo!");
        }
    }

    @Test
    public void cadastrar_comPaisNaoCadastroNoBanco_deveLancarException() {
        try {
            var estadoParaCadastrar = EstadoFactory.paraPersistir(pais);

            estadoService.cadastrar(212000L, estadoParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (EntityNotFoundException e) {
            assertThat(e.getMessage()).contains("Pais com id 212000 não localizado!");
        }
    }

    @Test
    public void buscaPeloNomeEPais_semPais_deveLancarException() {
        try {
            var estadoParaCadastrar = EstadoFactory.paraPersistir(pais);

            estadoService.buscaPeloNomeEPais(estadoParaCadastrar.getNome(), null);
            fail("Esperando uma exceção!");
        } catch (EntityNotFoundException e) {
            assertThat(e.getMessage()).contains("Estado com nome Rio Grande do Sul não localizado!");
        }
    }
}
