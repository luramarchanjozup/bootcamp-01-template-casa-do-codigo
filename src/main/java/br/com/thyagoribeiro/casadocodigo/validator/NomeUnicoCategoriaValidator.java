package br.com.thyagoribeiro.casadocodigo.validator;

import br.com.thyagoribeiro.casadocodigo.domain.Categoria;
import br.com.thyagoribeiro.casadocodigo.repository.CategoriaRepository;
import br.com.thyagoribeiro.casadocodigo.rest.contract.NovaCategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeUnicoCategoriaValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public NomeUnicoCategoriaValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return NovaCategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        NovaCategoriaRequest novaCategoriaRequest = (NovaCategoriaRequest) target;
        Optional<Categoria> findResult = categoriaRepository.findByNome(novaCategoriaRequest.getNome());

        if(!findResult.isEmpty())
            errors.rejectValue("nome", null, "ja existe uma categoria com esse nome");

    }
}
