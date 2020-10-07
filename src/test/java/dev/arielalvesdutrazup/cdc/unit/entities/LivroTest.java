package dev.arielalvesdutrazup.cdc.unit.entities;

import dev.arielalvesdutrazup.cdc.entities.Autor;
import dev.arielalvesdutrazup.cdc.entities.Categoria;
import dev.arielalvesdutrazup.cdc.entities.Livro;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LivroTest {

    @Test
    public void construtorVazio_deveFuncionar() {
        new Livro();
    }

    @Test
    public void gettersESetters_devemFuncionar() throws ParseException {
        var id = 1L;
        var titulo = "O Programador Pragmático";
        var resumo = "O Programador Pragmático ilustra as melhores práticas e as principais armadilhas do desenvolvimento de software.";
        var sumario = "1. Inicio 1.1. O programador";
        var preco = new BigDecimal("100.00");
        var numeroDePaginas = 201;
        var isbn = "9782123456803";
        var categoria = new Categoria().setNome("TI");
        var davidThomas = new Autor().setNome("David Thomas");
        var dataPublicacao = LocalDate.parse("2300-02-01");
        var criadoEm = OffsetDateTime.now();

        var livro = new Livro()
                .setId(id)
                .setTitulo(titulo)
                .setResumo(resumo)
                .setSumario(sumario)
                .setPreco(preco)
                .setNumeroDePaginas(numeroDePaginas)
                .setIsbn(isbn)
                .setCategoria(categoria)
                .setAutor(davidThomas)
                .setDataPublicacao(dataPublicacao)
                .setCadastradoEm(criadoEm);

        assertThat(livro).isNotNull();
        assertThat(livro.getTitulo()).isEqualTo(titulo);
        assertThat(livro.getResumo()).isEqualTo(resumo);
        assertThat(livro.getSumario()).isEqualTo(sumario);
        assertThat(livro.getPreco()).isEqualTo(preco);
        assertThat(livro.getNumeroDePaginas()).isEqualTo(numeroDePaginas);
        assertThat(livro.getIsbn()).isEqualTo(isbn);
        assertThat(livro.getCategoria()).isEqualTo(categoria);
        assertThat(livro.getAutor()).isEqualTo(davidThomas);;
        assertThat(livro.getDataPublicacao()).isEqualTo(dataPublicacao);
        assertThat(livro.getCadastradoEm()).isEqualTo(criadoEm);
    }

    @Test
    public void cadastradoEm_deveSerGeradoAoCriarOObjeto() {
        assertThat(new Livro().getCadastradoEm()).isNotNull();
    }
}
