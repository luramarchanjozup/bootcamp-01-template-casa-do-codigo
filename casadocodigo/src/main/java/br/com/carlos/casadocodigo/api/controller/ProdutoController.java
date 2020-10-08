package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.ResponseLivroDto;
import br.com.carlos.casadocodigo.domain.repository.LivroRepository;
import br.com.carlos.casadocodigo.domain.service.CadastrarLivrosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private LivroRepository repository;
    @Autowired
    private CadastrarLivrosService livrosService;

    @GetMapping(value="produto/{id}")
    private ResponseEntity<ResponseLivroDto> detalhe(@PathVariable("id") Long id){
    var livro = repository.findById(id);

    if(livro.isEmpty()){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(mapper.map(livrosService.builder(livro.get()), ResponseLivroDto.class));
    }

}
