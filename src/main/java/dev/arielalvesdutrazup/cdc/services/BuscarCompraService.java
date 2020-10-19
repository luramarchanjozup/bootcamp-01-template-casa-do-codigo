package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Compra;
import dev.arielalvesdutrazup.cdc.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class BuscarCompraService {

    @Autowired
    private CompraRepository compraRepository;

    public Compra buscaPeloId(Long id) {
        return compraRepository.findFetchById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Compra com id " + id + " não localizada!"));
    }
}
