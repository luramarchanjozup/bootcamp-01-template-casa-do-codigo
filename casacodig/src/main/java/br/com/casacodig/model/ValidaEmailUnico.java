package br.com.casacodig.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.casacodig.dto.AutorDTO;
import br.com.casacodig.repositories.AutorRepository;

@Component
public class ValidaEmailUnico {
	
	@Autowired
	private AutorRepository autorRepository;
	
	public String validarEmail(AutorDTO autordto) {
		
		String resultado = null;
		Autor autorEncontrado = autorRepository.findByEmail(autordto.getEmail());

		if (autorEncontrado != null) {
			resultado = ("Já existe um autor cadastrado com o email informado: " + autordto.getEmail());
		}
		
		return resultado;
	}
	
	public String validarRepetido(Class<?> classe) {
		return null;
	}
	

}
