package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Autor;
import dev.arielalvesdutrazup.cdc.entities.Categoria;
import dev.arielalvesdutrazup.cdc.entities.Livro;
import dev.arielalvesdutrazup.cdc.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

// Entities
// 1 Autor.java
// 2 Categoria.java
// 3 Livro.java

// Repositories
// 4 LivroRepository.java

// Function as parameter
// 5 livroRepsitory.findById(id).orElseThrow(()

// Services
// 6 AutorService.java
// 7 CategoriaService.java

@Service
public class LivroService {

    @Autowired
    private AutorService autorService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    public Livro cadastrar(Long autorId, Long categoriaId, Livro livroParaCadastrar) {
        Autor autor = autorService.buscaPeloId(autorId);
        Categoria categoria = categoriaService.buscaPeloId(categoriaId);

        Livro.verificaSeJaExisteUmLivro(livroRepository, livroParaCadastrar);

        livroParaCadastrar.setAutor(autor);
        livroParaCadastrar.setCategoria(categoria);

        return livroRepository.save(livroParaCadastrar);
    }

    public Livro buscaPeloId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Livro com id " + id + " não localizado!"));
    }

    public List<Livro> buscaTodos() {
        return livroRepository.findAll();
    }

    @Transactional
    public void removeTodos() {
        livroRepository.deleteAll();
    }
}
