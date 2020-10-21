package br.com.itau.casadocodigo.validador;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/*
  Classe que representa o validador. Implementa o ConstraintValidator que
  necessita de dois atributos: 1º deve ser uma anotação (AtribitoUnico) e
  o 2º deve ser o tipo de atributo que está esperando (String)
*/
public class AtributoUnicoValidator implements ConstraintValidator<AtributoUnico, String> {

    private String atributoDeDominio;
    private Class<?> classeDeDominio;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(AtributoUnico constraintAnnotation) {
//        Recebendo dos parâmetros da anotação
        atributoDeDominio = constraintAnnotation.nomeDoAtributo();
        classeDeDominio = constraintAnnotation.classeDeDominio();
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {
//        Query em comum para as duas classes de domínio
        Query query = manager.createQuery("select 1 from " + classeDeDominio.getName() + " where "+ atributoDeDominio +"=:value");

//        Atribuindo valor ao parâmetro value da Query
        query.setParameter("value", valor);

//        É devolvido uma lista com o resultado obtido
        List<?> list = query.getResultList();

//        Verifica se a lista está vazia. Se false, não é válido para criar um novo registro e retorna a mensagem
//        padrão da anotação. Se true, insere um novo registro no banco.
        return list.isEmpty();
    }
}