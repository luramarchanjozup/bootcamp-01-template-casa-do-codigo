package dev.arielalvesdutrazup.cdc.entities;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigo;
    private OffsetDateTime cadastradoEm = OffsetDateTime.now();
    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Estado> estados = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Pais setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pais setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCodigo() {
        return codigo;
    }

    public Pais setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public OffsetDateTime getCadastradoEm() {
        return cadastradoEm;
    }

    public Pais setCadastradoEm(OffsetDateTime cadastradoEm) {
        this.cadastradoEm = cadastradoEm;
        return this;
    }

    public Set<Estado> getEstados() {
        return estados;
    }

    public Pais setEstados(Set<Estado> estados) {
        this.estados = estados;
        return this;
    }
}
