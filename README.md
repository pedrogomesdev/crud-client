<H1 align="center">Desafio CRUD de clientes</H1>
<p align="center">Resolução do DESAFIO CRUD de clientes - Bootcamp Java Spring Professional</p>

## Descrição do Projeto
<p> Entregar um projeto Spring Boot contendo um CRUD completo de web services REST para
acessar um recurso de clientes, contendo as cinco operações:
  
- Busca paginada de recursos
- Busca de recurso por id
- Inserir novo recurso
- Atualizar recurso
- Deletar recurso

O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados H2, deverá usar
Maven como gerenciador de dependência, e Java como linguagem. Um cliente possui nome, CPF, renda, data de nascimento, e quantidade de filhos. A especificação da
entidade Client é mostrada a seguir:</p>

### Diagrama de classe 
<div align="left">
<img src="https://github.com/acenelio/interfaces4-java/assets/117963842/603332a4-bf04-4cf3-8cee-203f04c0f336" width="200px" />
</div>

### Requisitos:
- [x] Busca por id retorna cliente existente
- [x] Busca por id retorna 404 para cliente inexistente
- [x] Busca paginada retorna listagem paginada corretamente
- [x] Inserção de cliente insere cliente com dados válidos
- [x] Inserção de cliente retorna 422 e mensagens customizadas com dados inválidos
- [x] Atualização de cliente atualiza cliente com dados válidos
- [x] Atualização de cliente retorna 404 para cliente inexistente
- [x] Atualização de cliente retorna 422 e mensagens customizadas com dados inválidos
- [x] Deleção de cliente deleta cliente existente
- [x] Deleção de cliente retorna 404 para cliente inexistente

### Tecnologias utilizadas
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Postman
- Bean Validation
- API REST
