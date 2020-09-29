package com.github.marcoscoutozup.casadocodigo.livro;

import com.github.marcoscoutozup.casadocodigo.cadastroautor.Autor;
import com.github.marcoscoutozup.casadocodigo.cadastrocategoria.Categoria;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public Livro cadastrarLivro(@RequestBody @Valid LivroDTO dto){
        Autor autor = entityManager.find(Autor.class, dto.getAutor());
        Categoria categoria = entityManager.find(Categoria.class, dto.getCategoria());

        Livro livro = dto.toModel();
        livro.setAutor(autor);
        livro.setCategoria(categoria);

        entityManager.persist(livro);
        return livro;
    }

    @GetMapping
    public List<Livro> listarLivros(){
        Query query = entityManager.createQuery("select l from Livro l", Livro.class);
        List<Livro> livros = query.getResultList();
        return livros;
    }

}
