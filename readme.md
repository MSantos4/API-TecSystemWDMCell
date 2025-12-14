# TecSystemWDMCell _ Backend

Backend do projeto TecSystemWDMCell, desenvolvido como Projeto Integrador do curso de Desenvolvimento de Sistemas do senac

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

## 🚀 Tecnologias utilizadas
- Java 17+
- Spring Boot
- Maven

### 📋 Requisitos

Para rodar é preciso:
1. Ter o Java instalado, recomendo a versão 17+
2. MySQL instalado e configurado no projeto
3. Modificar application.yml para poder conectar ao mysql local configurado (url, username e password)
3. Schema criado no banco de dados com o nome do banco descrito no application.yml (nome: tecsystem)

##  Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/MSantos4/API-TecSystemWDMCell
   ```

2. Abra o projeto na IDE desejada, como o netbeans ou intellij.
3. Execute o projeto para ter o backend rodando.
4. Execute o script sql disponível para preencher com dados iniciais (login)
5. Siga os passos do frontend para poder realizar login e utilizar o projeto: [TecsystemWDMCell Frontend](colocar link front end)

## Endpoints

###  /clientes
1. POST - criar novo cliente
2. PUT /{id} - atualizar dados do cliente pelo id
3. GET - buscar lista de clientes
4. GET /{id} - retornar cliente por id
5. DELETE /{id} - deletar cliente por id

###  /produtos
1. POST - criar novo produto
2. PUT /{id} - atualizar dados do produto pelo id
3. GET - buscar lista de produtos
4. GET /{id} - retornar produto por id
5. DELETE /{id} - deletar produto por id

### /caixa
1. POST  - cadastrar venda
2. GET  - retornar ultima venda

### /funcionarios
1. POST -  cadastrar novo funcionário e usuário
2. GET - retornar lista de funcionários
3. GET /{id} - buscar funcionário por id 
4. PUT /{id} - Editar usuário por id
5. DELETE /{id} - Apagar usuário por id

### Login
1. POST  /login - Realizar login do usuário
2. POST /logout - Encerrar sessão

## 🛠️ Construído com

* [Java](https://www.oracle.com/java/) - Linguagem usada
* [Springboot](https://spring.io/projects/spring-boot) - O framework utilizado
* [Maven](https://maven.apache.org/) - Gerente de Pacotes

## ✒️ Autores
* **Um desenvolvedor** - Elaboração e Execução

---
Feito com ❤️ por [Mirella Santos](https://github.com/MSantos4) 😊