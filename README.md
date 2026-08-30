# E-Commerce Microservices

A backend e-commerce application built using **Java, Spring Boot, and Microservices Architecture**.

This project is developed as part of my learning journey to understand how multiple Spring Boot applications can work together as independent services.

## Architecture

The application is divided into multiple microservices, where each service is responsible for a specific business functionality.

The project currently includes:

* **Eureka Server** - Handles service discovery and keeps track of registered microservices.
* **User Management Service** - Handles user-related operations.
* **Product Management Service** - Handles product-related operations.
* **Order Management Service** - Handles order creation and management.
* **Inventory Management Service** - Handles inventory and stock-related operations.
* **Delivery Management Service** - Handles delivery-related operations.

All services are registered with the Eureka Server.

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* REST APIs
* MySQL
* Spring Cloud Netflix Eureka
* Swagger / OpenAPI
* Maven

## Service Discovery

Eureka Server is used for service discovery.

Each microservice registers itself with Eureka, allowing the services to be discovered and monitored from the Eureka dashboard.

Example services registered with Eureka:

* User Management
* Product Management
* Order Management
* Inventory Management
* Delivery Management

## API Testing

The REST APIs are tested using **Swagger UI**.

Swagger provides an interactive interface to view and test the available API endpoints directly from the browser.

## Project Structure

```text
ecommerce-microservices
│
├── EurekaServer
│
├── UserManagement
│
├── ProductManagement
│
├── OrderManagement
│
├── InventoryManagement
│
└── DeliveryManagement
```

## How to Run the Project

1. Clone the repository.

2. Configure the database details in each microservice.

3. Start the Eureka Server.

4. Start the microservices.

5. Verify that all services are registered successfully in the Eureka dashboard.

6. Use Swagger UI to test the APIs of each microservice.

## Learning Objectives

This project was built to gain hands-on experience with:

* Spring Boot
* REST API development
* Microservices Architecture
* Service Discovery using Eureka
* Spring Data JPA and Hibernate
* Database integration with MySQL
* API testing using Swagger

## Future Improvements

Possible improvements for this project include:

* API Gateway
* Spring Cloud Config Server
* Centralized exception handling
* Authentication and authorization using Spring Security and JWT
* Docker containerization
* Inter-service communication
* Logging and monitoring
* Deployment to a cloud platform

## Author

Developed as a learning project while exploring Java, Spring Boot, and Microservices Architecture.
