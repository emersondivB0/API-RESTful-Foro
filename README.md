# API RESTful | Back-end | Foro Alura 

<p align="center" >
     <img width="200" heigth="200" src="https://user-images.githubusercontent.com/91544872/209678377-70b50b21-33de-424c-bed8-6a71ef3406ff.png">
</p>

### ¡Welcome to the project challenge Foro Alura con Java y Spring! 


### First steps:

#### ⭐ Star this project

# Forum API

![GitHub repo size](https://img.shields.io/github/repo-size/emersondivB0/API-RESTful-Foro)
![GitHub contributors](https://img.shields.io/github/contributors/emersondivB0/API-RESTful-Foro)
![GitHub stars](https://img.shields.io/github/stars/emersondivB0/API-RESTful-Foro?style=social)
![GitHub forks](https://img.shields.io/github/forks/emersondivB0/API-RESTful-Foro?style=social)

## Description

Forum API is a RESTful API developed using Java, Spring Boot, Lombok, Jakarta, MySQL, and JWT. It allows users to manage posts, responses to the posts, and user authentication.

## Features

- Create, Read, Update, and Delete (CRUD) operations for posts and responses.
- User authentication with JWT and BCrypt for secure access.
- Two types of delete operations: normal delete and boolean delete.
- Flyway integration for database schema management.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Authentication](#authentication)
- [Contributing](#contributing)
- [Technologies](#technologies)

## Installation

1. Clone the repository.

2. Install the required dependencies.

3. Run the application.

## Usage

- Make HTTP requests to the API endpoints to manage posts, responses, and users.
- Ensure you have the necessary authentication token (JWT) to access secure endpoints.

## Endpoints

- **GET /topics**: Get all topics.
- **GET /topics/{topicId}**: Get a specific topic by ID.
- **POST /topics**: Create a new topic.
- **PUT /topics/{topicId}**: Update an existing topic.
- **DELETE /topics/admin/{topicId}**: Delete a topic (normal delete).
- **DELETE /topics/{topicId}**: Soft delete a topic (boolean delete).

- **GET /responds**: Get all responses.
- **POST /responds**: Create a new response.
- **DELETE /responses/{responseId}**: Soft delete a response (boolean delete).

- **POST /login**: User login to get JWT token.
- **POST /register**: Register a new user.

## Authentication

- For secure endpoints, include the JWT token in the Authorization header with the Bearer scheme. I used Auth0.

## Contributing

Contributions are welcome! Please feel free to open issues and pull requests.


## Used technologies:

  - [IntelliJ IDEA](https://www.jetbrains.com/idea/)
  - [MySql](https://www.mysql.com/)
  - [Java 17](https://www.java.com/en/)
  - [Spring Boot 3.1.0](https://start.spring.io)
  - [Spring Security](https://start.spring.io/)
  - [Token JWT](https://jwt.io/)

💙 Emerson González

[![img](https://camo.githubusercontent.com/c00f87aeebbec37f3ee0857cc4c20b21fefde8a96caf4744383ebfe44a47fe3f/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f2d4c696e6b6564496e2d2532333030373742353f7374796c653d666f722d7468652d6261646765266c6f676f3d6c696e6b6564696e266c6f676f436f6c6f723d7768697465)](https://www.linkedin.com/in/emerson-gonzalez-developer/)
