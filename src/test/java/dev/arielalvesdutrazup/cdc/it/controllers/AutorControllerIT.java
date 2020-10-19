package dev.arielalvesdutrazup.cdc.it.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.AutorResponseDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CadastrarAutorRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.ErroResponseDTO;
import dev.arielalvesdutrazup.cdc.entities.Autor;
import dev.arielalvesdutrazup.cdc.services.AutorService;
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
public class AutorControllerIT {

    @Autowired
    private AutorService autorService;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String URL_BASE = "/autores";

    @AfterEach
    public void tearDown() {
        autorService.removeTodos();
    }

    @Test
    public void cadastrar_deveRetornar201() {
        CadastrarAutorRequestDTO requestDTO = new CadastrarAutorRequestDTO()
                .setNome("Neil Gaiman")
                .setEmail("exemplo@exemplo.com")
                .setDescricao("Neil Richard MacKinnon Gaiman is an English author of short fiction, novels, comic books, graphic novels, nonfiction, audio theatre, and films.");

        ResponseEntity<AutorResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                AutorResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());

        HttpHeaders headers = responseEntity.getHeaders();

        assertThat(headers.getLocation()).isNotNull();

        AutorResponseDTO responseDTO = responseEntity.getBody();
        Autor autorBuscado = autorService.buscaPeloEmail(requestDTO.getEmail());

        assertThat(autorBuscado).isNotNull();
        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getId()).isEqualTo(autorBuscado.getId());
        assertThat(responseDTO.getNome()).isEqualTo(autorBuscado.getNome());
        assertThat(responseDTO.getEmail()).isEqualTo(autorBuscado.getEmail());
        assertThat(responseDTO.getDescricao()).isEqualTo(autorBuscado.getDescricao());
        assertThat(responseDTO.getCadastradoEm()).isNotNull();
    }

    @Test
    public void cadastrar_semNome_deveRetornar400() {
        CadastrarAutorRequestDTO requestDTO = new CadastrarAutorRequestDTO()
                .setEmail("exemplo@exemplo.com")
                .setDescricao("Neil Richard MacKinnon Gaiman is an English author of short fiction, novels, comic books, graphic novels, nonfiction, audio theatre, and films.");

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void cadastrar_comEmailDuplicado_deveRetornar400() {
        CadastrarAutorRequestDTO requestDTO = new CadastrarAutorRequestDTO()
                .setNome("Neil Gaiman")
                .setEmail("exemplo@exemplo.com")
                .setDescricao("Neil Richard MacKinnon Gaiman is an English author of short fiction, novels, comic books, graphic novels, nonfiction, audio theatre, and films.");


        restTemplate.postForEntity(URL_BASE, requestDTO,ErroResponseDTO.class);
        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void cadastrar_semEmail_deveRetornar400() {
        CadastrarAutorRequestDTO requestDTO = new CadastrarAutorRequestDTO()
                .setNome("Neil Gaiman")
                .setDescricao("Neil Richard MacKinnon Gaiman is an English author of short fiction, novels, comic books, graphic novels, nonfiction, audio theatre, and films.");

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    public void cadastrar_semDescricao_deveRetornar400() {
        CadastrarAutorRequestDTO cadastrarDto = new CadastrarAutorRequestDTO()
                .setNome("Neil Gaiman")
                .setEmail("exemplo@exemplo.com");

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                cadastrarDto,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
