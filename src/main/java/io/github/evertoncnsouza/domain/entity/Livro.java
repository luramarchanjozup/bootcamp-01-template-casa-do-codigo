package io.github.evertoncnsouza.domain.entity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

//2 PCI's
@Entity
@Table (name = "Livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{campo.titulo.obrigatorio}")
    private String titulo;

    @NotBlank(message ="{campo.resumo.obrigatorio}")
    @Size(max = 500)
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull(message= "{campo.preco.obrigatorio}")
    @Min(20)
    private BigDecimal preco;

    @Min(100)
    @NotNull(message = "{numero.paginas.obrigatorio}")
    private int numeroPaginas;

    @NotBlank(message = "{informe.codigo.isbn}")
    private String isbn;

    @NotNull
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @ManyToOne
    @Valid
    private Autor autor;
    //PCI 1;

    @NotNull
    @ManyToOne
    @Valid
    private Categoria categoria;
    //PCI 2;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500)
            String resumo, @NotBlank String sumario, @NotNull @Min(20) BigDecimal preco,
                 @Min(100) int numeroPaginas,
                 @NotBlank String isbn, @NotNull @Future LocalDate dataPublicacao, @NotNull @Valid Autor autor,
                 @NotNull @Valid Categoria categoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
    }
//Todos os gets foram feitos para a classe DetalheSiteLivroResponse;
    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public LocalDate getDataPublicacao() {
        return this.dataPublicacao;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }
//Como isbn é formato livre e único, necessita de um equals e hashcode;
   @Override  //HashCode usa uma conta para definir um hashcode diferente, para cada objeto de código.
    public int hashCode() {
        final int prime = 31; //Numero primo..
        int result = 1; //...somado ao resultado 1.
        result = prime * result + ((isbn ==null) ? 0 : isbn.hashCode()); //Primo * resultado + se o codigo for igual
       // a null, põe zero, se nao pega o próprio hascode do codigo.
        return result; //Gera hashcode diferentes, para código diferentes;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) //Compara o this, com o objeto que está recebendo; Se for a mesa estância retorna true;
            return true;
        if (obj == null)//Se o objeto que está sendo passado for nulo, retorna falso;
            return false;
        if (getClass() != obj.getClass())  //Se as classes forem diferentes, retorna false;
            return false;
        Livro other = (Livro) obj;//Agora é feito o cast do obj pra livro
        if (isbn == null) { //...e compara o codigo. Se o codigo for igual a null...
            if (other.isbn != null) // e o codigo do outro for diferente de null, já é falso.
                return false;
        } else if (!isbn.equals(other.isbn)) //Se nao, se o codigo for igual a outro codigo, no caso diferente,
            return false;//... retorna false;
        return true;//... se não, retorna true. Significa que eles são iguais;
    }


}

