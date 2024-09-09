# Coding Challenge: API for Product Management

This project implements a Spring Boot application that interacts with the [Fake Store API](https://fakestoreapi.com/) to manage products. The application includes user authentication and product management functionalities.

## Getting Started

### Prerequisites

- Java 17 or later
- Maven
- MySQL
- Postman (for API testing)

### Setup

1. **Clone the Repository:**

    ```bash
    https://github.com/RADHIKESHS/CodingChallange.git
    cd CodingChallange
    ```

2. **Create and Configure MySQL Database:**

    - Create a new MySQL database.
    - Update the `src/main/resources/application.properties` file with your database credentials:

      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
      spring.datasource.username=your_database_username
      spring.datasource.password=your_database_password
      spring.jpa.hibernate.ddl-auto=update
      
      publicapi.url=https://fakestoreapi.com
      ```

3. **Build and Run the Application:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## API Endpoints

### Authentication

#### 1. Sign Up

- **Endpoint:** `POST /api/auth/signup`
- **Description:** Registers a new user.
- **Request Body:**

    ```json
    {
      "email": "user@example.com",
      "password": "your_password",
      "name": "John Doe",
      "phone": "1234567890"
    }
    ```

- **Response:**

    ```json
    {
      "id": 1,
      "email": "user@example.com",
      "name": "John Doe",
      "phone": "1234567890"
    }
    ```

#### 2. Log In

- **Endpoint:** `POST /api/auth/login`
- **Description:** Authenticates a user and returns a JWT token.
- **Request Body:**

    ```json
    {
      "email": "user@example.com",
      "password": "your_password"
    }
    ```

- **Response:**

    ```json
    {
      "token": "your_jwt_token"
    }
    ```

### Product Management

#### 1. Get Products by Category

- **Endpoint:** `GET /api/products/category/{category}`
- **Description:** Retrieves a list of products based on the specified category.
- **Parameters:**
  - `category`: The category of the products (e.g., `jewelery`).
- **Response:**

    ```json
    [
      {
        "id": 1,
        "title": "Product Title",
        "price": 29.99,
        "description": "Product Description",
        "category": "jewelery",
        "image": "http://example.com/image.jpg",
        "rating": {
          "rate": 4.5,
          "count": 120
        }
      }
      // More products
    ]
    ```

#### 2. Add New Product

- **Endpoint:** `POST /api/products`
- **Description:** Adds a new product to the store.
- **Request Body:**

    ```json
      {
        "id": 1,
        "title": "Product Title",
        "price": 29.99,
        "description": "Product Description",
        "category": "jewelery",
        "image": "http://example.com/image.jpg",
        "rating": {
          "rate": 4.5,
          "count": 120
        }
      }
    ```

- **Response:**

    ```json
      {
        "title": "Product Title",
        "price": 29.99,
        "description": "Product Description",
        "category": "jewelery",
        "image": "http://example.com/image.jpg",
        "rating": {
          "rate": 4.5,
          "count": 120
        }
      }
    ```

## How to Test

1. **Sign Up:**

    Use Postman to send a `POST` request to `http://localhost:8080/api/auth/signup` with the required body parameters.

2. **Log In:**

    Send a `POST` request to `http://localhost:8080/api/auth/login` to receive the JWT token.

3. **Get Products:**

    Send a `GET` request to `http://localhost:8080/api/products/category/{category}` with the appropriate category and jwt token in headers.

4. **Add Product:**

    Send a `POST` request to `http://localhost:8080/api/products` with the product details in the request body and jwt token in headers.

## Security and Reliability

To ensure the security and reliability of the APIs:

- **Authentication:** Use JWT tokens for secure access.
- **Data Validation:** Validate all input data to prevent invalid or harmful data from being processed.
- **Error Handling:** Implement proper error handling to provide meaningful error messages.
- **Logging:** Use logging to track application behavior and debug issues.
- **Rate Limiting:** Consider implementing rate limiting to prevent abuse of the APIs.

# CSV Processing API

This project provides a REST API for processing CSV files by evaluating formulas within cells using GraalVM.

### Prerequisites

- Java 17 or later
- Maven
- Postman (for API testing)

### Setup

1. **Clone the Repository:**

    ```bash
    https://github.com/RADHIKESHS/TheoreticalChallenge.git
    cd TheoreticalChallenge
    ```

2. **Build and Run the Application:**

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

## API Endpoints

### Process CSV

#### 1. Upload and Process CSV

- **Endpoint:** `POST /process-csv`
- **Description:** Uploads a CSV file, processes it by evaluating formulas within cells, and returns the processed CSV file.
- **Request:**
  - **Multipart File:** `file` (CSV file)
- **Response:**
  - **Content-Disposition Header:** `attachment;filename=processed_output.csv`
  - **Content-Type:** `application/csv`
  - **Body:** Processed CSV file

## Error Handling

The API provides specific error handling for CSV processing:

- **CsvProcessingException:** Returns a `400 Bad Request` response with the error message if an error occurs during CSV processing.
- **General Exceptions:** Returns a `500 Internal Server Error` response with a generic error message.

## How to Test

1. **Upload and Process CSV:**

    Use Postman to send a `POST` request to `http://localhost:8080/process-csv` with the CSV file in the `file` parameter.

## Security and Reliability

To ensure the security and reliability of the API:

- **Data Validation:** Ensure that the CSV data adheres to expected formats and values.
- **Error Handling:** Properly handle and log errors to provide meaningful feedback and support debugging.
- **Logging:** Use logging to monitor application behavior and issues.

## Contributing

Feel free to submit issues or pull requests. Please make sure your contributions adhere to the project's coding standards.

Replace placeholders such as `your-username`, `your-repository`, `your_database_name`, `your_database_username`, and `your_database_password` with your actual values.
