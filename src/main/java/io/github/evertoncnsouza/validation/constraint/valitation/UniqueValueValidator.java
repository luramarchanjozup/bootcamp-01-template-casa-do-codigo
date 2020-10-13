package io.github.evertoncnsouza.validation.constraint.valitation;

import io.github.evertoncnsouza.validation.constraint.valitation.UniqueValue;
import org.springframework.util.Assert;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object>{
//Constraint Validator recebe dois tipos parametrizados, a interface e o objeto.
//É necessário implementar os métodos;

    private String domainAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager manager;


    @Override
    public void initialize(UniqueValue params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    //1° método implementado. Inicializa os parâmetro declarados acima. Atributo de domínio e a classe;
    }

    //2° método implementado responsável por validar. É criado uma Query com Entitymanager, onde é pego
    // o atributo e a classe pertencida e comparados. Se forem iguais, uma mensagem de erro é lançada.
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from "+klass.getName()
                +" where "+domainAttribute+"=:value");
        query.setParameter("value", value);

        List<?> list = query.getResultList();
        Assert.state(list.size() <=1,"Foi encontrado mais de um "
            +klass+" com o atributo "+domainAttribute+" = "+value);

        return list.isEmpty();
    }
}
