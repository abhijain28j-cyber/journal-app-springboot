# Journal App 📔

A secure, multi-tier RESTful backend application built with **Spring Boot 3**, **Spring Security**, and **MongoDB**. The platform allows registered users to maintain personal journal entries with strict ownership isolation, role-based access control (RBAC), and automated testing.

---

## 🚀 Features

- **User Authentication & Authorization**: Stateless HTTP Basic authentication backed by `BCryptPasswordEncoder` and Spring Security.
- **Role-Based Access Control (RBAC)**:
  - `USER`: Create, view, update, and delete personal journal entries.
  - `ADMIN`: Special endpoints to inspect all system users and provision administrative accounts.
- **Data Isolation & Atomicity**: Journal entries are associated directly with specific users via MongoDB `@DBRef` and transactional consistency.
- **Environment Profiles**: Configurable profiles (`dev`, `prod`) to swap database URIs and server ports smoothly across environments.
- **Unit & Integration Testing**: Comprehensive test coverage using **JUnit 5**, **Mockito**, parameterized tests (`@ValueSource`, `@CsvSource`), and mocked data access layers (`@Mock`, `@InjectMocks`).

---

## 🛠️ Tech Stack

- **Backend Framework**: Spring Boot 3
- **Language**: Java 17+
- **Security**: Spring Security 6
- **Database**: MongoDB (via Spring Data MongoDB)
- **Testing**: JUnit 5, Mockito
- **Build Tool**: Apache Maven
- **Productivity**: Project Lombok

---

## 📂 Project Structure

```text
src/
├── main/
│   ├── java/net/engineeringdigest/journalApp/
│   │   ├── config/          # Spring Security & App configuration
│   │   ├── controller/      # REST API endpoints (Admin, Public, Journal, User)
│   │   ├── entity/          # MongoDB document models (User, JournalEntry)
│   │   ├── repository/      # MongoRepository interfaces
│   │   └── service/         # Business logic & UserDetailsService implementation
│   └── resources/
│       ├── application.yml        # Base configurations
│       ├── application-dev.yml    # Development profile
│       └── application-prod.yml   # Production profile
└── test/
    └── java/net/engineeringdigest/journalApp/
        └── service/         # Unit and integration test suites
