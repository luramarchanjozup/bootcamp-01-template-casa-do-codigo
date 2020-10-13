package io.github.evertoncnsouza.domain.entity;

import io.github.evertoncnsouza.domain.embedded.CupomAplicado;
import org.springframework.util.Assert;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.function.Function;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    private String cidade;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @ManyToOne //Uma compra tem um país. Um país, tem muitas compras;
    @NotNull
    private Pais pais;
    //PCI 1;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    @ManyToOne
    private Estado estado;
    //PCI 2;

   @OneToOne(mappedBy = "compra", cascade = CascadeType.PERSIST) //Salva o filho quando salva a classe mãe;
    private Pedido pedido;
   //PCI 3;

   @Embedded //Faz de um objeto um componente. Usada para embutir um tipo, em outra entidade.
    private CupomAplicado cupomAplicado;
   //PCI 4;


    @Deprecated
    public Compra() {
    }

    public Compra(@NotBlank @Email String email, @NotBlank String nome,
                  @NotBlank String sobrenome, String cidade, @NotBlank String documento,
                  @NotBlank String endereco, @NotBlank String complemento,
                  @NotNull Pais pais, @NotBlank String telefone,
                  @NotBlank String cep, Function<Compra, Pedido> funcaoCriacaoPedido) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cidade = cidade;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
        this.pedido = funcaoCriacaoPedido.apply(this);
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Pais getPais() {
        return pais;
    }

    public Optional<Estado> getEstado() {
        return Optional.ofNullable(estado);
    }


    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", pais=" + pais +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", estado=" + estado +
                ", pedido=" + pedido +
                ", cupomAplicado=" + cupomAplicado +
                '}';
    }

    public void setEstado(@NotNull @Valid Estado estado) {
        Assert.notNull(pais, "Nao associe estado com pais nulo");
        Assert.isTrue(estado.pertenceAPais(pais), "Este estado não é do país associado");
        this.estado = estado;
    }

    public void aplicaCupom(@Valid Cupom cupom) {
        Assert.notNull(cupom, "Para aplica um cupom, este não pode ser nulo");
        Assert.isNull(this.cupomAplicado, "Só é possível aplicar um cupom por compra");
        Assert.isTrue(cupom.valido(), "O cupom já não é mais válido de acordo com a data de validade");
        this.cupomAplicado = new CupomAplicado(cupom);
    }


    public Optional<CupomAplicado> getCupomAplicado(){
        return Optional.ofNullable(cupomAplicado);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public BigDecimal getValorDesconto(){
        if(this.cupomAplicado == null)
            return BigDecimal.ZERO;
        return this.pedido.getTotal()
                .multiply(this.cupomAplicado.getPercentualDescontoMomento())
                .divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
    }
}
