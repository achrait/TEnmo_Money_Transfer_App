# Tenmo - Secure Money Transfer Application

## Description
Tenmo is a Java Spring Boot application that simulates a secure platform for transferring money between users. It provides a RESTful API for managing user accounts, processing money transfers, and handling transfer requests.

## Features
- User registration and authentication
- Account balance viewing
- Money transfer between users
- Transfer request functionality
- Transfer history viewing
- Pending transfer management (approve/reject)

## Technology Stack
- Java 11
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or later
- Maven
- PostgreSQL

### Installation
1. Clone the repository
2. Navigate to the project directory
3. Create a PostgreSQL database named `tenmo`
4. Update `src/main/resources/application.properties` with your database credentials
5. Build the project
6. Run the application

The application will start running at `http://localhost:8080`.
## API Endpoints
- POST /register - Register a new user
- POST /login - Authenticate a user
- GET /accounts/balance - Get current user's balance
- GET /transfers - Get user's transfer history
- POST /transfers/send - Send money to another user
- POST /transfers/request - Request money from another user
- GET /transfers/pending - Get pending transfer requests
- POST /transfers/{id}/approve - Approve a pending transfer
- POST /transfers/{id}/reject - Reject a pending transfer
