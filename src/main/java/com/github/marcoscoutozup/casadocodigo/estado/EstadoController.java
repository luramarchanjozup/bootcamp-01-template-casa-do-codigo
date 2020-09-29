package com.github.marcoscoutozup.casadocodigo.estado;

import com.github.marcoscoutozup.casadocodigo.pais.Pais;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional                      //1
    public String cadastrarEstado(@RequestBody @Valid EstadoDTO dto){
        //2
        Pais pais = entityManager.find(Pais.class, dto.getPais());

        //3
        Estado estado = dto.toModel();
        estado.setPais(pais);

        entityManager.persist(estado);
        return estado.toString();
    }

}
