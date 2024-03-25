# TG Project Management System

The TG Project Management System is a comprehensive backend solution designed for managing projects and employee interactions within an organization. This system simplifies project tracking, department management, and employee operations with a focus on scalability and security.

## Architecture & Technologies

The system is built on a robust architecture leveraging the following key technologies:

- **Spring Boot**: Simplifies the development of new Spring applications with convention over configuration, enabling rapid deployment and development.
- **Spring Security**: Provides comprehensive security services for Java applications, in this case, utilized for authentication and authorization.
- **MyBatis**: Serves as the persistence layer, allowing for the mapping of objects to database operations, simplifying the implementation of CRUD functionalities.
- **PostgreSQL**: Chosen for its advanced features, reliability, and compatibility with complex data operations, acting as the primary database.
- **Maven**: Manages dependencies and streamlines build processes, ensuring that the application remains easy to update and maintain.
- **SSM Framework**: A combination of Spring, Spring MVC, and MyBatis, creating a powerful trio for web application development.
- **JWT (JSON Web Tokens)**: Facilitates secure transmission of information between parties as a JSON object, used here for managing user authentication tokens.
- **MD5**: Utilized for hashing sensitive information, ensuring data integrity and security.

## Implemented Features

The TG Project Management System includes a wide array of features designed to streamline project and employee management:

- **Project Management**:
  - Comprehensive CRUD operations for projects, allowing for the creation, retrieval, updating, and deletion of project information.
  - Pagination support for project queries, facilitating efficient data retrieval in scenarios with large datasets.

- **Employee Management**:
  - Full suite of CRUD functionalities for managing employee records, encompassing additions, updates, and deletions.
  
- **Authentication**:
  - Secure employee login and logout mechanisms, employing a combination of token-based authentication, MD5 hashing for passwords, and JWT for session management.
  
- **Database Design**:
  - The majority of the database utilizes integer types for data storage, designed to facilitate the future implementation of dictionary mapping. This approach aims to optimize data retrieval and manipulation by using integer references for various entities such as departments, project categories, and employee roles (Dictionary mapping not yet implemented).

To get the project up and running on your local machine for development and testing purposes, follow these steps:

1. Clone the repository to your local machine.
2. Ensure that Maven and JDK 17 are installed.
3. Set up your PostgreSQL database and update the `application.yml` file with your database credentials.
4. Build the project with Maven: `mvn clean install`.

- **Attachement**:
  - **Database Design**:
    - ![image](https://github.com/Jacooooooob/tg-initiate-project/assets/96058597/e1ce1116-c309-44e8-8211-84cd2d06f2bf)
    - ![image](https://github.com/Jacooooooob/tg-initiate-project/assets/96058597/b0c2aded-e4aa-4d29-b6a7-1a201304574a)
  - **Swagger**:
    - ![5a43c762306d4ce726aab3366239943](https://github.com/Jacooooooob/tg-initiate-project/assets/96058597/02826a13-e7ee-4a15-939d-6ffab97624b8)
    - ![f863fafebe7a6eddfd5f55beac9ad05](https://github.com/Jacooooooob/tg-initiate-project/assets/96058597/30c5b37b-272f-45e1-9d8b-32e65496f9cd)



