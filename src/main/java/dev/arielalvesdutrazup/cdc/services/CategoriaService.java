package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Categoria;
import dev.arielalvesdutrazup.cdc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria cadastrar(Categoria categoriaParaCadastrar) {
        try {
            buscaPeloNome(categoriaParaCadastrar.getNome());
            throw new RuntimeException("Nome duplicado!");
        } catch (EntityNotFoundException e) {
            return categoriaRepository.save(categoriaParaCadastrar);
        }
    }

    public Categoria buscaPeloNome(String nome) {
        return categoriaRepository.findByNome(nome)
                .orElseThrow(() ->
                        new EntityNotFoundException("Categoria com nome " + nome + " não localizada!"));
    }

    @Transactional
    public void removeTodos() {
        categoriaRepository.deleteAll();
    }
}
