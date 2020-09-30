# ZUP Bootcamp

## Check List (partindo da teoria inicial - em desenvolvimento)

### Pontos de Complexidade Intrínseca da API 

1. Controllers

> AuthorController (PCI = 4)
> CategoryController (PCI = 4)
> CountryController (PCI = 4)
> BookController (PCI = 5)
> StateController (PCI = 5)
> CouponController (PCI = 9)

2. Models
3. Dtos
4. Forms
5. Repositories
6. Validations

### A prioridade máxima é funcionar

-> Alguns endpoints estão funcionando e validação de atributo único já funciona para o email do autor (por meio de um Bean Customizado).

-> Aqui vai o Swagger

### Proteger as bordas

-> Os métodos chamados nas classes controller estão recebendo os dados 
pela classe Form e retornando por meio das Dtos, ficando a Model distanciada das bordas do sistema.

### Controllers 100% coesos

Continua...