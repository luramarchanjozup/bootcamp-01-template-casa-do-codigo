package com.github.marcoscoutozup.casadocodigo.livro;

import com.github.marcoscoutozup.casadocodigo.autor.Autor;
import com.github.marcoscoutozup.casadocodigo.categoria.Categoria;
import org.springframework.http.ResponseEntity;
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
    @Transactional                                      //1
    public String cadastrarLivro(@RequestBody @Valid LivroDTO dto){
        //2
        Autor autor = entityManager.find(Autor.class, dto.getAutor());
        //3
        Categoria categoria = entityManager.find(Categoria.class, dto.getCategoria());

        //4
        Livro livro = dto.toModel();
        livro.setAutor(autor);
        livro.setCategoria(categoria);

        entityManager.persist(livro);
        return livro.toString();
    }

    @GetMapping //5
    public ResponseEntity<List<LivroResponse>> listarLivros(){
        Query query = entityManager.createQuery("select l from Livro l", Livro.class);
        List<LivroResponse> response = LivroResponse.gerarListaDeRespostaDeLivros(query.getResultList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> procurarLivroPorId(@PathVariable UUID id){
        Livro livro = entityManager.find(Livro.class, id);
        //6
        if(livro == null){
            return ResponseEntity.notFound().build();
        }

        LivroResponse response = new LivroResponse(livro);
        return ResponseEntity.ok(response);
    }

}
