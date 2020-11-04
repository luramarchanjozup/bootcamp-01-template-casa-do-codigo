package bootcamp.challenges.casadocodigo.dtos;

import bootcamp.challenges.casadocodigo.entities.Category;
import bootcamp.challenges.casadocodigo.validators.EntityValueExists;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
// Total Intrinsic Load Points: 1
public class CategoryDto {
    @NotBlank
    @EntityValueExists(entityClass = Category.class, entityFieldName = "name", message = "já existe e não pode ser duplicado")
    private final String name;

    public CategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Category toModel(){ // 1 - Category
        return new Category(name);
    }

    public CategoryDto fromModel(Long id, EntityManager entityManager){
        Category category = entityManager.find(Category.class, id);
        return new CategoryDto(category.getName());
    }
}
