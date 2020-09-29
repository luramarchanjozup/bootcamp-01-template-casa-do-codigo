package com.github.marcoscoutozup.casadocodigo.livro;

import com.github.marcoscoutozup.casadocodigo.cadastroautor.Autor;
import com.github.marcoscoutozup.casadocodigo.cadastrocategoria.Categoria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public Livro cadastraLivro(@RequestBody @Valid LivroDTO dto){
        Autor autor = entityManager.find(Autor.class, dto.getAutor());
        Categoria categoria = entityManager.find(Categoria.class, dto.getCategoria());
        Livro livro = dto.toModel();
        livro.setAutor(autor);
        livro.setCategoria(categoria);
        entityManager.persist(livro);
        return livro;
    }

}
