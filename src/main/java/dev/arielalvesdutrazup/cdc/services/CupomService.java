package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Cupom;
import dev.arielalvesdutrazup.cdc.repositories.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class CupomService {

    @Autowired
    private CupomRepository cupomRepository;

    @Transactional
    public Cupom alterar(Long id, Cupom cupomParametro) {
        Cupom cupom = buscaPeloId(id);

        try {
            buscaPeloCodigo(cupomParametro.getCodigo());
            throw new EntityExistsException("Já existe um cupom com este código!");
        } catch (EntityNotFoundException e) {
            cupom.setCodigo(cupomParametro.getCodigo());
            cupom.setPercentualDeDesconto(cupomParametro.getPercentualDeDesconto());
            cupom.setValidade(cupomParametro.getValidade());
            return cupom;
        }
    }

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

    private Cupom buscaPeloId(Long id) {
        return cupomRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Cupom com id " + id + " não localizado!"));
    }


    @Transactional
    public void removeTodos() {
        cupomRepository.deleteAll();
    }


}
