package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Livro;
import br.com.treino.casadocodigo.repository.LivroRepository;
import br.com.treino.casadocodigo.request.DetalheLivroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/livros")
public class LivroListaController {

    @Autowired
    private LivroRepository livroRepository; //1

    @GetMapping
    public ResponseEntity<Iterable<Livro>> listarTodosLivros(){

        Iterable<Livro> livros = livroRepository.findAll(); //2

        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DetalheLivroRequest> buscarLivroPorId(@PathVariable("id") long id){

        Optional<Livro> optionalLivro = livroRepository.findById(id);

        if (optionalLivro.isPresent()){ //3
            DetalheLivroRequest detalheLivroRequest =
                    new DetalheLivroRequest(optionalLivro.get()); //4
            return new ResponseEntity<>(detalheLivroRequest, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }


}
