package br.com.zup.casadocodigo.dto;

import br.com.zup.casadocodigo.annotations.UniqueValue;
import br.com.zup.casadocodigo.domain.Country;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CountryDTO {

    @NotBlank(message = "is required")
    @UniqueValue(domainClass = Country.class, fieldName = "name", message = "already registered")
    private String name;

    @Deprecated
    public CountryDTO(){

    }

    public CountryDTO(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
