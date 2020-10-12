package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Livro;
import dev.arielalvesdutrazup.cdc.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public Livro cadastrar(Livro livroParaCadastrar) {
        try {
            buscaPeloTitulo(livroParaCadastrar.getTitulo());
            throw new RuntimeException("Título duplicado!");
        } catch (EntityNotFoundException e) {
            return livroRepository.save(livroParaCadastrar);
        }
    }

    public Livro buscaPeloId(Long id) {
        return livroRepository.findById(id).get();
    }

    public Livro buscaPeloTitulo(String titulo) {
        return livroRepository.findByTitulo(titulo)
                .orElseThrow(() ->
                        new EntityNotFoundException("Livro com título " + titulo + " não localizado!"));
    }

    public List<Livro> buscaTodos() {
        return livroRepository.findAll();
    }

    @Transactional
    public void removeTodos() {
        livroRepository.deleteAll();
    }
}
