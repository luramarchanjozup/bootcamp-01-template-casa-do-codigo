package br.com.casadocodigo.controllers;

import br.com.casadocodigo.forms.CountryForm;
import br.com.casadocodigo.models.Country;
import br.com.casadocodigo.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;
import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/countries")
public class CountryController {


    /* pontos de dificuldade de entendimento = 3  */

    /* @complexidade (1) - acoplamento contextual */
    private final CountryRepository countryRepository;

    private final Logger logger = LoggerFactory.getLogger(Country.class);


    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @PostMapping
    public ResponseEntity<?> createCountry(@RequestBody @Valid CountryForm countryForm,
                                           UriComponentsBuilder uriComponentsBuilder){

        /* @complexidade (2) - método em classe específica do projeto */
        var country = countryForm.toEntity();
        countryRepository.save(country);

        logger.info("[NOVO PAÍS] Novo país {} criado no sistema em {}", country.getName(), OffsetDateTime.now());

        return ResponseEntity
                .created(uriComponentsBuilder.path("/api/countries").buildAndExpand().toUri())
                .build();

    }
}
