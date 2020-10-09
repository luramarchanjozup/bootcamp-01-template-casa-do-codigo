package br.com.zup.treinocasadocodigo.controllers;

import br.com.zup.treinocasadocodigo.entities.compra.Compra;
import br.com.zup.treinocasadocodigo.entities.compra.CompraRequest;
import br.com.zup.treinocasadocodigo.entities.compra.CompraRetorno;
import br.com.zup.treinocasadocodigo.validators.validarcompras.CompraValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

/**
 * Contagem de carga intrínseca da classe: 5
 */

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    //1
    private CompraValidador compraValidador;

    @PersistenceContext
    private EntityManager manager;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(compraValidador);
    }

    @PostMapping()
    @Transactional
    //1
    public ResponseEntity<Object> cadastroCompra(@RequestBody @Valid CompraRequest novaCompra) {

        //1
        Compra compra = novaCompra.toModel(manager);

        manager.persist(compra);

        URI location = URI.create(String.format("/compras/%d", compra.getId()));
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    //1
    public ResponseEntity<CompraRetorno> detalhesCompra(@PathVariable("id") Long id) {

        Compra compra = manager.find(Compra.class, id);

        //1
        if (compra == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new CompraRetorno(compra));
    }
}
