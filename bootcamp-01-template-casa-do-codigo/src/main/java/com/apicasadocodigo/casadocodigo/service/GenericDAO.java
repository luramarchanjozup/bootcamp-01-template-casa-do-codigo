package com.apicasadocodigo.casadocodigo.service;

import com.apicasadocodigo.casadocodigo.exception.BusinessViolationFoundException;
import com.apicasadocodigo.casadocodigo.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/*Essa classe é para evitar de ficar repetindo o código de salvar e busar uma entidade em cada controller.
* Porque em ambos os casos são usados metadados de classes pelo EntityManager e o merge sempre retorna o Tipo T que ele salva
* então ao usar o método saveEntity eu tenho a garantia de Type Safe no retorno. No caso eu sei que vai sempre
* retornar um objeto do tipo que eu salvei e como no controller eu preciso disso para capturar o id para informar
* onde encontrar o recurso, faço esse retorno porque para cada Tipo T salvo eu define a propriedade getId() para poder
* dizer no retorno da requisição onde encontrar o recurso criado.*/
@Repository
public class GenericDAO {

    @PersistenceContext
    private EntityManager manager;

            //1
    public <T> T findEntityDyId(Class<T> entity, Long id){

        T entityFinded = (T) manager.find(entity, id);

        return Optional.ofNullable(entityFinded)
                                    //2
                .orElseThrow(() -> new EntityNotFoundException(entity, id.toString()));
    }

    @Transactional
    public <T> T saveEntity(T entity){

        return manager.merge(entity);
    }

    /*Faz o mesmo que o método acima mas caso uma dependência de classe do negócio não seja
    * encontrada implica em uma má requisição no json*/
    public <T> T findEntityDepedenceDyId(Class<T> entity, Long id){

        T entityFinded = (T) manager.find(entity, id);

        return Optional.ofNullable(entityFinded)
                                    //3
                .orElseThrow(() -> new BusinessViolationFoundException(entity, id.toString()));

    }

    public boolean findEntityByAtribute(Class<?> entity, String columnName, String fieldThatIsMustBeUniqueValue){

        String sql = "SELECT 1 FROM %s WHERE %s=:value";
        String sqlFormated = String.format(sql, entity.getSimpleName(), columnName);
        Query query = manager.createNativeQuery(sqlFormated);
        query.setParameter("value", fieldThatIsMustBeUniqueValue);

        return query.getResultList().isEmpty();
    }

    public List<?> findAllFrom(Class<?> tClass){
        Query query = manager.createNativeQuery("SELECT * FROM " + tClass.getSimpleName() + ";", tClass);

        List<?> list = query.getResultList();

        return list;
    }

}
