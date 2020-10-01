package com.github.marcoscoutozup.casadocodigo.fluxocompra;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.compra.Compra;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.compra.CompraDTO;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.validators.EstadoPertenceAPaisValidator;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.validators.ValorTotalDoPedidoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired //1
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    @Autowired //2
    private ValorTotalDoPedidoValidator valorTotalDoPedidoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoPertenceAPaisValidator, valorTotalDoPedidoValidator);
    }

    @PostMapping
    @Transactional                                       //3
    public String realizarCompra(@RequestBody @Valid CompraDTO dto){
        //4
        Compra compra = dto.toModel(entityManager);
        entityManager.persist(compra);
        return compra.toString();
    }

}
