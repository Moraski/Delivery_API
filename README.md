Delivery API

API para gerenciar pedidos, clientes e entregas de um sistema de delivery.

🔹 Tecnologias

Java 23

Spring Boot 3.5

Spring Data JPA

MySQL

Springdoc OpenAPI (Swagger UI)

Maven

🔹 Funcionalidades

CRUD de Clientes, Pedidos e Itens

Endpoints documentados via Swagger

Conexão com banco MySQL

Tratamento de exceções centralizado

🔹 Rodando localmente

Clone o repositório:

git clone https://github.com/SEU_USUARIO/DeliveryAPI.git


Configure o banco de dados MySQL no application.yml:

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/delivery_db
    username: root
    password: SUA_SENHA


Rode o projeto usando Maven ou IDE:

mvn spring-boot:run


Acesse a API:

http://localhost:8080/delivery/api


Para acessar a documentação Swagger UI:

http://localhost:8080/delivery/api/public/swagger

http://localhost:8080/delivery/api/v3/api-docs
