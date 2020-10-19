package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Categoria;
import dev.arielalvesdutrazup.cdc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

// 1 Categoria.java
// 2 CategoriaRepository.java

// 3 try { buscaPeloNome(categoriaParaCadastrar.getNome()); ...
// 4 catch (EntityNotFoundException e) { return categoriaRepository.save ...

// 5 categoriaRepository.findById(categoriaId).orElseThrow(() ->

// 6 categoriaRepository.findByNome(nome).orElseThrow(() ->
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria cadastrar(Categoria categoriaParaCadastrar) {
        try {
            buscaPeloNome(categoriaParaCadastrar.getNome());
            throw new EntityExistsException("Nome duplicado!");
        } catch (EntityNotFoundException e) {
            return categoriaRepository.save(categoriaParaCadastrar);
        }
    }

    public Categoria buscaPeloId(Long categoriaId) {
        Assert.notNull(categoriaId, "Id é obrigatório para a consulta!");
        return categoriaRepository.findById(categoriaId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Categoria com id " + categoriaId + " não localizada!"));
    }

    public Categoria buscaPeloNome(String nome) {
        Assert.notNull(nome, "Nome é obrigatório para a consulta!");
        return categoriaRepository.findByNome(nome)
                .orElseThrow(() ->
                        new EntityNotFoundException("Categoria com nome " + nome + " não localizada!"));
    }

    @Transactional
    public void removeTodos() {
        categoriaRepository.deleteAll();
    }
}
