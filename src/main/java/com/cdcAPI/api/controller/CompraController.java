package com.cdcAPI.api.controller;

import com.cdcAPI.api.model.Request.CompraRequest;
import com.cdcAPI.api.model.Response.CompraResponse;
import com.cdcAPI.model.Compra;

import com.cdcAPI.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> comprar(@Valid @RequestBody CompraRequest compraRequest) throws Exception {

        Compra compra = compraRequest.toModel(manager);

        if ((compra.getCliente().getDocumento().length()) != 11 && (compra.getCliente().getDocumento().length()) != 14) {
            throw new Exception("Compra não pode ser efetuada. Documento inválido");
        }

        List<Estado> estadosList = manager
                .createQuery("SELECT e from Estado e WHERE pais = :pais", Estado.class)
                .setParameter("pais", compra.getCliente().getPais())
                .getResultList();

        if (compra.getCliente().getPais() == null) {
            throw new Exception("Compra não pode ser efetuada. Pais não existe."); //se pais null
        }
        //se pais existe
        else if (estadosList.size() > 0) { //e lista de estados existe
            if (compra.getCliente().getEstado() == null) { //estado obrigatorio então
                throw new Exception("Campo 'estado' obrigatório."); // se estado null
            } else if (!(compra.getCliente().getEstado().getPais()).equals(compra.getCliente().getPais())) { //estado existe o idPais = pais
                throw new Exception("Compra não pode ser efetuada. Este estado não pertence ao país selecionado.");
            }
        } else if (compra.getCliente().getEstado() != null){ //se lista vazia, não pode estado
            throw new Exception("Compra não pode ser efetuada. Este país não possui estados.");
        }


        manager.persist(compra);

        String urlCreated = "/compras/" + compra.getId();

        return ResponseEntity.created(URI.create(urlCreated)).build();
    }

    @GetMapping("/{compraId}")
    @Transactional
    public ResponseEntity<CompraResponse> detalhesCompra(@PathVariable Long compraId) throws Exception {
        Compra compra = manager.find(Compra.class, compraId);
        if (compra == null) throw new Exception("Compra não existe.");

        CompraResponse compraResponse = new CompraResponse(compra);

        return ResponseEntity.ok(compraResponse);
    }

}
