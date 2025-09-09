# GitHub Copilot Instructions

## Project Overview
This is a **Bank Account Management System** built with Java Spring Boot, demonstrating Test Driven Development (TDD) and object-oriented design principles. The application provides REST API endpoints for managing bank accounts with operations like account creation, balance checking, and withdrawals.

## Technology Stack
- **Language**: Java 8+
- **Framework**: Spring Boot 2.1.0  
- **Build Tool**: Maven (primary), Ant (alternative)
- **Testing**: JUnit 4.12, Spring Boot Test
- **CI/CD**: Travis CI
- **Deployment**: Heroku
- **Data**: In-memory repository pattern

## Project Structure Guidelines

### Package Organization
- `com.danielwildt.api` - REST controllers and main Spring Boot application
- `com.danielwildt.model` - Domain models and business logic
- `com.danielwildt.db` - Repository interfaces and implementations  
- `com.danielwildt.console` - Console application interface
- Test packages mirror main package structure

### Code Style and Conventions
- Use **PascalCase** for class names
- Use **camelCase** for method and variable names
- Follow Spring Boot conventions for REST controllers
- Implement repository pattern with interfaces
- Write descriptive test method names
- Maintain clear separation of concerns

## Key Components

### Main Application
- `WildtechBank.java` - Spring Boot main application class
- `AccountController.java` - REST API endpoints

### Core Models
- `BankAccount.java` - Core domain model for bank accounts
- Repository pattern for data access abstraction

### API Endpoints
```java
// Account operations
GET /balance?name={accountName}           // Check balance
POST /add?name={accountName}&balance={amount}  // Create account  
POST /withdraw?name={accountName}&value={amount} // Withdraw funds
```

## Development Guidelines

### When Writing Code
1. **Follow TDD**: Write tests first, then implementation
2. **Use Spring annotations** appropriately (@RestController, @Service, etc.)
3. **Implement proper error handling** for API endpoints
4. **Maintain immutable objects** where possible
5. **Use dependency injection** through constructor injection
6. **Write comprehensive unit tests** for all business logic

### Testing Approach
- Unit tests for all model classes
- Integration tests for API controllers
- Use Spring Boot testing utilities
- Mock external dependencies appropriately
- Aim for high test coverage

### Build and Deploy
- Use Maven for dependency management: `mvn install`
- Run application: `mvn spring-boot:run` (default port 8080)
- Run tests: `mvn test`
- Alternative Ant build available: `ant test`

## Domain Knowledge

### Business Logic
- Each account has a name (identifier) and balance
- Accounts can be created with initial balance
- Withdrawals reduce account balance
- Balance checks return current account balance
- Simple in-memory storage for demonstration

### Repository Pattern
- `AccountRepository` interface defines data operations
- `InMemoryAccountRepository` provides concrete implementation
- Supports easy switching to different storage backends

## Code Quality Standards
- Maintain clean, readable code with proper naming
- Add appropriate JavaDoc for public methods
- Handle edge cases and validation
- Follow SOLID principles in design
- Keep methods focused and single-purpose

## When Suggesting Code Changes
- Prefer minimal, focused changes
- Maintain existing code style and patterns
- Ensure backward compatibility
- Add tests for new functionality
- Consider performance and error handling
- Follow established project conventions