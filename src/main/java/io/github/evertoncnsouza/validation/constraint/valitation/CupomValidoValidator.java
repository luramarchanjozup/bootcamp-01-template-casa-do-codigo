package io.github.evertoncnsouza.validation.constraint.valitation;

import io.github.evertoncnsouza.rest.dto.CompraRequest;
import io.github.evertoncnsouza.domain.entity.Cupom;
import io.github.evertoncnsouza.domain.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.Optional;

@Component //Para ser detectado no momento da compilação;
public class CupomValidoValidator implements Validator {
//Validator é uma interface do Spring que trás métodos de validação. É necessáros implementá-los;

    @Autowired //Injeção de dependência;
    private CupomRepository cupomRepository;
    //PCI 1;

    @Override
    public boolean supports(Class<?> clazz) {
        return CompraRequest.class.isAssignableFrom(clazz);
/*Este método diz se a classe específica é suportada pelo validador. Ao validar um objeto
o próprio objeto não é passado para "supports", o que é passado é a classe do objeto.*/
//PCI 2;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
//If, PCI 3;
            return;
        }

        CompraRequest request = (CompraRequest) target;
        Optional<String> possivelCodigo = request.getCodigoCupom();
//If, PCI 4;
        if (possivelCodigo.isPresent()) {
            Cupom cupom = cupomRepository.findByCodigo(possivelCodigo.get());
            if (!cupom.valido()) {
                errors.rejectValue("codigoCupom", null, "Este cupom não é mais válido");
            }
        }  /*Este é o segundo método implementado. Se tem erros, ele retorna. Ele trabalha junto ao
repository injetado, buscando o código com um get, após isso, ele verifica se o código está válido. Se está
diferente de válido( inválido) retorna uma mensagem "Este cupom não é mais válido*/
    }
}
