package bootcamp.challenges.casadocodigo.controllers;

import bootcamp.challenges.casadocodigo.dtos.CountryDto;
import bootcamp.challenges.casadocodigo.dtos.StateDto;
import bootcamp.challenges.casadocodigo.entities.Country;
import bootcamp.challenges.casadocodigo.entities.State;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;


@RestController
public class LocationController {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostMapping("/countries")
    public ResponseEntity<Country> countryRegister(@RequestBody @Valid CountryDto countryDto, UriComponentsBuilder uriComponentsBuilder){
        Country country = countryDto.toModel();
        entityManager.persist(country);
        return ResponseEntity.created(uriComponentsBuilder.path("/countries/{id}").buildAndExpand(country.getId()).toUri()).build();
    }
    @Transactional
    @PostMapping("/states")
    public ResponseEntity<State> stateRegister(@RequestBody @Valid StateDto stateDto, UriComponentsBuilder uriComponentsBuilder){
        State state = stateDto.toModel(entityManager);
        entityManager.persist(state);
        return ResponseEntity.created(uriComponentsBuilder.path("/states/{id}").buildAndExpand(state.getId()).toUri()).build();
    }
}
