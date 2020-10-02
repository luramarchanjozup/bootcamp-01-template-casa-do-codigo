package dev.arielalvesdutrazup.cdc.unit.entities;

import dev.arielalvesdutrazup.cdc.entities.Compra;
import dev.arielalvesdutrazup.cdc.entities.CompraItem;
import dev.arielalvesdutrazup.cdc.factories.entities.AutorFactory;
import dev.arielalvesdutrazup.cdc.factories.entities.CategoriaFactory;
import dev.arielalvesdutrazup.cdc.factories.entities.LivroFactory;
import dev.arielalvesdutrazup.cdc.factories.entities.PaisFactory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class CompraTest {

    @Test
    public void construtorVazio_deveFuncionar() {
        new Compra();
    }

    @Test
    public void gettersESetters_devemFuncionar() {
        var id = 1L;
        var nome = "Usuario";
        var sobrenome = "Da Silva";
        var email = "email@exemplo.com";
        var documento = "303.756.200-52";
        var telefone = "(99) 99999-9999";
        var cep = "48680-970";
        var endereco = "Rua Xyz, 1010";
        var complemento = "Porta 401";
        var pais = PaisFactory.paraPersistir();
        var livro = LivroFactory.paraPersistir(
                AutorFactory.paraPersistir(),
                CategoriaFactory.paraPersistir());
        var total = livro.getPreco();
        var totalSemDesconto = livro.getPreco();
        var compraItem = new CompraItem()
                .setLivro(livro)
                .setQuantidade(1);
        var timestamp = OffsetDateTime.now();

        var compra = new Compra()
                .setId(id)
                .setNome(nome)
                .setSobrenome(sobrenome)
                .setEmail(email)
                .setDocumento(documento)
                .setTelefone(telefone)
                .setPais(pais)
                .setCep(cep)
                .setEndereco(endereco)
                .setComplemento(complemento)
                .setItens(new HashSet<>(Arrays.asList(compraItem)))
                .setTotal(total)
                .setTotalSemDesconto(totalSemDesconto)
                .setCadastradoEm(timestamp);

        assertThat(compra).isNotNull();
        assertThat(compra.getId()).isEqualTo(id);
        assertThat(compra.getNome()).isEqualTo(nome);
        assertThat(compra.getSobrenome()).isEqualTo(sobrenome);
        assertThat(compra.getEmail()).isEqualTo(email);
        assertThat(compra.getTotal()).isEqualTo(total);
        assertThat(compra.getTotalSemDesconto()).isEqualTo(totalSemDesconto);
        assertThat(compra.getPais()).isEqualTo(pais);
        assertThat(compra.getCep()).isEqualTo(cep);
        assertThat(compra.getEndereco()).isEqualTo(endereco);
        assertThat(compra.getComplemento()).isEqualTo(complemento);
        assertThat(compra.getDocumento()).isEqualTo(documento);
        assertThat(compra.getItens()).contains(compraItem);
    }
}
