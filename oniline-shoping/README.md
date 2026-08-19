# Product Search API

A full-stack Product Search application built using **Spring Boot**, **Spring Data JPA**, **H2 Database**, and **React**. The application allows users to manage products and perform real-time keyword-based searches with a clean REST API.

---

## Features

* CRUD operations for products
* Search products by keyword using JPQL
* RESTful API
* Spring Data JPA integration
* H2 in-memory database
* Layered architecture (Controller → Service → Repository)
* React frontend with live search suggestions
* JSON-based API responses

---

## Tech Stack

### Backend

* Java 21+
* Spring Boot
* Spring Data JPA
* Hibernate
* H2 Database
* Maven

### Frontend

* React
* Axios
* Bootstrap

---

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.example.productsearch
│   │       ├── controller
│   │       ├── service
│   │       ├── repository
│   │       ├── model
│   │       └── ProductSearchApplication
│   └── resources
│       ├── application.properties
│       └── data.sql
```

---

## API Endpoints

| Method | Endpoint                       | Description                |
| ------ | ------------------------------ | -------------------------- |
| GET    | /products                      | Get all products           |
| GET    | /products/{id}                 | Get product by ID          |
| POST   | /products                      | Add new product            |
| PUT    | /products/{id}                 | Update product             |
| DELETE | /products/{id}                 | Delete product             |
| GET    | /products/search?keyword=value | Search products by keyword |

---

## Search Functionality

Products can be searched using a keyword that matches:

* Product Name
* Brand
* Category
* Description

The search is implemented using a custom **JPQL** query for efficient filtering.

---

## Running the Project

### Backend

```bash
git clone <repository-url>

cd ProductSearch

mvn spring-boot:run
```

Backend runs on:

```
http://localhost:8080
```

---

### H2 Database Console

```
http://localhost:8080/h2-console
```

Default configuration:

```
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password:
```

---

### Frontend

```bash
cd frontend

npm install

npm start
```

Runs on:

```
http://localhost:3000
```

---

## Sample Product JSON

```json
{
  "name": "iPhone 15",
  "brand": "Apple",
  "category": "Mobile",
  "description": "Latest Apple smartphone",
  "price": 79999
}
```

---

## Future Improvements

* JWT Authentication
* Spring Security
* MySQL/PostgreSQL support
* Pagination & Sorting
* Image Upload
* Product Filtering
* Docker Deployment
* Unit Testing (JUnit & Mockito)

---

## Learning Outcomes

* Spring Boot REST APIs
* Spring Data JPA
* JPQL Queries
* Repository Pattern
* MVC Architecture
* React API Integration
* CRUD Operations
* H2 Database Configuration
* Backend-Frontend Communication

---

## Author

**Akshat Tiwari**

Java Backend Developer | Spring Boot | React | REST APIs | SQL
