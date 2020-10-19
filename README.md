# Desafio - Casa do código

Desafio da Casa do Código do Bootcamp da Zup Innovation.

Projeto implementado com TDD.

O projeto está atendendo aos pontos do CDD.

## Rotas

### Autor

#### Cadastrar autor

| URL  | Tipo |  Descrição |
| ---- | ---- |---- | 
|/autores | POST | Cadastrar autor

**Corpo da requisição**:

```json
{
    "nome": "George R. R. Martin",
    "email": "email@email.com",
    "descricao": "Descrição do autor aqui"
}
```

### Categoria

#### Cadastrar categoria

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/categorias | POST | Cadastrar categoria de livros

**Corpo da requisição**:

```json
{
    "nome": "Fantasia"
}
```

### Livro

#### Cadastrar Livro

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/livros | POST | Cadastrar livro

**Corpo da requisição**:

```json
{
    "titulo": "Nome do Livro",
    "resumo": "Resumo do Livro",
    "sumario": "1. Inicio. 2. Meio. 3. Fim.",
    "preco": 120.90,
    "dataPublicacao": "2031-01-02",
    "isbn": "81283901500211",
    "numeroDePaginas": 311,
    "categoriaId": 1,
    "autorId": 1,
}
```

#### Buscar livros

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/livros | GET | Buscar livros

#### Buscar livro por id

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/livros/{id} | GET | Buscar livro por ID

### País

#### Cadastrar país

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/paises | POST | Cadastrar país

**Corpo da requisição**:

```json
{
    "nome": "Brasil",
    "codigo": "BR"
}
```

### Estado

#### Cadastrar estado

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/paises/{id}/estados | POST | Cadastrar estado

**Corpo da requisição**:

```json
{
    "nome": "Rio Grande do Sul",
    "codigo": "RS",
    "paisId": 1

}
```

### Cupom

#### Cadastrar cupom

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/cupons | POST | Cadastrar cupom

**Corpo da requisição**:

```json
{
    "codigo": "ZUP10",
    "percentualDeDesconto": 10,
    "validade": "2043-01-01 10:00:00"
}
```

#### Alterar cupom

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/cupons/{id} | PUT | Alterar cupom

**Corpo da requisição**:

```json
{
    "codigo": "ZUP15",
    "percentualDeDesconto": 15,
    "validade": "2044-01-01 10:00:00"
}
```

### Compra


#### Fechar compra


| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/compras | POST | Fechar Compra


**Corpo da requisição**:

```json
{
    "nome": "Nome",
    "sobrenome": "Sobrenome",
    "email": "email@email.com",
    "telefone": "51 99999-9999",
    "endereco": "Rua Jornalista José de Mattos, 173",
    "documento": "30375620052",
    "complemento": "Porta 508",
    "cep": "24342300",
    "cidade": "Canoas",
    "estadoId": 1,
    "paisId": 1,
    "cupomCodigo": "ZUP10",
    "itens": [
        {
            "quantidade": 2,
            "livroId": 1
        }
    ],
    "total": 200.00
}
```

#### Buscar compra

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/compras/{id} | GET | Buscar compra pelo ID
