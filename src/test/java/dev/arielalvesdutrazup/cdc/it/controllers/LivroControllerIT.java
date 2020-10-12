package dev.arielalvesdutrazup.cdc.it.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.*;
import dev.arielalvesdutrazup.cdc.entities.Autor;
import dev.arielalvesdutrazup.cdc.entities.Categoria;
import dev.arielalvesdutrazup.cdc.entities.Livro;
import dev.arielalvesdutrazup.cdc.factories.entities.AutorFactory;
import dev.arielalvesdutrazup.cdc.factories.entities.CategoriaFactory;
import dev.arielalvesdutrazup.cdc.factories.entities.LivroFactory;
import dev.arielalvesdutrazup.cdc.services.AutorService;
import dev.arielalvesdutrazup.cdc.services.CategoriaService;
import dev.arielalvesdutrazup.cdc.services.LivroService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class LivroControllerIT {

    @Autowired
    private LivroService livroService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private TestRestTemplate restTemplate;

    private Autor autor;

    private Categoria categoria;

    private final String URL_BASE = "/livros";

    @BeforeEach
    public void setUp() {
        autor = autorService.cadastrar(AutorFactory.paraPersistir());
        categoria = categoriaService.cadastrar(CategoriaFactory.paraPersistir());
    }

    @AfterEach
    public void tearDown() {
        livroService.removeTodos();
        autorService.removeTodos();
        categoriaService.removeTodos();
    }

    @Test
    public void cadastrar_deveRetornar201() {
        var livroExemplo = LivroFactory.paraPersistir(autor, categoria);
        CadastrarLivroRequestDTO requestDTO = new CadastrarLivroRequestDTO()
                .setAutorId(autor.getId())
                .setCategoriaId(categoria.getId())
                .setTitulo(livroExemplo.getTitulo())
                .setResumo(livroExemplo.getResumo())
                .setSumario(livroExemplo.getSumario())
                .setNumeroDePaginas(livroExemplo.getNumeroDePaginas())
                .setPreco(livroExemplo.getPreco())
                .setIsbn(livroExemplo.getIsbn())
                .setDataPublicacao(livroExemplo.getDataPublicacao());

        ResponseEntity<LivroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                LivroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());

        HttpHeaders headers = responseEntity.getHeaders();

        assertThat(headers.getLocation()).isNotNull();


        LivroResponseDTO responseDTO = responseEntity.getBody();
        Livro livroBuscado = livroService.buscaPeloId(responseDTO.getId());

        assertThat(livroBuscado).isNotNull();
        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getId()).isEqualTo(livroBuscado.getId());
        assertThat(responseDTO.getTitulo()).isEqualTo(livroBuscado.getTitulo());
        assertThat(responseDTO.getResumo()).isEqualTo(livroBuscado.getResumo());
        assertThat(responseDTO.getSumario()).isEqualTo(livroBuscado.getSumario());
        assertThat(responseDTO.getNumeroDePaginas()).isEqualTo(livroBuscado.getNumeroDePaginas());
        assertThat(responseDTO.getDataPublicacao()).isEqualTo(livroBuscado.getDataPublicacao());
        assertThat(responseDTO.getPreco()).isEqualTo(livroBuscado.getPreco());
        assertThat(responseDTO.getIsbn()).isEqualTo(livroBuscado.getIsbn());
        assertThat(responseDTO.getCadastradoEm()).isNotNull();
        assertThat(headers.getLocation().getPath()).isEqualTo("/livros/" + responseDTO.getId());
    }

    @Test
    public void cadastrar_semTitulo_deveRetornar400() {
        var livroExemplo = LivroFactory.paraPersistir(autor, categoria);
        CadastrarLivroRequestDTO requestDTO = new CadastrarLivroRequestDTO()
                .setAutorId(autor.getId())
                .setCategoriaId(categoria.getId())
                .setResumo(livroExemplo.getResumo())
                .setSumario(livroExemplo.getSumario())
                .setNumeroDePaginas(livroExemplo.getNumeroDePaginas())
                .setPreco(livroExemplo.getPreco())
                .setIsbn(livroExemplo.getIsbn())
                .setDataPublicacao(livroExemplo.getDataPublicacao());

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void cadastrar_comAutorNaoCadastrado_deveRetornar404() {
        var livroExemplo = LivroFactory.paraPersistir(autor, categoria);
        CadastrarLivroRequestDTO requestDTO = new CadastrarLivroRequestDTO()
                .setAutorId(30000L)
                .setCategoriaId(categoria.getId())
                .setTitulo(livroExemplo.getTitulo())
                .setResumo(livroExemplo.getResumo())
                .setSumario(livroExemplo.getSumario())
                .setNumeroDePaginas(livroExemplo.getNumeroDePaginas())
                .setPreco(livroExemplo.getPreco())
                .setIsbn(livroExemplo.getIsbn())
                .setDataPublicacao(livroExemplo.getDataPublicacao());

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.NOT_FOUND.value());

        ErroResponseDTO responseDTO = responseEntity.getBody();

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getMensagem()).isEqualTo("Autor com id 30000 não localizado!");
    }

    @Test
    public void listarTodos_deveRetornar200() {
        var livroExemplo = livroService.cadastrar(
                autor.getId(),
                categoria.getId(),
                LivroFactory.paraPersistir(autor, categoria));

        ResponseEntity<List<LivroResponseDTO>> responseEntity = restTemplate.exchange(
                URL_BASE,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<LivroResponseDTO>>(){});

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

        List<LivroResponseDTO> listaDeLivros = responseEntity.getBody();

        assertThat(listaDeLivros).isNotNull();
        assertThat(listaDeLivros).contains(new LivroResponseDTO(livroExemplo));
    }

    @Test
    public void detalhe_deveRetornar200() {
        var livroExemplo = livroService.cadastrar(
                autor.getId(),
                categoria.getId(),
                LivroFactory.paraPersistir(autor, categoria));
        var url = URL_BASE + "/" + livroExemplo.getId();

        ResponseEntity<LivroDetalheResponseDTO> responseEntity = restTemplate.getForEntity(
                url,
                LivroDetalheResponseDTO.class);


        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

        LivroDetalheResponseDTO responseDTO = responseEntity.getBody();
        Livro livroBuscado = livroService.buscaPeloId(responseDTO.getId());

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getId()).isEqualTo(livroBuscado.getId());
        assertThat(responseDTO.getTitulo()).isEqualTo(livroBuscado.getTitulo());
        assertThat(responseDTO.getResumo()).isEqualTo(livroBuscado.getResumo());
        assertThat(responseDTO.getSumario()).isEqualTo(livroBuscado.getSumario());
        assertThat(responseDTO.getNumeroDePaginas()).isEqualTo(livroBuscado.getNumeroDePaginas());
        assertThat(responseDTO.getDataPublicacao()).isEqualTo(livroBuscado.getDataPublicacao());
        assertThat(responseDTO.getPreco()).isEqualTo(livroBuscado.getPreco());
        assertThat(responseDTO.getIsbn()).isEqualTo(livroBuscado.getIsbn());
        assertThat(responseDTO.getAutor()).isEqualTo(new AutorResponseDTO(livroBuscado.getAutor()));
        assertThat(responseDTO.getCategoria()).isEqualTo(new CategoriaResponseDTO(livroBuscado.getCategoria()));
        assertThat(responseDTO.getCadastradoEm()).isNotNull();
    }

    @Test
    public void detalhe_semLivroCadastrado_deveRetornar404() {
        var url = URL_BASE + "/" + 30200L;


        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.getForEntity(
                url,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.NOT_FOUND.value());

        ErroResponseDTO responseDTO = responseEntity.getBody();

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getMensagem()).isEqualTo("Livro com id 30200 não localizado!");
    }
}
