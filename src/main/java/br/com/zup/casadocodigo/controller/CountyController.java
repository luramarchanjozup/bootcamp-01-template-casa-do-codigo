package br.com.zup.casadocodigo.controller;

import br.com.zup.casadocodigo.domain.Country;
import br.com.zup.casadocodigo.dto.CountryDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CountyController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/country")
    @Transactional
    public ResponseEntity<?> createCountry(@RequestBody @Valid CountryDTO countryDTO) {
        Country newCountry = new Country(countryDTO.getName());
        entityManager.persist(newCountry);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCountry);
    }
}
