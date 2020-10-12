package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Compra;
import dev.arielalvesdutrazup.cdc.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Transactional
    public Compra fecharCompra(Compra compraParaCadastrar) {
        return compraRepository.save(compraParaCadastrar);
    }
}
