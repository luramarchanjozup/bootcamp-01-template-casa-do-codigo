package com.guiferrini.CasaCodigo.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.guiferrini.CasaCodigo.repository.CuponRepository;

@Component
public class CuponValidoValidador implements Validator {

	//@PersistenceContext
	//EntityManager entityManager;
	
	@Autowired
	CuponRepository cuponRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return FluxoPagtoDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors()) {
			return;
		}

		FluxoPagtoDTO fluxoPagtoDTO = (FluxoPagtoDTO) target;
		
		Optional<String> idCupomInserido = fluxoPagtoDTO.getIdCupon();
		
        if (idCupomInserido.isPresent()){
            Cupon cupon = cuponRepository.getById(idCupomInserido.get());
        	//Cupon cupon = cuponRepository.getOne(idCupomInserido.get()); //Aqui ocorre o erro LazyInitializationException: could not initialize proxy - no Session
            System.out.println("Aqui Cupon: " + cupon);
            if (!cupon.cuponDataValida()){ 
                errors.rejectValue("idCupon", null, "Esta cupom está inválido.");
            }
        } 
        
        //Tentativa com Querry - Erro na querry - VALIDAR!!!
//		FluxoPagtoDTO fluxoPagtoDTO = (FluxoPagtoDTO) target;
// 
//		Optional<String> idCuponInserido = fluxoPagtoDTO.getIdCupon();
//		System.out.println("Aqui IdCUponInserido: " + idCuponInserido);
//		
//		if(idCuponInserido.isPresent()) {
//			TypedQuery<LocalDate> consulta = entityManager.createQuery(
//					//"Select validade " + //funciona, tras tds as datas, não filtar pelo ID
//					"Select id " +  
//					"From Cupon " +
//					"Where validade=validade",
//					LocalDate.class
//					);
//		System.out.println("Aqui consulta: " + consulta.getResultList());
//			if(LocalDate.now().compareTo((ChronoLocalDate) consulta) > 0) {
//				errors.rejectValue("id", null, "Esta cupom está inválido.");
//			}	
//		}
	}		
}
