package br.com.carlos.casadocodigo.service;

import br.com.carlos.casadocodigo.domain.entity.Autor;
import br.com.carlos.casadocodigo.domain.repository.AutorRepository;
import br.com.carlos.casadocodigo.domain.service.CadastroAutorService;
import br.com.carlos.casadocodigo.domain.service.impl.CadastroAutorServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class CadastroAutorServiceTest {

    private static final String NOME = "Carlos" ;
    private static final String EMAIL = "Carlos@junior.com" ;
    private static final String DESCRICAO = "simples descrição";

    @MockBean
    protected AutorRepository autorRepository;
    protected CadastroAutorService sut;
    protected Autor autor;


    @Before
    public void setUp() {
        sut = new CadastroAutorServiceImpl(autorRepository);

        autor = new Autor();
        autor.setNome(NOME);
        autor.setEmail(EMAIL);
        autor.setDescricao(DESCRICAO);

    }
    @Test
    public void deve_cadastrar_autor_no_repository() {
        sut.salvar(autor);
        verify(autorRepository).save(autor);
    }
}
