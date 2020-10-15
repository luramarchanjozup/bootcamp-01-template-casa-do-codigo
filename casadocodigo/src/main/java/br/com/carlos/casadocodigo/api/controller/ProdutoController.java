package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.response.ResponseLivroDto;
import br.com.carlos.casadocodigo.domain.entity.Livro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class ProdutoController {
    @Autowired
    private ModelMapper mapper;
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @GetMapping(value="produtos/{id}") //1
    private ResponseEntity<ResponseLivroDto> detalhe(@PathVariable("id") Long id){
    Livro livro = manager.find(Livro.class, id);

    if(livro == null){
        return ResponseEntity.notFound().build();
    }
                                                         //1
    return ResponseEntity.ok(mapper.map(ResponseLivroDto.builder(livro, manager), ResponseLivroDto.class));
    }

}
