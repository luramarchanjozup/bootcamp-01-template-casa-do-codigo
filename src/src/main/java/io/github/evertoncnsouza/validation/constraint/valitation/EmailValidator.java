package io.github.evertoncnsouza.validation.constraint.valitation;

import io.github.evertoncnsouza.domain.entity.Autor;
import io.github.evertoncnsouza.domain.repository.Autors;
import io.github.evertoncnsouza.rest.dto.AutorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.Optional;

//4 PCI's;

@Component //Para ser detectada no momento da compilação;
public class EmailValidator implements Validator {
//Validator é uma interface do Spring que trás metódos de validação. É necessário implementá-los;

   @Autowired //Injeção de depêndencia;
    private Autors autors;
//PCI 1;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
/*Este método diz se a classe específica é suportada pelo validador. Ao validar um objeto
o próprio objeto não é passado para "supports", o que é passado é a classe do objeto.*/
//PCI 2;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
//If, PCI 3;
        }
        AutorRequest request = (AutorRequest) target;
        Optional<Autor> possivelAutor = autors.findByEmail(request.getEmail());

//If, PCI 4;
        if (possivelAutor.isPresent()) {
            errors.rejectValue("email", null,
                    "Já existe um(a) outro(a) autor(a) com o email cadastrado "
                            + request.getEmail());
/*Este é o segundo método implementado. Se tem erros, ele retorna. Ele trabalha junto ao
repository injetado, buscando o email, após isso, ele verifica se o Autor está presente. Se está
presente, devolve uma mensagem que concatena com o email duplicado.*/
        }
    }
}

