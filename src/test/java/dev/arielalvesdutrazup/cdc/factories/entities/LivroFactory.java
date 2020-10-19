package dev.arielalvesdutrazup.cdc.factories.entities;

import dev.arielalvesdutrazup.cdc.entities.Autor;
import dev.arielalvesdutrazup.cdc.entities.Categoria;
import dev.arielalvesdutrazup.cdc.entities.Livro;
import org.apache.tomcat.jni.Local;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Classe auxiliar para testes.
 */
public class LivroFactory {

    public static Livro paraPersistir(Autor autor, Categoria categoria) {
        return new Livro()
                .setTitulo("Crônicas de Gelo e Fogo: Os Ventos do Inverno")
                .setResumo("Os Ventos do Inverno terá conteúdos escritos por Martin em diversas épocas, não apenas a partir de 2011, quando ele terminou A Dança dos Dragões.")
                .setSumario("1. Inicio. 2 Meio. 3. Fim")
                .setAutor(autor)
                .setCategoria(categoria)
                .setIsbn("234567890987654")
                .setPreco(new BigDecimal("100.00"))
                .setNumeroDePaginas(945)
                .setDataPublicacao(LocalDate.parse("2300-02-01"));
    }
}
