package com.cdcAPI.api.controller;

import com.cdcAPI.api.exception.ExceptionEmailDuplicado;
import com.cdcAPI.api.model.AutorRequest;
import com.cdcAPI.model.Autor;
import com.cdcAPI.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

//    @Autowired // Validar autor por email único
//    private ExceptionEmailDuplicado exceptionEmailDuplicado;
//
//    //Corte transversal para config validador
//    @InitBinder
//    public void init(WebDataBinder binder) {
//        //1
//        binder.addValidators(exceptionEmailDuplicado); //Add validação
//    }

    //Criar autor
    @PostMapping("/autores")
    @Transactional // Garantir processo completo, tudo ou nada. (com o .persiste)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> criarAutor(@Valid @RequestBody AutorRequest autorRequest) {
        Autor autor = autorRequest.toModel(); //Request da entidade para Model
        autorRepository.save(autor);

        return ResponseEntity.ok().build();
    }
}
