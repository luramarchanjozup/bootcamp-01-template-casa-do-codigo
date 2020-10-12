package dev.arielalvesdutrazup.cdc.it.services;

import dev.arielalvesdutrazup.cdc.entities.*;
import dev.arielalvesdutrazup.cdc.factories.entities.*;
import dev.arielalvesdutrazup.cdc.repositories.CompraItemRepository;
import dev.arielalvesdutrazup.cdc.repositories.CompraRepository;
import dev.arielalvesdutrazup.cdc.services.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ActiveProfiles;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class CompraServiceIT {

    @Autowired
    private LivroService livroService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private PaisService paisService;

    @Autowired
    private CompraService compraService;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CompraItemRepository compraItemRepository;

    private Livro livro;
    private Autor autor;
    private Categoria categoria;
    private Pais pais;

    @BeforeEach
    public void setUp() {
        pais = paisService.cadastrar(PaisFactory.paraPersistir());
        autor = autorService.cadastrar(AutorFactory.paraPersistir());
        categoria = categoriaService.cadastrar(CategoriaFactory.paraPersistir());
        livro = livroService.cadastrar(LivroFactory.paraPersistir(autor, categoria));
    }

    @AfterEach
    public void tearDown() {
        compraRepository.deleteAll();
        livroService.removeTodos();
        categoriaService.removeTodos();
        autorService.removeTodos();
        paisService.removeTodos();
    }

    @Test
    public void fecharCompra_comCPF_deveFuncionar() {
        var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);

        var compraCadastrada = compraService.fecharCompra(compraParaCadastrar);

        assertThat(compraCadastrada).isNotNull();
        assertThat(compraCadastrada.getId()).isNotNull();

        var compraBuscada = compraRepository.findById(compraCadastrada.getId()).get();
        List<CompraItem> compraItensBuscadoLista = compraItemRepository.findAllByCompraId(compraBuscada.getId());
        Set<CompraItem> compraItensBuscadoSet = new HashSet<>(compraItensBuscadoLista);

        assertThat(compraBuscada).isNotNull();
        assertThat(compraBuscada.getId()).isEqualTo(compraCadastrada.getId());
        assertThat(compraBuscada.getNome()).isEqualTo(compraParaCadastrar.getNome());
        assertThat(compraBuscada.getSobrenome()).isEqualTo(compraParaCadastrar.getSobrenome());
        assertThat(compraBuscada.getEmail()).isEqualTo(compraParaCadastrar.getEmail());
        assertThat(compraBuscada.getDocumento()).isEqualTo(compraParaCadastrar.getDocumento());
        assertThat(compraBuscada.getTelefone()).isEqualTo(compraParaCadastrar.getTelefone());
        assertThat(compraBuscada.getCep()).isEqualTo(compraParaCadastrar.getCep());
        assertThat(compraBuscada.getEndereco()).isEqualTo(compraParaCadastrar.getEndereco());
        assertThat(compraBuscada.getComplemento()).isEqualTo(compraParaCadastrar.getComplemento());
        assertThat(compraBuscada.getPais()).isEqualTo(compraParaCadastrar.getPais());
        assertThat(compraBuscada.getTotal()).isEqualTo(compraParaCadastrar.getTotal());
        assertThat(compraBuscada.getCadastradoEm()).isNotNull();
        assertThat(compraItensBuscadoSet).isEqualTo(compraCadastrada.getItens());
    }

    @Test
    public void fecharCompra_comCNPJ_deveFuncionar() {
        var cnpjFake = "48225592000176";
        var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
        compraParaCadastrar.setDocumento(cnpjFake);

        var compraCadastrada = compraService.fecharCompra(compraParaCadastrar);

        assertThat(compraCadastrada).isNotNull();
        assertThat(compraCadastrada.getId()).isNotNull();

        var compraBuscada = compraRepository.findById(compraCadastrada.getId()).get();

        assertThat(compraBuscada).isNotNull();
        assertThat(compraBuscada.getId()).isEqualTo(compraCadastrada.getId());
        assertThat(compraBuscada.getDocumento()).isEqualTo(compraParaCadastrar.getDocumento());
    }

    @Test
    public void fecharCompra_semEmail_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setEmail(null);

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='E-mail é obrigatório!', propertyPath=email");
        }
    }

    @Test
    public void fecharCompra_comEmailInvalido_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setEmail("emailinvalido");

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='E-mail deve ter um formato válido!', propertyPath=email");
        }
    }

    @Test
    public void fecharCompra_semNome_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setNome(null);

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Nome é obrigatório!', propertyPath=nome");
        }
    }

    @Test
    public void fecharCompra_semSobrenome_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setSobrenome(null);

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Sobrenome é obrigatório!', propertyPath=sobrenome");
        }
    }

    @Test
    public void fecharCompra_semDocumento_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setDocumento(null);

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Documento é obrigatório!', propertyPath=documento");
        }
    }

    @Test
    public void fecharCompra_comDocumentoCPFInvalido_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro, pais);
            compraParaCadastrar.setDocumento("99999");

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Documento inválido!', propertyPath=documento");
        }
    }

    @Test
    public void fecharCompra_comDocumentoCNPJInvalido_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setDocumento("99999999999999");

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Documento inválido!', propertyPath=documento");
        }
    }

    @Test
    public void fecharCompra_semEndereco_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setEndereco(null);

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Endereço é obrigatório!', propertyPath=endereco");
        }
    }

    @Test
    public void fecharCompra_semCidade_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setCidade(null);

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Cidade é obrigatória!', propertyPath=cidade");
        }
    }

    @Test
    public void fecharCompra_semPais_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setPais(null);

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='País é obrigatório!', propertyPath=pais");
        }
    }

    @Test
    public void fecharCompra_semTelefone_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setTelefone(null);

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Telefone é obrigatório!', propertyPath=telefone");
        }
    }

    @Test
    public void fecharCompra_semCep_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setCep(null);

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='CEP é obrigatório!', propertyPath=cep");
        }
    }

    @Test
    public void fecharCompra_comCepInvalido_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setCep("1232220");

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='CEP deve ter um formato válido!', propertyPath=cep");
        }
    }

    @Test
    public void fecharCompra_semItens_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setItens(null);

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (InvalidDataAccessApiUsageException e) {
            assertThat(e.getMessage()).contains("É obrigatório ao menos 1 item de compra!");
        }
    }

    @Test
    public void fecharCompra_comItensVazio_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setItens(new HashSet<>());

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (InvalidDataAccessApiUsageException e) {
            assertThat(e.getMessage()).contains("É obrigatório ao menos 1 item de compra!");
        }
    }

    @Test
    public void fecharCompra_comTotalIgualOuMenorAZero_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setTotal(new BigDecimal("0.00"));

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (InvalidDataAccessApiUsageException e) {
            assertThat(e.getMessage()).contains("Total deve ser maior que zero!");
        }
    }

    @Test
    public void fecharCompra_comTotalDiferenteDeCompraItems_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraPersistir(livro,pais);
            compraParaCadastrar.setTotal(new BigDecimal("36.90"));

            compraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (InvalidDataAccessApiUsageException e) {
            assertThat(e.getMessage()).contains("O total difere do valor dos itens da compra!");
        }
    }

    @Test
    public void fecharCompra_comCupom_deveFuncionar() {
        fail("Não implementado!");
    }

    @Test
    public void fecharCompra_comCupomInvalido_deveLancarException() {
        fail("Não implementado!");
    }
}
