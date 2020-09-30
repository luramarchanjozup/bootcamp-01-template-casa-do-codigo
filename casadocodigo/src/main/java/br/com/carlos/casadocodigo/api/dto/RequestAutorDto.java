package br.com.carlos.casadocodigo.api.dto;

import br.com.carlos.casadocodigo.domain.entity.Autor;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.mapper.Mapper;


@Getter
@Setter
public class RequestAutorDto {

    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
    private String descricao;

}
