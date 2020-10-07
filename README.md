# ZUP Bootcamp

### Pontos de Complexidade Intrínseca da API 

> @Limite(pci = +- 8)


1. Controllers


> AuthorController (pci = 4)

> CategoryController (pci = 4)

> CountryController (pci = 4)

> BookController (pci = 6)

> StateController (pci = 4)

> CouponController (pci = 7)

> ShopController (pci = 8)


2. Services


> CouponApplyService (pci = 6)


3. Validation 

> Unique (pci = 2)

> UniqueValidator (pci = 8)


### Documentando a API

- Usei como referência o guia do Spotify 

- https://developer.spotify.com/documentation/web-api/reference

- Também é possível interagir com a documentação da api gerada por meio do Swagger: localhost:8080/swagger-ui.html


- MÉTODO   #########    ENDPOINT     #########       USO      #########    RETORNA


- Compras        
    - POST           /shop/finish       #########    finalizar compra
    - POST           /shop/user-data    #########  dados do usuário que fará a compra
    - PUT        /shop/{id}/{couponId}  ######### aplica cupom detalhes finais da compra
    - GET           /shop/{id}          #########                                     

- Autores
    - POST            /authors      #########     criar autor  #########   autor (nome)


- Livros
    - GET             /books        #########   buscar livros 
    - GET             /books/{id}   #########  buscar um livro
    - POST            /books        #########  criar livro


- Categorias
    - POST            /categories  #########   criar categorias


- Países
    - POST            /countries   #########   criar países


- Estados
    - POST            /states      #########   criar estados



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










