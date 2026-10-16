# ecom-firstproject

A small Spring Boot REST API for managing e-commerce customers, orders and people, backed by an in-memory H2 database. It covers the basics of Spring Boot, JDBC and REST, using a layered architecture (controller → service → repository) with mappers and request/response objects.

## Tech Stack

- Java 17
- Spring Boot 4.0.8 (Web, JDBC, Data JPA, Actuator)
- H2 in-memory database (MySQL compatibility mode) with the H2 console
- Gradle (wrapper included)
- JUnit 5 for tests

## Getting Started

From the `ecom-firstproject-main` directory:

```
./gradlew bootRun
```

The app starts on `http://localhost:8080`. The H2 console is available at `/h2-console` (JDBC URL `jdbc:h2:mem:testdb`, user `sa`, empty password).

## API Endpoints

| Resource | Base path   | Endpoints |
|----------|-------------|-----------|
| Customer | `/customer` | `GET /{id}`, `GET /all`, `GET /ids`, `POST /create`, `PUT /update`, `DELETE /delete/{id}` |
| Order    | `/order`    | `GET /{id}`, `GET /all`, `GET /ids`, `POST /create`, `PUT /update`, `DELETE /delete/{id}` |
| Person   | `/person`   | `GET /{id}`, `GET /all`, `POST /create`, `PUT /update`, `DELETE /delete/{id}` |

Orders use dedicated request/response objects (`OrderRequest`, `OrderResponse`), and the controllers handle errors with try/catch.

## Database

Tables are defined in `schema.sql` and seeded from `data.sql`:

- `customer` – id, first_name, last_name, email, customer_status (default `REGULAR`)
- `customer_order` – id, customer_id (FK to `customer`), item_name, price
- `person` – id, first_name, last_name

## Project Structure

```
src/main/java/ecom/firstProject/
├── FirstProjectApplication.java   # Application entry point
├── controller/{customer,order,person}/   # REST endpoints
├── service/{customer,order,person}/      # Service interfaces and implementations
├── repository/{customer,order,person}/   # Repository interfaces and JDBC implementations
├── mapper/{customer,order,person}/       # Row/entity mappers
├── model/{customer,order,person}/        # Domain models (incl. CustomerStatus enum)
├── requests/order/                       # Order request/response objects
└── responses/                            # Response objects
src/main/resources/
├── application.yaml               # Datasource and H2 console config
├── schema.sql                     # Table definitions
└── data.sql                       # Seed data
```
