package br.com.carlos.casadocodigo.api.handler;

import br.com.carlos.casadocodigo.api.dto.request.RequestCompraDto;
import br.com.carlos.casadocodigo.domain.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CupomValidoValidator implements Validator {
    @Autowired
    private CupomRepository cupomRepository;


    @Override
    public boolean supports(Class<?> clazz) {
        return RequestCompraDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return ;
        }

        RequestCompraDto request = (RequestCompraDto) target;
        String possivelCodigo = request.getCodigoCupom();
        if(possivelCodigo!=null) {
            var cupom = cupomRepository.getByCodigo(possivelCodigo);
            if(cupom.isPresent()) {
                if (!cupom.get().valido()) {
                    errors.rejectValue("codigoCupom", null, "Este cupom não é mais válido");
                }
            }
            else errors.rejectValue("codigoCupom", null, "Este cupom não existe");
        }
    }
}
