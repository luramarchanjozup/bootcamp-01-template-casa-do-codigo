package dev.arielalvesdutrazup.cdc.unit.entities;

import dev.arielalvesdutrazup.cdc.entities.Compra;
import dev.arielalvesdutrazup.cdc.entities.CompraItem;
import dev.arielalvesdutrazup.cdc.factories.entities.AutorFactory;
import dev.arielalvesdutrazup.cdc.factories.entities.CategoriaFactory;
import dev.arielalvesdutrazup.cdc.factories.entities.LivroFactory;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class CompraItemTest {

    @Test
    public void construtorVazio_deveFuncionar() {
        new CompraItem();
    }

    @Test
    public void gettersAndSetter_devemFuncionar() {
        var id = 1L;
        var autor = AutorFactory.paraPersistir();
        var categoria = CategoriaFactory.paraPersistir();
        var livro = LivroFactory.paraPersistir(autor, categoria);
        var quantidade = 3;
        var timestamp = OffsetDateTime.now();
        var compra = new Compra().setId(1L);

        var compraItem = new CompraItem()
                .setId(id)
                .setLivro(livro)
                .setQuantidade(quantidade)
                .setCadastradoEm(timestamp)
                .setCompra(compra);

        assertThat(compraItem).isNotNull();
        assertThat(compraItem.getId()).isEqualTo(id);
        assertThat(compraItem.getLivro()).isEqualTo(livro);
        assertThat(compraItem.getQuantidade()).isEqualTo(quantidade);
        assertThat(compraItem.getCadastradoEm()).isEqualTo(timestamp);
        assertThat(compraItem.getCompra()).isEqualTo(compra);
    }
}
