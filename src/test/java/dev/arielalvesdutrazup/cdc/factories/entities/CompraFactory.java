package dev.arielalvesdutrazup.cdc.factories.entities;

import dev.arielalvesdutrazup.cdc.controllers.dtos.CompraItemRequestDTO;
import dev.arielalvesdutrazup.cdc.controllers.dtos.CompraRequestDTO;
import dev.arielalvesdutrazup.cdc.entities.Compra;
import dev.arielalvesdutrazup.cdc.entities.CompraItem;
import dev.arielalvesdutrazup.cdc.entities.Livro;
import dev.arielalvesdutrazup.cdc.entities.Pais;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Classe auxiliar para testes.
 */
public class CompraFactory {

    public static Compra paraPersistir(Livro livro, Pais pais) {

        var cpfFake = "30375620052";
        var compraItem = new CompraItem()
                .setQuantidade(2)
                .setLivro(livro);

        return new Compra()
                .setNome("Geralt")
                .setSobrenome("De Rivia")
                .setEmail("exemplo@exemplo.com")
                .setTelefone("(99) 99999-9999")
                .setCep("24342300")
                .setCidade("Canoas")
                .setDocumento(cpfFake)
                .setEndereco("Rua Jornalista José de Mattos, 173")
                .setComplemento("Porta 508")
                .setItens(new HashSet<>(Arrays.asList(compraItem)))
                .setPais(pais)
                .setTotal(compraItem.getTotalCompraItem())
                .setTotalSemDesconto(compraItem.getTotalCompraItem());
    }

    public static CompraRequestDTO paraFecharCompra(Livro livro, Pais pais) {
        var compra = paraPersistir(livro, pais);

        return new CompraRequestDTO()
                .setNome(compra.getNome())
                .setSobrenome(compra.getSobrenome())
                .setEmail(compra.getEmail())
                .setTelefone(compra.getTelefone())
                .setCep(compra.getCep())
                .setCidade(compra.getCidade())
                .setDocumento(compra.getDocumento())
                .setEndereco(compra.getEndereco())
                .setComplemento(compra.getComplemento())
                .setItens(CompraItemRequestDTO.paraDTO(compra.getItens()))
                .setPaisId(pais.getId())
                .setTotal(compra.getTotalDosItens());

    }
}
