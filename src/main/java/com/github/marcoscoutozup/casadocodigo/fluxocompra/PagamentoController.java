package com.github.marcoscoutozup.casadocodigo.fluxocompra;

import com.github.marcoscoutozup.casadocodigo.estado.Estado;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.compra.Compra;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.compra.CompraDTO;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.pedido.PedidoDTO;
import com.github.marcoscoutozup.casadocodigo.pais.Pais;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional                                  //1
    public String realizarCompra(@RequestBody @Valid CompraDTO dto){

        //2
        Pais pais = entityManager.find(Pais.class, dto.getCliente().getPais());
        UUID idEstado = dto.getCliente().getEstado();

        //3
        if(idEstado != null){
            pais.validaSeEstadoPertenceAoPais(idEstado);
        }

        //4
        PedidoDTO pedido = dto.getPedido();
        pedido.validarTotalDoPedido(pedido.getTotal(), entityManager);

        //5
        Compra compra = dto.toModel();
        entityManager.persist(compra);

        return compra.toString();
    }

}
