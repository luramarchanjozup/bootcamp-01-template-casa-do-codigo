package br.com.itau.casadocodigo.validador;

import br.com.itau.casadocodigo.cadastrocliente.model.ClienteRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

@Component
public class VerificaPrecoDaCompra implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClienteRequest clienteRequest = (ClienteRequest) target;
//1
        BigDecimal valorTotalCalculado = new BigDecimal(0);
//1
        for (int posicaoDoLivro = 0; posicaoDoLivro < clienteRequest.getCompraRequest().quantidadeTotalDeLivros(); posicaoDoLivro++) {
            valorTotalCalculado = valorTotalCalculado.add(clienteRequest.precoDoLivro(posicaoDoLivro, entityManager));
        }
//1
        if (!clienteRequest.getCompraRequest().valorTotalEhValido(valorTotalCalculado)) {
            errors.rejectValue("compraRequest", null, "não corresponde ao preço total dos livros.");
        }
    }
}
