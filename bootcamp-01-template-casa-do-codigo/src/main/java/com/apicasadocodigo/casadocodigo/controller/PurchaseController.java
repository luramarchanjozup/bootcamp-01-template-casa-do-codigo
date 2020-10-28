package com.apicasadocodigo.casadocodigo.controller;

import com.apicasadocodigo.casadocodigo.model.purchase.Purchase;
import com.apicasadocodigo.casadocodigo.request.PurchaseRequest;
import com.apicasadocodigo.casadocodigo.response.PurchaseResponse;
import com.apicasadocodigo.casadocodigo.service.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private GenericDAO genericDAO;

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody @Valid PurchaseRequest request, UriComponentsBuilder builder){

        Long id = genericDAO.saveEntity(request.toModel(genericDAO)).getId();
        URI uri = builder.path("purchases/{id}").build(id);

        return ResponseEntity.ok(uri);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchase(@PathVariable Long id){
        PurchaseResponse response = new PurchaseResponse(genericDAO.findEntityDyId(Purchase.class, id));

        return ResponseEntity.ok(response);
    }

}
