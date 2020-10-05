package br.com.zup.treinocasadocodigo.validators;

import br.com.zup.treinocasadocodigo.entities.Categoria;
import br.com.zup.treinocasadocodigo.entities.CategoriaNovoRequest;
import br.com.zup.treinocasadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

/**
 * Contagem de carga intrínseca da classe: 3
 */

@Component
public class CategoriaValidador implements Validator {

    @Autowired
    //1
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CategoriaNovoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        //1
        CategoriaNovoRequest novaCategoria = (CategoriaNovoRequest) target;

        Optional<Categoria> possivelCategoria = categoriaRepository
                .findByNome(novaCategoria.getNome());

        //1
        if (possivelCategoria.isPresent()) {
            errors.rejectValue("nome", "Categoria.Nome.Validacao",
                    "já cadastrado: " + novaCategoria.getNome());
        }
    }
}
