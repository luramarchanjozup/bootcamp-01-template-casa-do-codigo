package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Cupom;
import dev.arielalvesdutrazup.cdc.repositories.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

// 1 Cupom.java
// 2 CupomRepository.java

// 3 if (existePeloCodigo &&
// 4 if (existeCupom) throw new EntityExistsException("Cupom duplicado!");

// 5 cupomRepository.findById(id).orElseThrow(() ->
// 6 cupomRepository.findByCodigo(id).orElseThrow(() ->
@Service
public class CupomService {

    @Autowired
    private CupomRepository cupomRepository;

    @Transactional
    public Cupom alterar(Long id, Cupom cupomParametro) {
        Cupom cupomExistente = buscaPeloId(id);
        var existeCupomComEsseCodigo = existePeloCodigo(cupomParametro.getCodigo());

        if (existeCupomComEsseCodigo
                && cupomExistente.naoTemMesmoCodigo(cupomParametro.getCodigo())) {
            throw new EntityExistsException("Já existe outro cupom com este código!");
        }

        cupomExistente.setCodigo(cupomParametro.getCodigo());
        cupomExistente.setPercentualDeDesconto(cupomParametro.getPercentualDeDesconto());
        cupomExistente.setValidade(cupomParametro.getValidade());

        return cupomExistente;
    }

    @Transactional
    public Cupom cadastrar(Cupom cupomParaCadatrar) {

        var existeCupom = existePeloCodigo(cupomParaCadatrar.getCodigo());

        if (existeCupom) throw new EntityExistsException("Cupom duplicado!");

        return cupomRepository.save(cupomParaCadatrar);
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

    public boolean existePeloCodigo(String codigo) {
        return cupomRepository.existsByCodigo(codigo);
    }

    @Transactional
    public void removeTodos() {
        cupomRepository.deleteAll();
    }
}
