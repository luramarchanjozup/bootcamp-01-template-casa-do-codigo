# ZUP Bootcamp

## Check List (partindo da teoria inicial - em desenvolvimento)

### Pontos de Complexidade Intrínseca da API 

> @Limite(PCI = +- 8)

1. Controllers

> AuthorController (PCI = 5)

> CategoryController (PCI = 4)

> CountryController (PCI = 5)

> BookController (PCI = 9)

> StateController (PCI = 5)

> CouponController (PCI = 9)

> ShopController (PCI = 11)

2. Services

> CouponApplyService (PCI = 6)

> AddToCartService (PCI = 10)

3. Validation 

> Unique (PCI = 2)

> UniqueValidator (PCI = 8)

### Etapas do desafio

- cadastrar novo autor
- email do autor único
- cadastro de uma-categoria
- criação de um validador genérico
- criar um novo livro
- exibir lista de livros
- página de detalhes do livro
- cadastrar país e estados
- começar fluxo de pagamento (partes 1 e 2)
- cadastrar cupom de desconto
- alterar cupom de desconto
- aplicar cupom de desconto
- detalhes da compra

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

