# Employee Management System

This project is a Spring Boot-based REST API for managing employee data. It provides functionality to create, retrieve, update, and delete employee records. Below are the details of the project structure and usage.

## Project Structure

- **Controller**: Handles incoming HTTP requests and delegates operations to the service layer.
- **Service**: Contains the business logic for managing employees.
- **Entity**: Defines the Employee model, which maps to the database.
- **Repository**: Handles data persistence and retrieval operations.

## Prerequisites

Before running this project, ensure you have the following installed:

1. **Java Development Kit (JDK)**: Version 11 or higher.
2. **Maven**: For building and managing dependencies.
3. **MySQL Database**: Or any other database configured in the application.
4. **Postman** (optional): For testing the API endpoints.

## Running the Project

1. Clone the repository.
   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory and build the project.
   ```bash
   mvn clean install
   ```

3. Update the `application.properties` file with your database credentials.

4. Run the application.
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

### Base URL
All endpoints are prefixed with `/api/employee`.

### Endpoints

#### Get All Employees
- **URL**: `GET /`
- **Description**: Retrieves a list of all employees.
- **Response**: List of `Employee` objects.

#### Get Employee by ID
- **URL**: `GET /{id}`
- **Description**: Retrieves a specific employee by their ID.
- **Parameters**:
  - `id` (PathVariable): The ID of the employee.
- **Response**: Single `Employee` object.

#### Add New Employee
- **URL**: `POST /addemployee`
- **Description**: Adds a new employee.
- **Request Body**:
  - `Employee` object containing employee details.
- **Response**: The newly created `Employee` object.

#### Update Employee
- **URL**: `PUT /updateemployee/{id}`
- **Description**: Updates an existing employee.
- **Parameters**:
  - `id` (PathVariable): The ID of the employee to update.
- **Request Body**:
  - `Employee` object containing updated details.
- **Response**: Updated `Employee` object or 404 if not found.

#### Delete Employee
- **URL**: `DELETE /deleteemployee/{id}`
- **Description**: Deletes an employee by their ID.
- **Parameters**:
  - `id` (PathVariable): The ID of the employee to delete.
- **Response**: Success message.

## Example `application.properties`
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employeedb
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

## Testing the API

1. Use Postman or any API testing tool to test the endpoints.
2. Ensure the database is running and properly configured.
3. Test each endpoint using the appropriate HTTP method and request body/parameters.

## Future Enhancements

1. Implement pagination and sorting for retrieving employees.
2. Add validations for request payloads.
3. Implement role-based access control using Spring Security.
4. Add logging for better debugging and monitoring.
