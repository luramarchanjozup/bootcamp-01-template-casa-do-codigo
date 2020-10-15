package br.com.carlos.casadocodigo.api.controller;

import br.com.carlos.casadocodigo.api.dto.request.RequestCategoriaDto;
import br.com.carlos.casadocodigo.api.dto.response.ResponseCategoriaDto;
import br.com.carlos.casadocodigo.domain.entity.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CadastrarCategoriaController {
    @Autowired
    private ModelMapper mapper;
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
                //1                                                 //1
    public ResponseCategoriaDto adicionar(@Valid @RequestBody RequestCategoriaDto request){
                                                      //1
        var categoria = mapper.map(request, Categoria.class);
        manager.persist(categoria);
        return mapper.map(categoria,ResponseCategoriaDto.class);
    }
}
