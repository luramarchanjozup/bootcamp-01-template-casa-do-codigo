package com.cdcAPI.api.model.Request;

import com.cdcAPI.model.Autor;
import com.cdcAPI.model.Categoria;
import com.cdcAPI.model.Livro;
import com.cdcAPI.validator.EntradaUnica;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

//Complexidade = 4
//EntradaUnica, Autor, Categoria, Livro,

public class LivroRequest {

    @NotBlank
    @EntradaUnica(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(100)
    private int n_paginas;

    @NotBlank
    @EntradaUnica(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    private Long autorId;

    @NotNull
    private Long categoriaId;

    public LivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
                 @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco,
                 @NotNull @Min(100) int n_paginas, @NotBlank String isbn , @NotNull LocalDate dataPublicacao,
                 @NotNull Long autorId, @NotNull Long categoriaId) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.n_paginas = n_paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autorId = autorId;
        this.categoriaId = categoriaId;
        //Todo  Usar builder
    }

    //Usar Entity mananger para puxar id's e popular objetos (autor e categoria)
    //2 livro
    public Livro toModel(EntityManager manager) throws Exception {

        //3 autor
        Autor autor = manager.find(Autor.class, autorId);
        //4 categoria
        Categoria categoria = manager.find(Categoria.class, categoriaId);

        return new Livro(titulo, resumo, sumario, preco, n_paginas, isbn,
                dataPublicacao, autor, categoria);
    }

    //get e set

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getN_paginas() {
        return n_paginas;
    }

    public void setN_paginas(int n_paginas) {
        this.n_paginas = n_paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
