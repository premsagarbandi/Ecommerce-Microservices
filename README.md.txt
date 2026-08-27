# E-Commerce Microservices

A backend E-Commerce application built using Java and Spring Boot
following a Microservices Architecture.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Spring Cloud
- Eureka Server
- REST APIs
- Maven

## Microservices

### User Management Service
Handles user-related operations.

### Product Management Service
Handles product-related operations.

### Order Management Service
Handles order creation and management.

### Inventory Management Service
Handles product inventory and stock.

### Delivery Management Service
Handles delivery-related operations.

### Eureka Server
Used for service discovery and registration.

## Architecture

The application follows a Microservices Architecture where each
service is developed and runs independently.

All services register themselves with Eureka Server.

## How to Run the Project

1. Clone the repository.

2. Open the project in Eclipse or IntelliJ IDEA.

3. Configure MySQL database.

4. Start the Eureka Server.

5. Start all microservices.

6. Open Eureka Dashboard:

http://localhost:8761

## Future Improvements

- Add Spring Cloud Gateway
- Add JWT Authentication
- Add Docker
- Add Kafka or RabbitMQ
- Add centralized configuration