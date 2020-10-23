/*
 * Para ficar de Historico, exemplo futuro...
 * Parte retirada de AutorController
 * 
 * import org.springframework.web.bind.WebDataBinder;
 * import org.springframework.web.bind.annotation.InitBinder;
 *  import com.guiferrini.CasaCodigo.model.EmailDuplicadoValidador;
 * 
 * 	@Autowired
	private EmailDuplicadoValidador emailDuplicadoValidador;

	@InitBinder
	public void init(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(emailDuplicadoValidador);
	}
 * */

/*
 * Parte retirada de EmailDuplicado
package com.guiferrini.CasaCodigo.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.guiferrini.CasaCodigo.repository.AutorRepository;

@Component
public class EmailDuplicadoValidador implements Validator {
	//1
	@Autowired
	private AutorRepository autorRepo;
	//1
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDTO.class.isAssignableFrom(clazz); //a classe que eu aceito: qq q seja = ou filha de novo Autor
	}
	//1
	@Override
	public void validate(Object target, Errors errors) {
		//1
		//caso tenha erro não executa
		if(errors.hasErrors()) {
			return;
		}  
		//1
		//valida se email é duplicado
		AutorDTO autor = (AutorDTO) target; //cast
		//CategoriaDTO categoria = (CategoriaDTO) target;
		//1
		Optional<Autor> validando = autorRepo.findByEmail(autor.getEmail());
		//1
		if (validando.isPresent()) {
			errors.rejectValue("email", null,
				"Já existe um(a) outro(a) autor(a) com o mesmo email "
							+ autor.getEmail());
		}
	}
}
*/
