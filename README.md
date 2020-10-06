# ZUP Bootcamp

### Pontos de Complexidade Intrínseca da API 

> @Limite(pci = +- 8)

1. Controllers

> AuthorController (pci = 5)

> CategoryController (pci = 4)

> CountryController (pci = 5)

> BookController (pci = 9)

> StateController (pci = 5)

> CouponController (pci = 9)

> ShopController (pci = 11)

2. Services

> CouponApplyService (pci = 6)

> AddToCartService (pci = 10)

3. Validation 

> Unique (pci = 2)

> UniqueValidator (pci = 8)

### Documentando a API

- Usei como referência o guia do Spotify 
- https://developer.spotify.com/documentation/web-api/reference

- MÉTODO          ENDPOINT            USO          RETORNA


- Compras        
- POST           /shop/finish      finalizar compra

- POST           /shop/user-data   dados do usuário
                                     que fará a compra

- PUT        /shop/{id}/{couponId}    aplica cupom

- GET           /shop/{id}          detalhes finais
                                      da compra

- Autores
- POST            /authors        criar autor     autor (nome)


- Livros
- GET             /books          buscar livros 

- GET             /books/{id}     buscar um livro

- POST            /books          criar livro


- Categorias
- POST            /categories     criar categorias


- Países
- POST            /countries      criar países


- Estados
- POST            /states         criar estados


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



