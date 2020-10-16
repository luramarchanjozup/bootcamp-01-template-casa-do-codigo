package dev.arielalvesdutrazup.cdc.it.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CadastrarEstadoRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.ErroResponseDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.EstadoResponseDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.PaisResponseDTO;
import dev.arielalvesdutrazup.cdc.entities.Estado;
import dev.arielalvesdutrazup.cdc.entities.Pais;
import dev.arielalvesdutrazup.cdc.factories.entities.PaisFactory;
import dev.arielalvesdutrazup.cdc.services.EstadoService;
import dev.arielalvesdutrazup.cdc.services.PaisService;
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
public class EstadoControllerIT {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private PaisService paisService;

    @Autowired
    private TestRestTemplate restTemplate;

    private Pais pais;

    @BeforeEach
    public void setUp() {
        pais = paisService.cadastrar(PaisFactory.paraPersistir());
    }

    @AfterEach
    public void tearDown() {
        estadoService.removeTodos();
        paisService.removeTodos();
    }

    @Test
    public void cadastrar_deveRetornar201() {
        CadastrarEstadoRequestDTO requestDTO = new CadastrarEstadoRequestDTO()
                .setNome("Rio Grande do Sul")
                .setCodigo("RS");

        ResponseEntity<EstadoResponseDTO> responseEntity = restTemplate.postForEntity(
                getUrlBase(pais.getId()),
                requestDTO,
                EstadoResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());

        HttpHeaders headers = responseEntity.getHeaders();

        assertThat(headers.getLocation()).isNotNull();

        EstadoResponseDTO responseDTO = responseEntity.getBody();
        Estado estadoBuscado = estadoService.buscaPeloNomeEPais(requestDTO.getNome(), pais);

        assertThat(estadoBuscado).isNotNull();
        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getId()).isEqualTo(estadoBuscado.getId());
        assertThat(responseDTO.getNome()).isEqualTo(estadoBuscado.getNome());
        assertThat(responseDTO.getCodigo()).isEqualTo(estadoBuscado.getCodigo());
        assertThat(responseDTO.getPais()).isEqualTo(new PaisResponseDTO(pais));
        assertThat(responseDTO.getCadastradoEm()).isNotNull();
    }

    @Test
    public void cadastrar_semNome_deveRetornar400() {
        CadastrarEstadoRequestDTO requestDTO = new CadastrarEstadoRequestDTO()
                .setCodigo("RS");

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                getUrlBase(pais.getId()),
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void cadastrar_comNomeDeEstadoDoMesmoPaisDuplicado_deveRetornar400() {
        CadastrarEstadoRequestDTO requestDTO = new CadastrarEstadoRequestDTO()
                .setNome("Rio Grande do Sul")
                .setCodigo("RS");

        restTemplate.postForEntity(
                getUrlBase(pais.getId()),
                requestDTO,
                ErroResponseDTO.class);
        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                getUrlBase(pais.getId()),
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());

        ErroResponseDTO responseDTO = responseEntity.getBody();

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getMensagem()).isEqualTo("Nome duplicado!");
    }

    @Test
    public void cadastrar_semCodigo_deveRetornar400() {
        CadastrarEstadoRequestDTO requestDTO = new CadastrarEstadoRequestDTO()
                .setNome("Rio Grande do Sul");

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                getUrlBase(pais.getId()),
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void cadastrar_comPaisIdInvalido_deveRetornar404() {
        CadastrarEstadoRequestDTO requestDTO = new CadastrarEstadoRequestDTO()
                .setNome("Rio Grande do Sul")
                .setCodigo("RS");

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                getUrlBase(12312L),
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.NOT_FOUND.value());

        ErroResponseDTO responseDTO = responseEntity.getBody();

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getMensagem()).isEqualTo("Pais com id 12312 não localizado!");
    }

    /**
     * Retorna a URL base com o ID do pais
     *
     * Exemplo de URL retornada: /paises/53/estados
     *
     * @param paisId
     * @return
     */
    private String getUrlBase(Long paisId) {
        return "/paises/" + paisId + "/estados";
    }
}
