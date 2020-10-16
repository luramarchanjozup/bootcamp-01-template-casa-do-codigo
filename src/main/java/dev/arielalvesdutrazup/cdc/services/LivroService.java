package dev.arielalvesdutrazup.cdc.services;

import dev.arielalvesdutrazup.cdc.entities.Autor;
import dev.arielalvesdutrazup.cdc.entities.Categoria;
import dev.arielalvesdutrazup.cdc.entities.Livro;
import dev.arielalvesdutrazup.cdc.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

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

        try {
            var livroBuscado = buscaPeloTituloOuIsbn(livroParaCadastrar.getTitulo(), livroParaCadastrar.getIsbn());
            if (livroBuscado.getIsbn().equals(livroParaCadastrar.getIsbn()))
                throw  new EntityExistsException("Isbn duplicado!");
            throw new EntityExistsException("Título duplicado!");
        } catch (EntityNotFoundException e) {
            livroParaCadastrar.setAutor(autor);
            livroParaCadastrar.setCategoria(categoria);

            return livroRepository.save(livroParaCadastrar);
        }
    }

    public Livro buscaPeloId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Livro com id " + id + " não localizado!"));
    }

    public Livro buscaPeloTituloOuIsbn(String titulo, String isbn) {
        return livroRepository.findByTituloOrIsbn(titulo, isbn)
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
