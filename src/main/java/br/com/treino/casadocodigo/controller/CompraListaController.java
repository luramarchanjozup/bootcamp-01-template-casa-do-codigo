package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Compra;
import br.com.treino.casadocodigo.repository.CupomRepositoy;
import br.com.treino.casadocodigo.request.NovaCompraRequest;
import br.com.treino.casadocodigo.response.DetalheCompraResponse;
import br.com.treino.casadocodigo.validations.CupomValidoValidator;
import br.com.treino.casadocodigo.validations.EstadoPertenceAoPaisValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/compras")
public class CompraListaController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping(value = "/{id}")
    public ResponseEntity<DetalheCompraResponse> consultarCompra(@PathVariable("id") Long id){ //1

        Compra novaCompra = entityManager.find(Compra.class, id); //2

        if (!ObjectUtils.isEmpty(novaCompra)){ //3
            return new ResponseEntity<>(new DetalheCompraResponse(novaCompra),
                    HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();

    }


}
