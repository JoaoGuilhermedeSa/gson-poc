# Gson POC Spring Boot API

This project demonstrates a Spring Boot API configured to use Gson for JSON serialization and deserialization.

## Project Structure

```
.git/
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── example/
│   │           └── gsonpoc/
│   │               ├── config/
│   │               │   └── GsonConfig.java
│   │               ├── controller/
│   │               │   └── UserController.java
│   │               ├── model/
│   │               │   └── User.java
│   │               └── GsonPocApplication.java
│   └── resources/
│       └── application.properties
└── test/
pom.xml
README.md
```

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

### 1. Get User (Serialization)

*   **Method:** `GET`
*   **URL:** `http://localhost:8080/user`
*   **Description:** Retrieves a sample `User` object, which will be serialized to JSON using Gson.
*   **Expected Response Example:**
    ```json
    {
      "name": "John Doe",
      "email": "john.doe@example.com"
    }
    ```

### 2. Create User (Deserialization)

*   **Method:** `POST`
*   **URL:** `http://localhost:8080/user`
*   **Content-Type:** `application/json`
*   **Description:** Accepts a JSON string representing a `User` object, which will be deserialized into a `User` Java object using Gson.
*   **Request Body Example:**
    ```json
    {
        "name": "Jane Doe",
        "email": "jane.doe@example.com"
    }
    ```
*   **Expected Response Example:**
    ```json
    {
      "name": "Jane Doe",
      "email": "jane.doe@example.com"
    }
    ```
