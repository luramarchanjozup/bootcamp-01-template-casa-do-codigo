package br.com.zup.casadocodigo.validator;

import br.com.zup.casadocodigo.domain.Country;
import br.com.zup.casadocodigo.domain.State;
import br.com.zup.casadocodigo.dto.BuyerDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class StateBelongsCountry implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return BuyerDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        BuyerDTO buyerDTO = (BuyerDTO) target;
        Country country = manager.find(Country.class, buyerDTO.getCountryId());
        State state = manager.find(State.class, buyerDTO.getStateId());

        if(!state.belongsCountry(country)) {
            errors.reject("stateId", null, "this state is not that of the selected country");
        }

    }

}
