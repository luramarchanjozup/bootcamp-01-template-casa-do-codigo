package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Pedido;
import br.com.treino.casadocodigo.request.NovoPedidoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Pedido> novoPedido(@RequestBody @Valid NovoPedidoRequest request){

        Pedido novoPedido = request.toModel(entityManager);

        entityManager.persist(novoPedido);

        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }
}
