# Java & SpringBoot Project

## License
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/EdsonLPCamacho/workspace_springboot_jpa/blob/main/LICENSE) 

## Project Description

This project is a web application developed using Java Spring Boot, JPA, and Hibernate. It serves as a practical implementation of the concepts learned in a course, 
demonstrating CRUD operations, database management, and RESTful API development. The application is designed to manage client data, providing functionalities to create, read,
update, and delete records efficiently.

https://github.com/EdsonLPCamacho/workspace_springboot_jpa


## Layout mobile
![Mobile 1](https://github.com/acenelio/assets/raw/main/sds1/mobile1.png) ![Mobile 2](https://github.com/acenelio/assets/raw/main/sds1/mobile2.png)

## Layout web
![Web 1](https://github.com/acenelio/assets/raw/main/sds1/web1.png)

![Web 2](https://github.com/acenelio/assets/raw/main/sds1/web2.png)

## Modelo conceitual
![Modelo Conceitual](https://github.com/acenelio/assets/raw/main/sds1/modelo-conceitual.png)


## Technologies Used

- **Java**: The core programming language used for development.
- **Spring Boot**: Framework used to create stand-alone, production-grade Spring-based applications.
- **JPA/Hibernate**: For ORM (Object-Relational Mapping) and database interactions.
- **Maven**: For project management and build automation.
- **H2/MySQL/PostgreSQL**: Depending on the environment, various database options are supported.

```bash
# Clone the repository
git clone https://github.com/EdsonLPCamacho/workspace_springboot_jpa

# Navigate to the front-end web project directory
cd front-web

# Install dependencies
yarn install

# Run the project
yarn start
```

## Contributing

We welcome contributions to improve the project. Please fork the repository and create a pull request with your changes. Make sure to follow the existing code style and include tests for any new features or bug fixes.

# How to Run the Project

## Back end
Need: Java 11

```bash
# Clone the repository
git clone https://github.com/EdsonLPCamacho/workspace_springboot_jpa

# Navigate to the backend project directory
cd backend

# Run the project
./mvnw spring-boot:run
```

## Front end web


Pré-requisitos: npm / yarn

```bash
# Clone the repository
git clone https://github.com/EdsonLPCamacho/workspace_springboot_jpa

# Navigate to the front-end web project directory
cd front-web

# Install dependencies
yarn install

# Run the project
yarn start
```

# Project Name

## Overview

This project is built using Java and Spring Boot, following the layered architecture pattern. This approach separates the application into distinct layers, each responsible for specific aspects of the system. This separation enhances maintainability, scalability, and testability.

## Layered Architecture

The project is divided into the following layers:

1. **Development Layer**: This layer includes development-specific configuration and setup files.
2. **Controller Layer**: This layer is responsible for handling HTTP requests and responses. It includes the controllers and any necessary view-related logic.
3. **Entity Layer**: This layer consists of the domain entities or models. These are the core business objects that represent the data structure and business rules of the application.
4. **Enums Layer**: This layer contains enum definitions used throughout the application.
5. **Primary Key (PK) Layer**: This layer contains classes related to composite primary keys used in entity definitions.
6. **Repositories Layer**: This layer is responsible for interacting with the database. It includes repositories or DAOs (Data Access Objects) that handle CRUD operations and any other database-related tasks.
7. **Services Layer**: This layer contains the business logic of the application. It acts as an intermediary between the controller and repositories layers, processing requests from the controller layer and making calls to the repositories layer.
8. **Setup Layer**: This layer includes configuration classes and initial setup files for the application.
9. **Resources Layer**: This layer contains static resources such as application properties, templates, and other static files.

## Folder Structure

The project follows a standard folder structure to align with the layered architecture:



# Author

Edson L P Camacho

https://www.linkedin.com/in/edsoncamacho/

