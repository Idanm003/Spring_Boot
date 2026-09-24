# ecom-firstproject

A small Spring Boot REST API for managing e-commerce customers, backed by an in-memory H2 database. It talks about the basics of Spring Boot, JDBC and REST.

## Tech Stack

- Java 17
- Spring Boot 4.0.8 (Web, JDBC, Data JPA, Actuator)
- H2 in-memory database (MySQL compatibility mode) with the H2 console
- Gradle (wrapper included)
- JUnit 5 for tests

## Project Structure

```
src/main/java/ecom/firstProject/
├── FirstProjectApplication.java      # Application entry point
├── controller/CustomerController.java  # REST endpoints
├── model/Customer.java               # Customer model
└── repository/
    ├── CustomerRepository.java       # Repository interface
    └── CustomerRepositoryImpl.java   # JDBC implementation
src/main/resources/
├── application.yaml                  # Datasource and H2 console config
├── schema.sql                        # Table definitions
└── data.sql                          # Seed data
```

## Notes and Limitations

- The database is in-memory, so all data is reset when the application restarts.
- Only create, update and delete endpoints exist; there are no read (GET) endpoints yet.
- The `customer_order` table is not yet exposed through the API.
- Deleting a customer who has orders will fail due to the foreign key constraint.
