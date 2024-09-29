# Note Tracker - Spring Boot Application Class Project - AAD- GDSE68

This is a Spring Boot application designed for tracking user notes, which allows full CRUD operations (Create, Read, Update, Delete) for both `User` and `Note`. The project is integrated with MySQL for database management, supports comprehensive exception handling, and includes health check endpoints. Postman is used for API testing.

## Features

- **User Management**: Perform CRUD operations for `User`.
- **Note Management**: Perform CRUD operations for `Note`.
- **Health Check**: Check if the application is running properly.
- **Error Handling**: Custom exceptions for better error messages and debugging.
- **Postman Testing**: API testing is done via Postman for all CRUD operations.

## Technology Stack

- **Backend**: Spring Boot
- **Database**: MySQL
- **Testing**: Postman
- **Build Tool**: Maven
- **Java Version**: 11+
- **Dependencies**:
  - Spring Boot Starter Web
  - Spring Boot Starter Data JPA
  - MySQL Driver
  - Spring Boot DevTools (Optional)
  - Spring Boot Actuator (For Health Check)
  - Spring Boot Starter Validation (For error handling)

## Prerequisites

- **Java 11** or higher installed
- **Maven** installed
- **MySQL** installed and running
- **Postman** installed for API testing

## Setup Instructions

### MySQL Database Configuration

1. Create a new database in MySQL:
   ```sql
   CREATE DATABASE notetracker;


### post man document- https://documenter.getpostman.com/view/35385905/2sAXjF8aZW
