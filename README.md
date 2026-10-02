# Course — Web Services com Spring Boot e JPA

API REST de estudo construída com Spring Boot e JPA/Hibernate, modelando um domínio simples de e-commerce: usuários, pedidos, categorias e produtos.

## Tecnologias

- Java 25
- Spring Boot 4.1 (Web MVC, Data JPA)
- H2 Database (banco em memória para o perfil de teste)
- PostgreSQL (driver incluído para uso futuro)
- Maven

## Modelo de domínio

```
User 1 ──── * Order
Order ── OrderStatus (enum persistido como código inteiro)
Product * ──── * Category
```

- **User**: cliente que realiza pedidos.
- **Order**: pedido com data (`Instant`), status e cliente.
- **OrderStatus**: `WAITING_PAYMENT`, `PAID`, `SHIPPED`, `DELIVERED`, `CANCELED`.
- **Category**: categoria de produtos.
- **Product**: produto com preço em `BigDecimal`, associado a várias categorias.

## Arquitetura

Organizado em camadas:

```
resources/    → controladores REST
services/     → regras de negócio
repository/   → acesso a dados (Spring Data JPA)
entities/     → entidades JPA
config/       → configuração e seed do banco (perfil test)
```

## Como executar

Pré-requisito: JDK 25.

```bash
./mvnw spring-boot:run
```

A aplicação sobe em `http://localhost:8080` com o perfil `test` ativo, que popula o banco H2 com dados de exemplo.

### Console do H2

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuário: `sa` (sem senha)

## Endpoints

| Método | Rota               | Descrição                 |
|--------|--------------------|---------------------------|
| GET    | `/users`           | Lista todos os usuários   |
| GET    | `/users/{id}`      | Busca usuário por id      |
| GET    | `/orders`          | Lista todos os pedidos    |
| GET    | `/orders/{id}`     | Busca pedido por id       |
| GET    | `/categories`      | Lista todas as categorias |
| GET    | `/categories/{id}` | Busca categoria por id    |
| GET    | `/products`        | Lista todos os produtos   |
| GET    | `/products/{id}`   | Busca produto por id      |

O arquivo [`request.http`](request.http) traz exemplos de chamadas prontas para usar com o REST Client do VS Code ou o cliente HTTP do IntelliJ.

## Testes

```bash
./mvnw test
```
