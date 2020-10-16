package dev.arielalvesdutrazup.cdc.it.controllers;

import dev.arielalvesdutrazup.cdc.controllers.dtos.AlterarCupomRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CadastrarCupomRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CupomResponseDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.ErroResponseDTO;
import dev.arielalvesdutrazup.cdc.entities.Cupom;
import dev.arielalvesdutrazup.cdc.factories.entities.CupomFactory;
import dev.arielalvesdutrazup.cdc.services.CupomService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class CupomControllerIT {

    @Autowired
    private CupomService cupomService;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String URL_BASE = "/cupons";

    @AfterEach
    public void tearDown() {
        cupomService.removeTodos();
    }

    @Test
    public void cadastrar_deveRetornar201() {
        CadastrarCupomRequestDTO requestDTO = new CadastrarCupomRequestDTO()
                .setCodigo("ZUP10")
                .setValidade(LocalDateTime.now().plusDays(20))
                .setPercentualDeDesconto(10);

        ResponseEntity<CupomResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                CupomResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.CREATED.value());

        HttpHeaders headers = responseEntity.getHeaders();

        assertThat(headers.getLocation()).isNotNull();

        CupomResponseDTO responseDTO = responseEntity.getBody();
        Cupom cupomBuscado = cupomService.buscaPeloCodigo(requestDTO.getCodigo());

        assertThat(cupomBuscado).isNotNull();
        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getId()).isEqualTo(cupomBuscado.getId());
        assertThat(responseDTO.getCodigo()).isEqualTo(cupomBuscado.getCodigo());
        assertThat(responseDTO.getPercentualDeDesconto()).isEqualTo(cupomBuscado.getPercentualDeDesconto());
        assertThat(responseDTO.getValidade()).isNotNull();
        assertThat(headers.getLocation().getPath()).isEqualTo("/cupons/" + responseDTO.getId());
    }

    @Test
    public void cadastrar_semCodigo_deveRetornar400() {
        CadastrarCupomRequestDTO requestDTO = new CadastrarCupomRequestDTO()
                .setValidade(LocalDateTime.now().plusDays(20))
                .setPercentualDeDesconto(10);

        ResponseEntity<CupomResponseDTO> responseEntity = restTemplate.postForEntity(
                URL_BASE,
                requestDTO,
                CupomResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    public void alterar_deveRetornar200() {
        Cupom cupomCadastrado = cupomService.cadastrar(CupomFactory.paraPersistir());
        AlterarCupomRequestDTO requestDTO = new AlterarCupomRequestDTO()
                .setCodigo("ZUP15")
                .setValidade(LocalDateTime.now().plusDays(30))
                .setPercentualDeDesconto(15);
        var url = URL_BASE + "/" + cupomCadastrado.getId();
        var httpHeaders = new HttpHeaders();
        var httpEntity = new HttpEntity<>(requestDTO, httpHeaders);

        ResponseEntity<CupomResponseDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                httpEntity,
                CupomResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());

        CupomResponseDTO responseDTO = responseEntity.getBody();

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getId()).isEqualTo(cupomCadastrado.getId());
        assertThat(responseDTO.getCodigo()).isEqualTo(requestDTO.getCodigo());
        assertThat(responseDTO.getPercentualDeDesconto()).isEqualTo(requestDTO.getPercentualDeDesconto());
        assertThat(responseDTO.getValidade()).isNotNull();
    }

    @Test
    public void alterar_comCodigoDuplicadoDeOutroCupom_deveRetornar400() {
        Cupom cupomCadastrado = cupomService.cadastrar(CupomFactory.paraPersistir());
        Cupom cupomCadastrado2 = cupomService.cadastrar(CupomFactory.paraPersistir2());
        var url = URL_BASE + "/" + cupomCadastrado2.getId();
        AlterarCupomRequestDTO requestDTO = new AlterarCupomRequestDTO()
                .setCodigo(cupomCadastrado.getCodigo())
                .setValidade(LocalDateTime.now().plusDays(30))
                .setPercentualDeDesconto(15);
        var httpHeaders = new HttpHeaders();
        var httpEntity = new HttpEntity<>(requestDTO, httpHeaders);

        ResponseEntity<ErroResponseDTO> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                httpEntity,
                ErroResponseDTO.class);

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.BAD_REQUEST.value());

        ErroResponseDTO responseDTO = responseEntity.getBody();

        assertThat(responseDTO).isNotNull();
        assertThat(responseDTO.getMensagem()).isEqualTo("Já existe outro cupom com este código!");
    }
}
