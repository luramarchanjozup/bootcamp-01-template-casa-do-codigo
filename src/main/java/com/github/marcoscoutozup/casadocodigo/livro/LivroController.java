package com.github.marcoscoutozup.casadocodigo.livro;

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
        Livro livro = dto.toModel(entityManager);
        entityManager.persist(livro);
        return livro.toString();
    }

    @GetMapping //3
    public ResponseEntity listarLivros(){
        Query query = entityManager.createQuery("select l from Livro l", Livro.class);
        List<LivroResponse> response = LivroResponse.gerarListaDeRespostaDeLivros(query.getResultList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity procurarLivroPorId(@PathVariable UUID id){
        Livro livro = entityManager.find(Livro.class, id);

        //4
        if(livro == null){
            return ResponseEntity.status(404).body("Livro não encontrado");
        }

        LivroResponse response = new LivroResponse(livro);
        return ResponseEntity.ok(response);
    }

}
