package br.com.treino.casadocodigo.validations;

import br.com.treino.casadocodigo.model.Categoria;
import br.com.treino.casadocodigo.model.NovaCategoriaRequest;
import br.com.treino.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeCategoriaDuplicado implements Validator {

    @Autowired
    CategoriaRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaRequest.class.isAssignableFrom(clazz) ;
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors())
            return;

        NovaCategoriaRequest request = (NovaCategoriaRequest) target;

        Optional<Categoria> categoriaNome = repository.findByNome(request.getNome());

        if (categoriaNome.isPresent()){
            errors.rejectValue("nome", null, "Já existe uma categoria com " +
                    "esse mesmo nome: " + request.getNome());
        }

    }
}
