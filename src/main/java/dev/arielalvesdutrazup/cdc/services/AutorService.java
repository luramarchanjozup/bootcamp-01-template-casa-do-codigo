package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Autor;
import dev.arielalvesdutrazup.cdc.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Transactional
    public Autor cadastrar(Autor autorParaCadastrar) {
        try {
            buscaPeloEmail(autorParaCadastrar.getEmail());
            throw new EntityExistsException("E-mail duplicado!");
        } catch (EntityNotFoundException e) {
            return autorRepository.save(autorParaCadastrar);
        }
    }

    public Autor buscaPeloId(Long autorId) {
        Assert.notNull(autorId, "Id é obrigatório para a consulta!");
        return autorRepository.findById(autorId).
                orElseThrow(() ->
                        new EntityNotFoundException("Autor com id " + autorId + " não localizado!"));
    }

    public Autor buscaPeloEmail(String email) {
        return autorRepository.findByEmail(email).
                orElseThrow(() ->
                        new EntityNotFoundException("Autor com email " + email + " não localizado"));
    }

    @Transactional
    public void removeTodos() {
        autorRepository.deleteAll();
    }
}
