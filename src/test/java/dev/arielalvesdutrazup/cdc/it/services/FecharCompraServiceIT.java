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

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class FecharCompraServiceIT {

    @Autowired
    private LivroService livroService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private PaisService paisService;

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private CupomService cupomService;

    @Autowired
    private FecharCompraService fecharCompraService;

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
        livro = livroService.cadastrar(autor.getId(), categoria.getId(), LivroFactory.paraPersistir(autor, categoria));
    }

    @AfterEach
    public void tearDown() {
        compraRepository.deleteAll();
        estadoService.removeTodos();
        cupomService.removeTodos();
        livroService.removeTodos();
        categoriaService.removeTodos();
        autorService.removeTodos();
        paisService.removeTodos();
    }

    @Test
    public void fecharCompra_comCPF_deveFuncionar() {
        var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);

        var compraCadastrada = fecharCompraService.fecharCompra(compraParaCadastrar);

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
        assertThat(compraBuscada.getPais()).isEqualTo(compraCadastrada.getPais());
        assertThat(compraBuscada.getTotal()).isEqualTo(compraParaCadastrar.getTotal());
        assertThat(compraBuscada.getCadastradoEm()).isNotNull();
        assertThat(compraItensBuscadoSet).isEqualTo(compraCadastrada.getItens());

        CompraItem item = compraItensBuscadoLista.get(0);

        assertThat(item).isNotNull();
        assertThat(item.getId()).isNotNull();
        assertThat(item.getQuantidade()).isEqualTo(2);
        assertThat(item.getPreco()).isEqualTo(new BigDecimal("100.00"));
    }

    @Test
    public void fecharCompra_comCNPJ_deveFuncionar() {
        var cnpjFake = "48225592000176";
        var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
        compraParaCadastrar.setDocumento(cnpjFake);

        var compraCadastrada = fecharCompraService.fecharCompra(compraParaCadastrar);

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
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setEmail(null);

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='E-mail é obrigatório!', propertyPath=email");
        }
    }

    @Test
    public void fecharCompra_comEmailInvalido_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setEmail("emailinvalido");

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='E-mail deve ter um formato válido!', propertyPath=email");
        }
    }

    @Test
    public void fecharCompra_semNome_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setNome(null);

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Nome é obrigatório!', propertyPath=nome");
        }
    }

    @Test
    public void fecharCompra_semSobrenome_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setSobrenome(null);

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Sobrenome é obrigatório!', propertyPath=sobrenome");
        }
    }

    @Test
    public void fecharCompra_semDocumento_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setDocumento(null);

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Documento é obrigatório!', propertyPath=documento");
        }
    }

    @Test
    public void fecharCompra_comDocumentoCPFInvalido_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro, pais);
            compraParaCadastrar.setDocumento("99999");

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Documento inválido!', propertyPath=documento");
        }
    }

    @Test
    public void fecharCompra_semEndereco_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setEndereco(null);

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Endereço é obrigatório!', propertyPath=endereco");
        }
    }

    @Test
    public void fecharCompra_semCidade_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setCidade(null);

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Cidade é obrigatória!', propertyPath=cidade");
        }
    }

    @Test
    public void fecharCompra_comPaisNaoCadastrado_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setPaisId(200001L);

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (EntityNotFoundException e) {
            assertThat(e.getMessage()).contains("Pais com id 200001 não localizado!");
        }
    }

    @Test
    public void fecharCompra_semTelefone_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setTelefone(null);

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Telefone é obrigatório!', propertyPath=telefone");
        }
    }

    @Test
    public void fecharCompra_semCep_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setCep(null);

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='CEP é obrigatório!', propertyPath=cep");
        }
    }

    @Test
    public void fecharCompra_comCepInvalido_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setCep("1232220");

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='CEP deve ter um formato válido!', propertyPath=cep");
        }
    }

    @Test
    public void fecharCompra_semItens_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setItens(null);

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).contains("É obrigatório ao menos 1 item de compra!");
        }
    }

    @Test
    public void fecharCompra_comItensVazio_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setItens(new HashSet<>());

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (InvalidDataAccessApiUsageException e) {
            assertThat(e.getMessage()).contains("É obrigatório ao menos 1 item de compra!");
        }
    }

    @Test
    public void fecharCompra_comTotalIgualOuMenorAZero_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setTotal(new BigDecimal("0.00"));

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (InvalidDataAccessApiUsageException e) {
            assertThat(e.getMessage()).contains("Total deve ser maior que zero!");
        }
    }

    @Test
    public void fecharCompra_comTotalDiferenteDeCompraItems_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setTotal(new BigDecimal("36.90"));

            fecharCompraService.fecharCompra(compraParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (InvalidDataAccessApiUsageException e) {
            assertThat(e.getMessage()).contains("O total difere do valor dos itens da compra!");
        }
    }

    @Test
    public void fecharCompra_comEstado_deveFuncionar() {
        var estado = estadoService.cadastrar(pais.getId(), EstadoFactory.paraPersistir(pais));
        var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
        compraParaCadastrar.setEstadoId(estado.getId());

        var compraCadastrada = fecharCompraService.fecharCompra(compraParaCadastrar);

        assertThat(compraCadastrada).isNotNull();
        assertThat(compraCadastrada.getId()).isNotNull();

        var compraBuscada = compraRepository.findById(compraCadastrada.getId()).get();

        assertThat(compraBuscada).isNotNull();
        assertThat(compraBuscada.getId()).isEqualTo(compraCadastrada.getId());
        assertThat(compraBuscada.getEstado()).isNotNull();
        assertThat(compraBuscada.getEstado()).isEqualTo(compraCadastrada.getEstado());
    }

    @Test
    public void fecharCompra_comCupom_deveFuncionar() {
        var cupom = cupomService.cadastrar(CupomFactory.paraPersistir());
        var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
        compraParaCadastrar.setCupomCodigo(cupom.getCodigo());

        var compraCadastrada = fecharCompraService.fecharCompra(compraParaCadastrar);

        assertThat(compraCadastrada).isNotNull();
        assertThat(compraCadastrada.getId()).isNotNull();

        var compraBuscada = compraRepository.findById(compraCadastrada.getId()).get();;

        assertThat(compraBuscada).isNotNull();
        assertThat(compraBuscada.getId()).isEqualTo(compraCadastrada.getId());
        assertThat(compraBuscada.getTotal()).isEqualTo(new BigDecimal("180.00"));
        assertThat(compraBuscada.getTotalSemDesconto()).isEqualTo(new BigDecimal("200.00"));
        assertThat(compraBuscada.getCupomAplicado()).isNotNull();

        var cupomAplicado = compraBuscada.getCupomAplicado();
        assertThat(cupomAplicado.getCupom()).isEqualTo(cupom);
        assertThat(cupomAplicado.getCodigo()).isEqualTo(cupom.getCodigo());
        assertThat(cupomAplicado.getValidade().truncatedTo(ChronoUnit.SECONDS)).isEqualTo(cupom.getValidade().truncatedTo(ChronoUnit.SECONDS));
        assertThat(cupomAplicado.getPercentualDeDesconto()).isEqualTo(cupom.getPercentualDeDesconto());
    }

    @Test
    public void fecharCompra_comCupomInvalido_deveLancarException() {
        try {
            var compraParaCadastrar = CompraFactory.paraFecharCompra(livro,pais);
            compraParaCadastrar.setCupomCodigo("codigoinvalidoaqui");

            fecharCompraService.fecharCompra(compraParaCadastrar);
        } catch (EntityNotFoundException e) {
            assertThat(e.getMessage()).contains("Cupom com cógido codigoinvalidoaqui não localizado!");
        }
    }
}
