package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Compra;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.ItemCompra;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Pedido;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories.PedidoRepository;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.response.DetalhesCompraResponse;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.response.ItemCompraResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/detalheCompra")
public class DetalhesDaCompraController {

    @PersistenceContext
    EntityManager entityManager;

    //1
    DetalhesCompraResponse detalhesCompraResponse;

    @GetMapping(value = "/{idCompra}")
    public ResponseEntity<?> detalheCompra(@NotNull @PathVariable Integer idCompra){
        //1
        Compra compra = entityManager.find(Compra.class, idCompra);

        if (compra != null){
                //1
            List<ItemCompraResponse> listaItens = compra.buscarItens(compra.getPedido().getId(), entityManager);
                                                                    //1
            return ResponseEntity.status(HttpStatus.OK).body(new DetalhesCompraResponse(compra, listaItens));
        }

        return ResponseEntity.notFound().build();
    }


}
