package com.cdcAPI.api.model;

import com.cdcAPI.model.Autor;
import com.cdcAPI.model.Categoria;
import com.cdcAPI.model.Livro;
import com.cdcAPI.validator.EntradaUnica;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @EntradaUnica(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotBlank
    @Min(20)
    private BigDecimal preco;

    @NotBlank
    @Min(100)
    private int n_paginas;

    @NotBlank
    @EntradaUnica(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotBlank
    @Future
    @JsonFormat(pattern = "dd/mm/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    //rever
    @NotBlank
    @ManyToOne
    @Valid
    private AutorRequest autor;

    //rever
    @NotBlank
    @ManyToOne
    @Valid
    private CategoriaRequest categoria;

    public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
                 @NotBlank String sumario, @NotBlank @Min(20) BigDecimal preco,
                 @NotBlank @Min(100) int n_paginas, @NotBlank String isbn , @NotBlank LocalDate dataPublicacao,
                 @NotBlank AutorRequest autorId, @NotBlank @ManyToOne @Valid CategoriaRequest categoriaId) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.n_paginas = n_paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autorId;//rever
        this.categoria = categoriaId;//rever
        //Todo  Usar builder
    }

    //get e set

}
