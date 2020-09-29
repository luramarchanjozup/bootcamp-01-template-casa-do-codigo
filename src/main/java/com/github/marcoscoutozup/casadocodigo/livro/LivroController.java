package com.github.marcoscoutozup.casadocodigo.livro;

import com.github.marcoscoutozup.casadocodigo.autor.Autor;
import com.github.marcoscoutozup.casadocodigo.categoria.Categoria;
import com.github.marcoscoutozup.casadocodigo.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional //1                                     //2
    public Livro cadastrarLivro(@RequestBody @Valid LivroDTO dto){
        //3
        Autor autor = entityManager.find(Autor.class, dto.getAutor());
        //4
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

    @GetMapping("/{id}")
    public Livro procurarLivroPorId(@PathVariable UUID id){
        Livro livro = entityManager.find(Livro.class, id);
        //5
        if(livro == null){
            //6
            throw new NotFoundException("Livro não encontrado com id: " + id);
        }
        return livro;
    }

}
