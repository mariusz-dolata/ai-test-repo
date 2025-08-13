# CRUD Microservice

A simple Spring Boot microservice for managing companies with full CRUD operations and PostgreSQL integration.

## Features

- RESTful API for Company management
- PostgreSQL database integration
- Multiple Maven profiles (development, production)
- Input validation
- Comprehensive test coverage
- Docker-ready configuration

## Technology Stack

- **Framework**: Spring Boot 3.1.5
- **Database**: PostgreSQL
- **ORM**: Spring Data JPA with Hibernate
- **Build Tool**: Maven
- **Testing**: JUnit 5, Spring Boot Test, H2 (for testing)
- **Java**: 17

## Project Structure

```
src/
├── main/
│   ├── java/com/example/crudmicroservice/
│   │   ├── controller/     # REST controllers
│   │   ├── dto/           # Data Transfer Objects
│   │   ├── entity/        # JPA entities
│   │   ├── repository/    # Data Access Objects (DAO)
│   │   ├── service/       # Business logic
│   │   └── CrudMicroserviceApplication.java
│   └── resources/
│       ├── application.properties
│       ├── application-development.properties
│       └── application-prod.properties
└── test/
    ├── java/              # Test classes
    └── resources/
        └── application-test.properties
```

## Company Entity

The Company entity includes:
- `id` (Long) - Primary key
- `name` (String) - Company name
- `nip` (String) - Tax identification number (unique)
- `employees` (List<String>) - List of employee names

## API Endpoints

### Companies

- `GET /api/companies` - Get all companies
- `GET /api/companies/{id}` - Get company by ID
- `GET /api/companies/nip/{nip}` - Get company by NIP
- `POST /api/companies` - Create new company
- `PUT /api/companies/{id}` - Update company
- `DELETE /api/companies/{id}` - Delete company

### Example Request/Response

**Create Company:**
```json
POST /api/companies
{
  "name": "Example Corp",
  "nip": "1234567890",
  "employees": ["John Doe", "Jane Smith"]
}
```

**Response:**
```json
{
  "id": 1,
  "name": "Example Corp",
  "nip": "1234567890",
  "employees": ["John Doe", "Jane Smith"]
}
```

## Maven Profiles

### Development Profile
- **Activation**: Default profile
- **Database**: localhost:5432/crud_microservice_dev
- **Settings**: 
  - Create-drop DDL mode
  - SQL logging enabled
  - Debug logging

### Production Profile
- **Activation**: `-Pprod`
- **Database**: postgres-prod:5432/crud_microservice_prod
- **Settings**:
  - Validate DDL mode
  - SQL logging disabled
  - Optimized connection pool
  - Environment variable configuration

## Running the Application

### Prerequisites
- Java 17+
- Maven 3.6+
- PostgreSQL 12+ (for development/production)

### Development Mode
```bash
# Start with development profile (default)
mvn spring-boot:run

# Or explicitly specify development profile
mvn spring-boot:run -Pdevelopment
```

### Production Mode
```bash
# Set environment variables
export DB_USERNAME=your_username
export DB_PASSWORD=your_password

# Run with production profile
mvn spring-boot:run -Pprod
```

### Testing
```bash
# Run all tests
mvn test

# Run tests with specific profile
mvn test -Ptest
```

## Database Configuration

### Development
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/crud_microservice_dev
spring.datasource.username=dev_user
spring.datasource.password=dev_password
```

### Production
```properties
spring.datasource.url=jdbc:postgresql://postgres-prod:5432/crud_microservice_prod
spring.datasource.username=${DB_USERNAME:prod_user}
spring.datasource.password=${DB_PASSWORD:prod_password}
```

## Building

### Compile
```bash
mvn clean compile
```

### Package
```bash
mvn clean package
```

### Build with specific profile
```bash
mvn clean package -Pprod
```

## Docker Support

The application is ready for containerization. The JAR file can be found in `target/` after building.

## Validation

The application includes comprehensive input validation:
- Company name is required and max 255 characters
- NIP is required, max 20 characters, and must be unique
- Employee list is optional

## Error Handling

The API returns appropriate HTTP status codes:
- `200 OK` - Successful GET requests
- `201 Created` - Successful POST requests
- `400 Bad Request` - Validation errors or duplicate NIP
- `404 Not Found` - Resource not found
- `204 No Content` - Successful DELETE requests