package br.com.ecommerce.cdc.builder;

import br.com.ecommerce.cdc.domain.model.Autor;
import br.com.ecommerce.cdc.domain.model.Categoria;
import br.com.ecommerce.cdc.domain.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroBuilder {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numPagina;
    private String isbn;
    private LocalDate dataPublicacao;
    private Autor autor;
    private Categoria categoria;

    public LivroBuilder titulo(String titulo){
        this.titulo = titulo;
        return this;
    }

    public LivroBuilder resumo(String resumo){
        this.resumo = resumo;
        return this;
    }
    public LivroBuilder sumario(String sumario){
        this.sumario = sumario;
        return this;
    }
    public LivroBuilder preco(BigDecimal preco){
        this.preco = preco;
        return this;
    }
    public LivroBuilder numPagina(Integer numPagina){
        this.numPagina = numPagina;
        return this;
    }
    public LivroBuilder isbn(String isbn){
        this.isbn = isbn;
        return this;
    }
    public LivroBuilder dataPublicacao(LocalDate dataPublicacao){
        this.dataPublicacao = dataPublicacao;
        return this;
    }
    public LivroBuilder autor(Autor autor){
        this.autor = autor;
        return this;
    }
    public LivroBuilder categoria(Categoria categoria){
        this.categoria = categoria;
        return this;
    }


    public Livro criaLivro(){
        return new Livro(titulo,resumo,sumario,preco,numPagina,isbn,dataPublicacao,autor,categoria);
    }



}
