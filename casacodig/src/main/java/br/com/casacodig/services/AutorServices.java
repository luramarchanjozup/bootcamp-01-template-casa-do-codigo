package br.com.casacodig.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.casacodig.dto.AutorDTO;
import br.com.casacodig.error.EmailRepetidoException;
import br.com.casacodig.model.Autor;
import br.com.casacodig.model.ValidaEmailUnico;
import br.com.casacodig.repositories.AutorRepository;

//Contagem de Pontos - TOTAL:3
//1 - AutorRepository
//1 - AutorDTO
//1 - Autor

@Service
public class AutorServices {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private ValidaEmailUnico validaEmailUnico;
	
	public Autor salvar(AutorDTO autordto) {

		Autor autor = autordto.toModel();
		return autorRepository.save(autor);
	}
	
	public void validarEmail(AutorDTO autordto) throws EmailRepetidoException{
		String resposta = validaEmailUnico.validarEmail(autordto);
		if(resposta != null) throw new EmailRepetidoException(resposta);
	}

}
