package dev.arielalvesdutrazup.cdc.it.services;

import dev.arielalvesdutrazup.cdc.entities.Autor;
import dev.arielalvesdutrazup.cdc.entities.Categoria;
import dev.arielalvesdutrazup.cdc.factories.entities.AutorFactory;
import dev.arielalvesdutrazup.cdc.factories.entities.CategoriaFactory;
import dev.arielalvesdutrazup.cdc.factories.entities.LivroFactory;
import dev.arielalvesdutrazup.cdc.repositories.LivroRepository;
import dev.arielalvesdutrazup.cdc.services.AutorService;
import dev.arielalvesdutrazup.cdc.services.CategoriaService;
import dev.arielalvesdutrazup.cdc.services.LivroService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("test")
public class LivroServiceIT {

    @Autowired
    private AutorService autorService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private LivroService livroService;

    @Autowired
    private LivroRepository livroRepository;

    private Autor autor;

    private Categoria categoria;

    @BeforeEach
    public void setUp() {
        autor = autorService.cadastrar(AutorFactory.paraPersistir());
        categoria = categoriaService.cadastrar(CategoriaFactory.paraPersistir());
    }

    @AfterEach
    public void tearDown() {
        livroRepository.deleteAll();
        autorService.removeTodos();
        categoriaService.removeTodos();
    }

    @Test
    public void cadastrar_deveFuncionar() {
        var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);

        var livroCadatrado = livroService.cadastrar(autor.getId(), categoria.getId(), livroParaCadastrar);

        assertThat(livroCadatrado).isNotNull();
        assertThat(livroCadatrado.getId()).isNotNull();

        var livroBuscado = livroRepository.findById(livroCadatrado.getId()).get();

        assertThat(livroBuscado).isNotNull();
        assertThat(livroBuscado.getId()).isEqualTo(livroCadatrado.getId());
        assertThat(livroBuscado.getTitulo()).isEqualTo(livroParaCadastrar.getTitulo());
        assertThat(livroBuscado.getResumo()).isEqualTo(livroParaCadastrar.getResumo());
        assertThat(livroBuscado.getSumario()).isEqualTo(livroParaCadastrar.getSumario());
        assertThat(livroBuscado.getPreco()).isEqualTo(livroParaCadastrar.getPreco());
        assertThat(livroBuscado.getAutor()).isEqualTo(livroParaCadastrar.getAutor());
        assertThat(livroBuscado.getCategoria()).isEqualTo(livroParaCadastrar.getCategoria());
        assertThat(livroBuscado.getIsbn()).isEqualTo(livroParaCadastrar.getIsbn());
        assertThat(livroBuscado.getNumeroDePaginas()).isEqualTo(livroParaCadastrar.getNumeroDePaginas());
        assertThat(livroBuscado.getCadastradoEm()).isNotNull();
    }

    @Test
    public void cadastrar_semTitulo_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);
            livroParaCadastrar.setTitulo(null);

            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Título é obrigatório!', propertyPath=titulo");
        }
    }

    @Test
    public void cadastrar_comTituloDuplicado_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);

            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            livroParaCadastrar.setIsbn("1371292112321");
            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).contains("Título duplicado!");
        }
    }

    @Test
    public void cadastrar_semResumo_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);
            livroParaCadastrar.setResumo(null);

            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Resumo é obrigatório!', propertyPath=resumo");
        }
    }

    @Test
    public void cadastrar_comResumoComMaisDe500Caracteres_deveLancarException() {
        try {
            var resumoGrande = "In a free hour, when our power of choice is untrammesdsdsdsalled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures.";
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);
            livroParaCadastrar.setResumo(resumoGrande);

            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Tamanho máximo é de 500 caracteres!', propertyPath=resumo");
        }
    }

    @Test
    public void cadastrar_semPreco_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);
            livroParaCadastrar.setPreco(null);

            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Preço é obrigatório!', propertyPath=preco");
        }
    }

    @Test
    public void cadastrar_comPrecoAbaixoDe20_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);
            livroParaCadastrar.setPreco(new BigDecimal("10.00"));

            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Preço mínimo é de 20!', propertyPath=preco");
        }
    }

    @Test
    public void cadastrar_semNumeroDePaginas_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);
            livroParaCadastrar.setNumeroDePaginas(null);

            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Número de páginas é obrigatório!', propertyPath=numeroDePaginas");
        }
    }

    @Test
    public void cadastrar_comNumeroDePaginasAbaixoDe100_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);
            livroParaCadastrar.setNumeroDePaginas(80);

            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);

            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Número mínimo de páginas é 100!', propertyPath=numeroDePaginas");
        }
    }

    @Test
    public void cadastrar_semIsbn_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);
            livroParaCadastrar.setIsbn(null);

            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='ISBN é obrigatório!', propertyPath=isbn");
        }
    }

    @Test
    public void cadastrar_comIsbnDuplicado_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);

            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            livroParaCadastrar.setTitulo("Outro título");
            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (Exception e) {
            assertThat(e.getMessage()).contains("Isbn duplicado!");
        }
    }

    @Test
    public void cadastrar_semDataPublicao_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);
            livroParaCadastrar.setDataPublicacao(null);

            livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (ConstraintViolationException e) {
            assertThat(e.getMessage()).contains("interpolatedMessage='Data de publicação é obrigatória!', propertyPath=dataPublicacao");
        }
    }

    @Test
    public void cadastrar_semAutor_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);

            livroService.cadastrar(null, categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).contains("Id é obrigatório para a consulta!");
        }
    }

    @Test
    public void cadastrar_comAutorNaoCadastrado_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);

            livroService.cadastrar(20000L, categoria.getId(),livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (EntityNotFoundException e) {
            assertThat(e.getMessage()).contains("Autor com id 20000 não localizado!");
        }
    }

    @Test
    public void cadastrar_semCategoria_deveLancarException() {
        try {
            var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);


            livroService.cadastrar(autor.getId(), null,livroParaCadastrar);
            fail("Esperando uma exceção!");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).contains("Id é obrigatório para a consulta!");
        }
    }

    @Test
    public void buscaTodos_deveFuncionar() {
        var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);
        var livroCadastrado = livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);

        var livroLista = livroService.buscaTodos();

        assertThat(livroLista).isNotNull();
        assertThat(livroLista).contains(livroCadastrado);
    }

    @Test
    public void buscaPorId_deveFuncionar() {
        var livroParaCadastrar = LivroFactory.paraPersistir(autor, categoria);
        var livroCadastrado = livroService.cadastrar(autor.getId(), categoria.getId(),livroParaCadastrar);

        var livroBuscado = livroService.buscaPeloId(livroCadastrado.getId());

        assertThat(livroBuscado).isNotNull();
        assertThat(livroBuscado.getId()).isEqualTo(livroCadastrado.getId());
        assertThat(livroBuscado.getTitulo()).isEqualTo(livroCadastrado.getTitulo());
        assertThat(livroBuscado.getDataPublicacao()).isEqualTo(livroCadastrado.getDataPublicacao());
        assertThat(livroBuscado.getPreco()).isEqualTo(livroCadastrado.getPreco());
        assertThat(livroBuscado.getIsbn()).isEqualTo(livroCadastrado.getIsbn());
        assertThat(livroBuscado.getResumo()).isEqualTo(livroCadastrado.getResumo());
        assertThat(livroBuscado.getSumario()).isEqualTo(livroCadastrado.getSumario());
        assertThat(livroBuscado.getNumeroDePaginas()).isEqualTo(livroCadastrado.getNumeroDePaginas());
    }
}
