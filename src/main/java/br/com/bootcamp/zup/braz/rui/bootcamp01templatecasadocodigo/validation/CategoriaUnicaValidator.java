package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Categoria;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories.CategoriaRepository;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovaCategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CategoriaUnicaValidator implements Validator {

    @Autowired
    CategoriaRepository categoriaRepository; //1

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if (errors.hasErrors()) return; //1

        NovaCategoriaRequest novaCategoriaRequest = (NovaCategoriaRequest) object; //1
        Optional<Categoria> categoriaCadastrada = categoriaRepository.findByNome(novaCategoriaRequest.getNome()); //1

        if (categoriaCadastrada.isPresent()){ //1
            errors.rejectValue("nome", null, "da categoria já cadastrada: " + novaCategoriaRequest.getNome());
        }
    }
}
