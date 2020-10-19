package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CompraRequestDTO;
import dev.arielalvesdutrazup.cdc.entities.Compra;
import dev.arielalvesdutrazup.cdc.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


// Entities
// 1 Compra.java

// DTOs
// 2 CompraRequestDTO.java
// 3 CompraItemRequestDTO.java

// Services
// 4 ServiceManager.java
// 5 CupomService.java

// Repositories
// 6 CompraRepository.java

// Conditions
// 7 if (requestDTO.getCupomCodigo() != null)

@Service
public class FecharCompraService {

    @Autowired
    private GerenciadorDeServico gerenciadorDeServico;

    @Autowired
    private CompraRepository compraRepository;

    @Transactional
    public Compra fecharCompra(CompraRequestDTO requestDTO) {

        Compra compraParaCadastrar = requestDTO.paraEntidade(gerenciadorDeServico);

        if (requestDTO.getCupomCodigo() != null) {
            var cupomService = gerenciadorDeServico.instanciaDeCupomService();
            compraParaCadastrar.aplicaCupom(cupomService.buscaPeloCodigo(requestDTO.getCupomCodigo()));
        }

        return compraRepository.save(compraParaCadastrar);
    }
}
