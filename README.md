# ZUP Bootcamp

## Check List (partindo da teoria inicial - em desenvolvimento)

### Pontos de Complexidade Intrínseca da API 

> @Limite(PCI = 8)

1. Controllers

> AuthorController (PCI = 5)

> CategoryController (PCI = 4)

> CountryController (PCI = 5)

> BookController (PCI = 9)

> StateController (PCI = 5)

> CouponController (PCI = 9)

2. Services

> ShopServices (PCI = 11)

3. Validation 

> UniqueValidator (PCI = 8)

### A prioridade máxima é funcionar

- Swagger: localhost:8080/swagger-ui.html

- Visão geral das controllers

![](/readme-assets/api-geral.png)

- Endpoints

![](/readme-assets/endpoints-1.png)

![](/readme-assets/endpoints-2.png)


### Proteger as bordas

-> Os métodos chamados nas classes controller estão recebendo os dados 
pela classe Form e retornando por meio das Dtos, ficando as classes Models distanciadas das bordas do sistema.

