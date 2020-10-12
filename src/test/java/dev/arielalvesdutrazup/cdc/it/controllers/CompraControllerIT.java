package dev.arielalvesdutrazup.cdc.it.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.*;
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
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class CompraControllerIT {

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
    private CupomService cupomService;

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private CompraItemRepository compraItemRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String URL_BASE = "/compras";

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
        livroService.removeTodos();
        cupomService.removeTodos();
        categoriaService.removeTodos();
        autorService.removeTodos();
        paisService.removeTodos();
    }

    @Test
    public void fecharCompra_deveRetornar201() {
        CompraRequestDTO requestDTO = CompraFactory.paraFecharCompra(livro, pais);

        ResponseEntity<CompraResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                CompraResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());

        HttpHeaders headers = responseEntity.getHeaders();

        assertThat(headers.getLocation()).isNotNull();


        CompraResponseDTO responseDTO = responseEntity.getBody();
        Compra compraBuscada = compraService.buscaPeloId(responseDTO.getId());

        assertThat(compraBuscada).isNotNull();
        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getId()).isEqualTo(compraBuscada.getId());
        assertThat(responseDTO.getNome()).isEqualTo(compraBuscada.getNome());
        assertThat(responseDTO.getSobrenome()).isEqualTo(compraBuscada.getSobrenome());
        assertThat(responseDTO.getEmail()).isEqualTo(compraBuscada.getEmail());
        assertThat(responseDTO.getDocumento()).isEqualTo(compraBuscada.getDocumento());
        assertThat(responseDTO.getEndereco()).isEqualTo(compraBuscada.getEndereco());
        assertThat(responseDTO.getCidade()).isEqualTo(compraBuscada.getCidade());
        assertThat(responseDTO.getComplemento()).isEqualTo(compraBuscada.getComplemento());
        assertThat(responseDTO.getTelefone()).isEqualTo(compraBuscada.getTelefone());
        assertThat(responseDTO.getTotal()).isEqualTo(compraBuscada.getTotal());
        assertThat(responseDTO.getItens()).isEqualTo(CompraItemResponseDTO.paraDTO(compraBuscada.getItens()));
        assertThat(responseDTO.getCadastradoEm()).isNotNull();
        assertThat(headers.getLocation().getPath()).isEqualTo("/compras/" + responseDTO.getId());
    }

    @Test
    public void fecharCompra_semNome_deveRetornar400() {
        CompraRequestDTO requestDTO = CompraFactory.paraFecharCompra(livro, pais);
        requestDTO.setNome(null);

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());

        ErroResponseDTO responseDTO = responseEntity.getBody();

        assertThat(responseDTO).isNotNull();
    }

    @Test
    public void detalhe_deveRetornar200() {
        var compraCadastrada = compraService.fecharCompra(CompraFactory.paraFecharCompra(livro, pais));
        var url = URL_BASE + "/" + compraCadastrada.getId();


        ResponseEntity<CompraResponseDTO> responseEntity = restTemplate.getForEntity(
                url,
                CompraResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

        CompraResponseDTO responseDTO = responseEntity.getBody();

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getId()).isEqualTo(compraCadastrada.getId());
        assertThat(responseDTO.getTotal()).isEqualTo(compraCadastrada.getTotal());
        assertThat(responseDTO.getTotalSemDesconto()).isEqualTo(compraCadastrada.getTotalSemDesconto());
    }

    @Test
    public void detalhe_comCupom_deveRetornar200() {
        var cupom = cupomService.cadastrar(CupomFactory.paraPersistir());
        var compraParaCadastrar = CompraFactory.paraFecharCompra(livro, pais);
        compraParaCadastrar.setCupomCodigo(cupom.getCodigo());
        var compraCadastrada = compraService.fecharCompra(compraParaCadastrar);
        var url = URL_BASE + "/" + compraCadastrada.getId();


        ResponseEntity<CompraResponseDTO> responseEntity = restTemplate.getForEntity(
                url,
                CompraResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

        CompraResponseDTO responseDTO = responseEntity.getBody();

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getId()).isEqualTo(compraCadastrada.getId());
        assertThat(responseDTO.getTotal()).isEqualTo(compraCadastrada.getTotal());
        assertThat(responseDTO.getTotalSemDesconto()).isEqualTo(compraCadastrada.getTotalSemDesconto());
        assertThat(responseDTO.getCupomAplicado()).isEqualTo(new CupomAplicadoDTO(compraCadastrada.getCupomAplicado()));
    }
}
