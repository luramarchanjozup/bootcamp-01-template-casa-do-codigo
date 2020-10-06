package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.validation;

import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.domain.Autor;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.repositories.AutorRepository;
import br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.requests.NovoAutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailDuplicadoValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoAutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        if (errors.hasErrors()) return;

        NovoAutorRequest novoAutorRequest = (NovoAutorRequest) object;
        Optional<Autor> autorCadastrado = autorRepository.findByEmail(novoAutorRequest.getEmail());

        if (autorCadastrado.isPresent()){
            errors.rejectValue("email", null, "Já existe um autor cadastrado para o email: " + novoAutorRequest.getEmail());
        }
    }
}
