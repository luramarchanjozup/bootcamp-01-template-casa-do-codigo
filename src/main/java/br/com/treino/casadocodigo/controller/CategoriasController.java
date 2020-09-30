package br.com.treino.casadocodigo.controller;

import br.com.treino.casadocodigo.model.Categoria;
import br.com.treino.casadocodigo.model.NovaCategoriaRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class CategoriasController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/categorias")
    @Transactional
    public String novaCategoria(@RequestBody @Valid NovaCategoriaRequest request){

        Categoria categoria = new Categoria(request.getNome());
        //categoriaRepository.save(categoria);
        entityManager.persist(categoria);
        return categoria.toString();
    }

}
