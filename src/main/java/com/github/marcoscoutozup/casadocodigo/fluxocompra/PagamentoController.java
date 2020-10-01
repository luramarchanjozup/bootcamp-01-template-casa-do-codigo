package com.github.marcoscoutozup.casadocodigo.fluxocompra;

import com.github.marcoscoutozup.casadocodigo.fluxocompra.compra.Compra;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.compra.CompraDTO;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.cupom.CupomRepository;
import com.github.marcoscoutozup.casadocodigo.fluxocompra.pedido.PedidoDTO;
import com.github.marcoscoutozup.casadocodigo.pais.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired //1
    private CupomRepository cupomRepository;

    @PostMapping
    @Transactional                                  //2
    public ResponseEntity<String> realizarCompra(@RequestBody @Valid CompraDTO dto){

        //3
        Pais pais = entityManager.find(Pais.class, dto.getCliente().getPais());
        UUID idEstado = dto.getCliente().getEstado();

        //4
        if(!pais.verificarSeEstadoPertenceAoPais(idEstado)){
            return ResponseEntity.badRequest().body("O estado não está relacionado ao país");
        }

        //5
        PedidoDTO pedido = dto.getPedido();

        //6
        if(pedido.validarTotalDoPedido(pedido.getTotal(), entityManager)){
            return ResponseEntity.badRequest().body("O valor do total não é compatível com o valor do banco");
        }

        //7
        Compra compra = dto.toModel();

        //8
        if(dto.getCupom() != null && dto.getCupom().validarCupom(cupomRepository)){
            compra.setCupom(cupomRepository.findByCodigo(dto.getCupom().getCodigo()).get());
        }

        entityManager.persist(compra);

        return ResponseEntity.ok(compra.toString());
    }

}
