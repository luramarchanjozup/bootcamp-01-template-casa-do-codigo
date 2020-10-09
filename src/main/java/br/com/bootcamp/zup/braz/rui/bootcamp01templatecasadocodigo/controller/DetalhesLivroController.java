package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.controller;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Livro;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.response.DetalhesLivroResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
@RequestMapping(value = "/detalheLivro")
public class DetalhesLivroController {

    @Autowired
    EntityManager entityManager;

    @GetMapping(value = "/{idLivro}")
    public ResponseEntity<?> buscarDetalheLivro(@PathVariable Integer idLivro){

        Livro livro = entityManager.find(Livro.class, idLivro);

        if (livro != null){
            return ResponseEntity.ok(new DetalhesLivroResponse(livro));
        }
        return ResponseEntity.notFound().build();


    }
}
