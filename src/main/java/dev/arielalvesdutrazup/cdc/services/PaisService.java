package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Pais;
import dev.arielalvesdutrazup.cdc.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Transactional
    public Pais cadastrar(Pais paisParaCadastrar) {
        try {
            buscaPeloNome(paisParaCadastrar.getNome());
            throw new RuntimeException("Nome duplicado!");
        } catch (EntityNotFoundException e) {
            return paisRepository.save(paisParaCadastrar);
        }
    }

    public void buscaPeloNome(String nome) {
        paisRepository.findByNome(nome)
                .orElseThrow(() ->
                        new EntityNotFoundException("Pais com nome " + nome + " não localizado!"));
    }

    @Transactional
    public void removeTodos() {
        paisRepository.deleteAll();
    }
}
