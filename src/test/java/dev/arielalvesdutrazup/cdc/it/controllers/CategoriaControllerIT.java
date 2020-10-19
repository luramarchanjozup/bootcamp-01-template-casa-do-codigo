package dev.arielalvesdutrazup.cdc.it.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CadastrarCategoriaRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CategoriaResponseDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.ErroResponseDTO;
import dev.arielalvesdutrazup.cdc.entities.Categoria;
import dev.arielalvesdutrazup.cdc.services.CategoriaService;
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
public class CategoriaControllerIT {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String URL_BASE = "/categorias";

    @AfterEach
    public void tearDown() {
        categoriaService.removeTodos();
    }

    @Test
    public void cadastrar_deveRetornar201() {
        CadastrarCategoriaRequestDTO requestDTO = new CadastrarCategoriaRequestDTO()
                .setNome("Fantasia Medieval");

        ResponseEntity<CategoriaResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                CategoriaResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());

        HttpHeaders headers = responseEntity.getHeaders();

        assertThat(headers.getLocation()).isNotNull();

        CategoriaResponseDTO responseDTO = responseEntity.getBody();
        Categoria categoriaBuscada = categoriaService.buscaPeloNome(requestDTO.getNome());

        assertThat(categoriaBuscada).isNotNull();
        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getId()).isEqualTo(categoriaBuscada.getId());
        assertThat(responseDTO.getNome()).isEqualTo(categoriaBuscada.getNome());
        assertThat(responseDTO.getCadastradoEm()).isNotNull();
        assertThat(headers.getLocation().getRawPath()).isEqualTo("/categorias/" + responseDTO.getId());
    }

    @Test
    public void cadastrar_semNome_deveRetornar400() {
        CadastrarCategoriaRequestDTO requestDTO = new CadastrarCategoriaRequestDTO();

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void cadastrar_comNomeDuplicado_deveRetornar400() {
        CadastrarCategoriaRequestDTO requestDTO = new CadastrarCategoriaRequestDTO()
                .setNome("Fantasia Medieval");

        restTemplate.postForEntity(URL_BASE, requestDTO, ErroResponseDTO.class);
        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());

        ErroResponseDTO responseDTO = responseEntity.getBody();

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getMensagem()).isEqualTo("Nome duplicado!");
    }
}
