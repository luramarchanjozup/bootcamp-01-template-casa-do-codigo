package dev.arielalvesdutrazup.cdc.it.services;

import dev.arielalvesdutrazup.cdc.factories.entities.CupomFactory;
import dev.arielalvesdutrazup.cdc.repositories.CupomRepository;
import dev.arielalvesdutrazup.cdc.services.CupomService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.validation.ConstraintViolationException;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class CupomServiceIT {

    @Autowired
    private CupomService cupomService;

    @Autowired
    protected CupomRepository cupomRepository;

    @AfterEach
    public void tearDown() {
        cupomRepository.deleteAll();
    }

    @Test
    public void cadastrar_deveFuncionar() {
        var cupomParaCadatrar = CupomFactory.paraPersistir();

        var cupomCadastrado = cupomService.cadastrar(cupomParaCadatrar);

        assertThat(cupomCadastrado).isNotNull();
        assertThat(cupomCadastrado.getId()).isNotNull();

        var cupomBuscado = cupomRepository.findById(cupomCadastrado.getId()).get();

        assertThat(cupomBuscado).isNotNull();
        assertThat(cupomBuscado.getId()).isEqualTo(cupomCadastrado.getId());
        assertThat(cupomBuscado.getCodigo()).isEqualTo(cupomParaCadatrar.getCodigo());
        assertThat(cupomBuscado.getValidade().truncatedTo(ChronoUnit.SECONDS))
                .isEqualTo(cupomParaCadatrar.getValidade().truncatedTo(ChronoUnit.SECONDS));;
        assertThat(cupomBuscado.getPercentualDeDesconto()).isEqualTo(cupomParaCadatrar.getPercentualDeDesconto());
        assertThat(cupomBuscado.getCadastradoEm()).isNotNull();
    }

    @Test
    public void cadastrar_semCodigo_deveLancarException() {
        try {
            var cupomParaCadatrar = CupomFactory.paraPersistir();
            cupomParaCadatrar.setCodigo(null);

            cupomService.cadastrar(cupomParaCadatrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Código é obrigatório!', propertyPath=codigo");
        }
    }

    @Test
    public void cadastrar_comCodigoDuplicado_deveLancarException() {
        try {
            var cupomParaCadatrar = CupomFactory.paraPersistir();

            cupomService.cadastrar(cupomParaCadatrar);
            cupomService.cadastrar(cupomParaCadatrar);
            fail("Esperando uma exceção!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains("Cupom duplicado!");
        }
    }

    @Test
    public void cadastrar_semPercentualDeDesconto_deveLancarException() {
        try {
            var cupomParaCadatrar = CupomFactory.paraPersistir();
            cupomParaCadatrar.setPercentualDeDesconto(null);

            cupomService.cadastrar(cupomParaCadatrar);
            fail("Esperando uma exceção!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Percentual de desconto é obrigatório!', propertyPath=percentualDeDesconto");
        }
    }

    @Test
    public void cadastrar_comPercentualDeDescontoNegativo_deveLancarException() {
        try {
            var cupomParaCadatrar = CupomFactory.paraPersistir();
            cupomParaCadatrar.setPercentualDeDesconto(-1);

            cupomService.cadastrar(cupomParaCadatrar);
            fail("Esperando uma exceção!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Mínimo do percentual de desconto é 1!', propertyPath=percentualDeDesconto");
        }
    }

    @Test
    public void cadastrar_comPercentualDeDescontoAcimaDe100_deveLancarException() {
        try {
            var cupomParaCadatrar = CupomFactory.paraPersistir();
            cupomParaCadatrar.setPercentualDeDesconto(101);

            cupomService.cadastrar(cupomParaCadatrar);
            fail("Esperando uma exceção!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Máximo do percentual de desconto é 100!', propertyPath=percentualDeDesconto");
        }
    }

    @Test
    public void cadastrar_semValidade_deveLancarException() {
        try {
            var cupomParaCadatrar = CupomFactory.paraPersistir();
            cupomParaCadatrar.setValidade(null);

            cupomService.cadastrar(cupomParaCadatrar);
            fail("Esperando uma exceção!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Validade é obrigatória!', propertyPath=validade");
        }
    }

    @Test
    public void cadastrar_comValidadeDaDataDeCadastro_deveLancarException() {
        try {
            var cupomParaCadatrar = CupomFactory.paraPersistir();
            cupomParaCadatrar.setValidade(OffsetDateTime.now());

            cupomService.cadastrar(cupomParaCadatrar);
            fail("Esperando uma exceção!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Data de validade deve ser maior que a data de cadastro!', propertyPath=validade");
        }
    }

    @Test
    public void cadastrar_comValidadeDaDataAnteriorAoCadastro_deveLancarException() {
        try {
            var cupomParaCadatrar = CupomFactory.paraPersistir();
            cupomParaCadatrar.setValidade(OffsetDateTime.now().minusDays(1));

            cupomService.cadastrar(cupomParaCadatrar);
            fail("Esperando uma exceção!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Data de validade deve ser maior que a data de cadastro!', propertyPath=validade");
        }
    }
}
