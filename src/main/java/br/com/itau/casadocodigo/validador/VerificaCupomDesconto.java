package br.com.itau.casadocodigo.validador;

import br.com.itau.casadocodigo.cadastrocliente.model.ClienteRequest;
import br.com.itau.casadocodigo.cadastrocliente.repository.CupomRepository;
import br.com.itau.casadocodigo.cadastrocupom.model.Cupom;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class VerificaCupomDesconto implements Validator {

    private final CupomRepository cupomRepository;

    public VerificaCupomDesconto(CupomRepository cupomRepository) {
        this.cupomRepository = cupomRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClienteRequest clienteRequest = (ClienteRequest) target;

        if (clienteRequest.getCodigoDesconto().isEmpty()) {
            return;
        }

        Optional<Cupom> cupom = cupomRepository.findByCodigo(clienteRequest.getCodigoDesconto());

        if (cupom.isEmpty()) {
            errors.rejectValue("codigoDesconto", null, "(" +
                    clienteRequest.getCodigoDesconto() + ") não existe.");
        }

        if (cupom.isPresent()) {
            if (!cupom.get().ehValido()) {
                errors.rejectValue("codigoDesconto", null, "(" +
                        clienteRequest.getCodigoDesconto() + ") expirado.");
            }
        }
    }
}
