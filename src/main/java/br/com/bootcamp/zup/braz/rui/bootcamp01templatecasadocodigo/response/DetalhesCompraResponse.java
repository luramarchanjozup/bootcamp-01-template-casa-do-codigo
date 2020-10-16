package br.com.bootcamp.zup.braz.rui.bootcamp01templatecasadocodigo.response;

import javax.validation.constraints.NotBlank;

public class DetalhesCompraResponse {

    @NotBlank
    private String documento;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;



}
