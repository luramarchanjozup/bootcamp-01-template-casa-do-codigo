package com.apicasadocodigo.casadocodigo.controller;

import com.apicasadocodigo.casadocodigo.model.City;
import com.apicasadocodigo.casadocodigo.model.Client;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/registration")
public class ClientController {

    @Autowired
    private GenericDAO genericDAO; //1

    @PostMapping
    @Transactional                                                              //2
    public ResponseEntity<?> saveClienteRegistration(@RequestBody @Valid Client registration, UriComponentsBuilder builder){

        //buscar depedências: cidade, estado, pais.
        //3
        City city = genericDAO.findEntityDepedenceDyId(City.class, registration.getCityId());

        registration.getAddress().setCityAndStateAndCountry(city);

        Long recordId = genericDAO.saveEntity(registration).getId();

        URI uri = builder.path("/cleintsRecords/{id}").build(recordId);

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRegister(@PathVariable Long id){

        Client registration = genericDAO.findEntityDepedenceDyId(Client.class, id);

        return ResponseEntity.ok(registration);

    }

}
