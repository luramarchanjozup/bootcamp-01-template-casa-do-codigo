package dev.arielalvesdutrazup.cdc.it.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CadastrarPaisRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.ErroResponseDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.PaisResponseDTO;
import dev.arielalvesdutrazup.cdc.entities.Pais;
import dev.arielalvesdutrazup.cdc.services.PaisService;
import org.junit.jupiter.api.AfterEach;
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
public class PaisControllerIT {
    
    @Autowired
    private PaisService paisService;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String URL_BASE = "/paises";

    @AfterEach
    public void tearDown() {
        paisService.removeTodos();
    }
    
    @Test
    public void cadastrar_deveRetornar201() {
        CadastrarPaisRequestDTO requestDTO = new CadastrarPaisRequestDTO()
                .setNome("Brasil")
                .setCodigo("BR");

        ResponseEntity<PaisResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                PaisResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());

        HttpHeaders headers = responseEntity.getHeaders();

        assertThat(headers.getLocation()).isNotNull();

        PaisResponseDTO responseDTO = responseEntity.getBody();
        Pais paisBuscado = paisService.buscaPeloNome(requestDTO.getNome());

        assertThat(paisBuscado).isNotNull();
        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getId()).isEqualTo(paisBuscado.getId());
        assertThat(responseDTO.getNome()).isEqualTo(paisBuscado.getNome());
        assertThat(responseDTO.getCodigo()).isEqualTo(paisBuscado.getCodigo());
        assertThat(responseDTO.getCadastradoEm()).isNotNull();
    }

    @Test
    public void cadastrar_semNome_deveRetornar400() {
        CadastrarPaisRequestDTO requestDTO = new CadastrarPaisRequestDTO()
                .setCodigo("BR");

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void cadastrar_comNomeDuplicado_deveRetornar400() {
        CadastrarPaisRequestDTO requestDTO = new CadastrarPaisRequestDTO()
                .setNome("Brasil")
                .setCodigo("BR");

        restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                PaisResponseDTO.class);
        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void cadastrar_semCodigo_deveRetornar400() {
        CadastrarPaisRequestDTO requestDTO = new CadastrarPaisRequestDTO()
                .setNome("Brasil");

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
