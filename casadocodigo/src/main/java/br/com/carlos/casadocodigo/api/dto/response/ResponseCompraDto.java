package br.com.carlos.casadocodigo.api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseCompraDto {
    private String nome;
    private String endereco;
    private String complemento;
    private String cidade;
    private String mensagem = "Compra realizada com sucesso. Mais informações acesse: /detalhescompras";

}
