package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Autor;
import dev.arielalvesdutrazup.cdc.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            throw new RuntimeException("E-mail duplicado!");
        } catch (EntityNotFoundException e) {
            return autorRepository.save(autorParaCadastrar);
        }
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
