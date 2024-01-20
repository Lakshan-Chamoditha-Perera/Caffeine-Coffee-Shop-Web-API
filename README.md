# Caffeine Coffee Shop Microservices

A set of microservices providing the backend API for a modern coffee shop using Java 17, Spring Boot, Spring Cloud, MySQL, MongoDB, API Gateway, Eureka Service Registry, and Config Server.

## Table of Contents

1. [Introduction](#introduction)
2. [Microservices](#microservices)
3. [Features](#features)
4. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Installation](#installation)
5. [Configuration](#configuration)
6. [Usage](#usage)
7. [API Documentation](#api-documentation)
8. [Contributing](#contributing)
9. [License](#license)
10. [Acknowledgements](#acknowledgements)

## Introduction

Caffeine Coffee Shop Microservices is a collection of Java-based microservices designed to efficiently manage various operations in a modern coffee shop. Each microservice focuses on specific functionalities, promoting scalability and maintainability in a microservices architecture. The API Gateway, Eureka Service Registry, and Config Server enhance communication, service discovery, and configuration management.

## Microservices

1. **Center_1 Microservice**: The main service for managing coffee, customers, baristas, and orders at `center_1`. It utilizes MySQL as the database and Spring Data JPA.

2. **Center_2 Microservice**: Manages ingredients and recipes at `center_2`. It uses MongoDB as the database, and Spring Boot with MongoRepositories.

3. **API Gateway (Api_gateway)**: Routes incoming requests and acts as a central entry point for all microservices.

4. **Eureka Service Registry (Eureka)**: Manages service registration and discovery for all microservices.

5. **Config Server (configserver)**: Manages configuration properties for the microservices.

## Features

- Comprehensive coffee, customer, barista, and order management in `center_1`.
- Ingredient and recipe management in `center_2`.
- Efficient communication between microservices through API Gateway.
- Service registration and discovery facilitated by Discovery Server.
- Configuration management with Config Service.

  
# Getting Started

To set up and run the Caffeine Coffee Shop Microservices, follow the steps below:

## Prerequisites

Make sure you have the following installed before setting up the Caffeine Coffee Shop Microservices:

- [Java 17 Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven](https://maven.apache.org/)
- [MySQL](https://www.mysql.com/)
- [MongoDB](https://www.mongodb.com/)
- [Spring Cloud](https://spring.io/projects/spring-cloud)

## Installation

1. **Clone the repository** to your local machine:

    ```bash
    git clone https://github.com/your-username/Caffeine-Coffee-Shop-Microservices.git
    ```

2. **Navigate to each microservice directory** (e.g., `center_1`, `center_2`, `api_gateway`, `discovery_server` etc.):

    ```bash
    cd center_1
    ```

3. **Build the microservice using Maven:**

    ```bash
    mvn clean install
    ```

    Repeat this step for each microservice (`center_2`, `api_gateway`, etc.) and the additional services (`discovery_server`, `config_service`).

4. **Build and run the Eureka Service Registry:**

    ```bash
    cd discovery_server
    mvn clean install
    ```

    Run the Eureka server:

    ```bash
    java -jar target/discovery_server.jar
    ```

5. **Build and run the Config Server:**

    ```bash
    cd config_service
    mvn clean install
    ```

    Run the Config Server:

    ```bash
    java -jar target/config_service.jar
    ```

6. **Build and run the API Gateway:**

    ```bash
    cd api_gateway
    mvn clean install
    ```

    Run the API Gateway:

    ```bash
    java -jar target/api-gateway.jar
    ```

7. **Build and run each microservice:**

    ```bash
    cd center_1
    java -jar target/center1.jar
    ```

    Repeat this step for `center_2`, `api_gateway`, and other microservices.

## Configuration

Update the configuration files (`application.properties` or `application.yml`) in each microservice, Eureka, and Config Server to include your database connection details (MySQL and MongoDB), Eureka server details, and any additional configurations.

## Usage

Each microservice provides RESTful endpoints for specific functionalities. Requests can be routed through the API Gateway, and service discovery is facilitated by Eureka. Configuration properties are managed by the Config Server.

## API Documentation

[Link to detailed API documentation for each microservice.]
