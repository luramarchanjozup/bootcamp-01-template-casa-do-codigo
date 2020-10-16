package com.cdcAPI.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(0)
    private BigDecimal total;

    @NotNull
    @Min(0)
    private BigDecimal totalDesconto;

    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    @ManyToMany
    private List<Livro> livros;


    @Deprecated
    public Compra() {

    }

    public Compra(Cliente cliente, List<Livro> livros, BigDecimal total, BigDecimal totalDesconto) {
        this.cliente = cliente;
        this.livros = livros;
        this.total = total;
        this.totalDesconto = totalDesconto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalDesconto() {
        return totalDesconto;
    }

    public void setTotalDesconto(BigDecimal totalDesconto) {
        this.totalDesconto = totalDesconto;
    }
}
