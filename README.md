# Gson POC Spring Boot API

This project demonstrates a Spring Boot API configured to use Gson for JSON serialization and deserialization.

## Features

*   **Gson Integration:** The project is configured to use Gson as the preferred JSON mapper.
*   **H2 In-Memory Database:** The project uses an H2 in-memory database for storing data.
*   **Spring Data JPA:** The project uses Spring Data JPA for data access.
*   **Unit Tests:** The project includes unit tests for the `UserController`.

## Configuration

The following configurations have been added to the `application.properties` file:

*   `spring.http.converters.preferred-json-mapper=gson`: Sets Gson as the preferred JSON mapper.
*   `spring.gson.date-format=yyyy-MM-dd'T'HH:mm:ssZ`: Sets the default date format for Gson to ISO 8601.
*   `spring.gson.disable-html-escaping=true`: Disables HTML escaping.
*   `spring.gson.serialize-nulls=true`: Tells Gson to serialize null values.
*   `spring.h2.console.enabled=true`: Enables the H2 console.
*   `spring.datasource.url=jdbc:h2:mem:testdb`: Sets the database URL.
*   `spring.datasource.driverClassName=org.h2.Driver`: Sets the database driver.
*   `spring.datasource.username=sa`: Sets the database username.
*   `spring.datasource.password=`: Sets the database password.
*   `spring.jpa.database-platform=org.hibernate.dialect.H2Dialect`: Sets the database platform.

## How to Run the Application

1.  **Navigate to the project root directory:**
    ```bash
    cd C:\Users\jpc\poc-workspace\gson-poc
    ```

2.  **Run the Spring Boot application using Maven:**
    ```bash
    mvn spring-boot:run
    ```

    The application will start on `http://localhost:8080`.

## API Endpoints

Once the application is running, you can test the following endpoints:

### 1. Get All Users

*   **Method:** `GET`
*   **URL:** `http://localhost:8080/user`
*   **Description:** Retrieves a list of all `User` objects from the database.

### 2. Get User by ID

*   **Method:** `GET`
*   **URL:** `http://localhost:8080/user/{id}`
*   **Description:** Retrieves a single `User` object from the database by its ID.

### 3. Create User

*   **Method:** `POST`
*   **URL:** `http://localhost:8080/user`
*   **Content-Type:** `application/json`
*   **Description:** Accepts a JSON string representing a `User` object, which will be saved to the database.
*   **Request Body Example:**
    ```json
    {
        "name": "Jane Doe",
        "email": "jane.doe@example.com"
    }
    ```