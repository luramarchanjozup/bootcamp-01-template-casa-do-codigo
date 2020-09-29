package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Categoria;
import br.com.treino.casadocodigo.model.NovaCategoriaRequest;
import br.com.treino.casadocodigo.repository.CategoriaRepository;
import br.com.treino.casadocodigo.validations.NomeCategoriaDuplicado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CategoriasController {

    @Autowired
    CategoriaRepository categoriaRepository;
    //@Autowired
    //NomeCategoriaDuplicado nomeCategoriaDuplicado;

    /*@InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(nomeCategoriaDuplicado);
    }*/

    @PostMapping(value = "/categorias")
    public String novaCategoria(@RequestBody @Valid NovaCategoriaRequest request){

        Categoria categoria = new Categoria(request.getNome());
        categoriaRepository.save(categoria);

        return categoria.toString();
    }

}
