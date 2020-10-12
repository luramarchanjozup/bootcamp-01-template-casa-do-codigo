package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Cupom;
import dev.arielalvesdutrazup.cdc.repositories.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class CupomService {

    @Autowired
    private CupomRepository cupomRepository;

    @Transactional
    public Cupom cadastrar(Cupom cupomParaCadatrar) {
        try {
            buscaPeloCodigo(cupomParaCadatrar.getCodigo());
            throw new RuntimeException("Cupom duplicado!");
        } catch (EntityNotFoundException e) {
            return cupomRepository.save(cupomParaCadatrar);
        }
    }

    public Cupom buscaPeloCodigo(String codigo) {
        return cupomRepository.findByCodigo(codigo)
                .orElseThrow(() ->
                        new EntityNotFoundException("Cupom com cógido " + codigo + " não localizado!"));
    }
}
