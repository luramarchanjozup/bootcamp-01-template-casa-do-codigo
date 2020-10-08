package br.com.carlos.casadocodigo.api.dto;

import br.com.carlos.casadocodigo.domain.entity.Livro;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class ResponseLivroDto {
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int paginas;
    private String isbn;
    private LocalDate publicao;
    private ResponseAutorId autor;
    private ResponseCategoriaId categoria;


    public static ResponseLivroDto converter(Livro l){
        var livro = new ResponseLivroDto();
        livro.setTitulo(l.getTitulo());
        livro.setResumo(l.getResumo());
        livro.setSumario(l.getSumario());
        livro.setPreco(l.getPreco());
        livro.setPaginas(l.getPaginas());
        livro.setIsbn(l.getIsbn());
        livro.setPublicao(l.getPublicao());
        livro.setAutor(ResponseAutorId.converter(l.getAutor()));
        livro.setCategoria(ResponseCategoriaId.converter(l.getCategoria()));

        return livro;
    }

}
