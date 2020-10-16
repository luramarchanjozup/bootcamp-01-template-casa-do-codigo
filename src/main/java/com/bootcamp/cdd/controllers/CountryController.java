package com.bootcamp.cdd.controllers;

import com.bootcamp.cdd.models.Country;
import com.bootcamp.cdd.request.CountryRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {
    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Country createCountry (@Valid @RequestBody CountryRequest req) {
        Country country = req.toModel();
        entityManager.persist(country);
        return country;
    }
}
