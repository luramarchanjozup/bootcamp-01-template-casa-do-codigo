package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Pais;
import dev.arielalvesdutrazup.cdc.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

// 1 PaisRepository.java
// 2 Pais.java
// 3 try { buscaPeloNome(paisParaCadastrar
// 4 catch (EntityNotFoundException e) { return paisRepository.save
// 5 paisRepository.findById(paisId).orElseThrow(()
// 6 paisRepository.findByNome(nome).orElseThrow(()
@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Transactional
    public Pais cadastrar(Pais paisParaCadastrar) {
        try {
            buscaPeloNome(paisParaCadastrar.getNome());
            throw new EntityExistsException("Nome duplicado!");
        } catch (EntityNotFoundException e) {
            return paisRepository.save(paisParaCadastrar);
        }
    }

    public Pais buscaPeloId(Long paisId) {
        return paisRepository.findById(paisId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Pais com id " + paisId + " não localizado!"));
    }

    public Pais buscaPeloNome(String nome) {
        return paisRepository.findByNome(nome)
                .orElseThrow(() ->
                        new EntityNotFoundException("Pais com nome " + nome + " não localizado!"));
    }

    @Transactional
    public void removeTodos() {
        paisRepository.deleteAll();
    }
}
