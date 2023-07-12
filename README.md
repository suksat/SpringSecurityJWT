# Spring Security Application

This is a Spring Security application that demonstrates user authentication using JSON Web Tokens (JWT). The application provides an authentication endpoint to generate JWT tokens and secures other endpoints using Spring Security.

## Prerequisites

- IntelliJ IDEA 2023.1.3 (Community Edition) or compatible IDE
- Java version 1.8.0_361 or compatible JDK
- Jakarta Servlet API 5.0.0

## Built With

- Java version 1.8.0_361

## Author

Sukumar Satyen © July 2023

## Dependencies

The project includes the following dependencies:

- Jakarta Servlet API 5.0.0
- Spring Boot 2.7.13
- Spring Security 5.3.28
- Spring Web 5.3.28
- Spring Security JWT 1.1.0
- BCryptPasswordEncoder

### Packaging and Deployment

- To package the application as a WAR file and deploy it on Apache Tomcat:
    1. Update the `packaging` element in the `pom.xml` file to `<packaging>war</packaging>`.
    2. Build the project using Maven: `mvn clean package`.
    3. Copy the generated WAR file to the Tomcat webapps directory.
    4. Start the Tomcat server, and the application will be deployed automatically.

- To package the application as a JAR file and deploy it on AWS Elastic Beanstalk:
    1. Update the `packaging` element in the `pom.xml` file to `<packaging>jar</packaging>`.
    2. Build the project using Maven: `mvn clean package`.
    3. Create an AWS Elastic Beanstalk environment and upload the generated JAR file.
    4. Deploy the application on the Elastic Beanstalk environment.


### Testing the Application

1. Clone the repository to your local machine.
2. Open the project in IntelliJ IDEA or compatible IDE.
3. Configure the project dependencies in the `pom.xml` file. Make sure you have the required dependencies and their correct versions.
4. Build the project using Maven: `mvn clean install`.
5. To run the application:
    - On Linux or Windows command prompt: `java -jar target/application.jar`.
    - In IntelliJ IDEA, right-click on the `Application` class and select "Run".
6. The application will start and listen on the specified port (usually 8080).
7. You can use a tool like Postman to test the application. Here's how you can test the endpoints:
8. Make a POST request to `http://localhost:8080/authenticate` with the following JSON payload:


    {
    "username": "admin",
    "password": "admin@123"
    }
9. This will return a JWT token.
10.  Include the JWT token in the request header as `Authorization: Bearer <token>` for the secured endpoints.
11. Access Secured Endpoint:
- **Method**: GET 
- **Endpoint**: Example secured endpoint: `http://localhost:8080/api/secure`
- **Headers**:
    - `Authorization`: `Bearer <JWT Token>`
- This request will access the secured endpoint using the JWT token for authentication.
- To validate the username and password in the provided code, follow these steps:
    1. Open Postman and create a new request.
    2. Set the request method to GET.
    3. Set the request URL to the secured endpoint: `http://localhost:8080/api/secure`.
    4. Add the Authorization header:
        - Key: `Authorization`
        - Value: `Bearer <JWT Token>`
        - Replace `<JWT Token>` with the actual JWT token obtained from the authentication request.
    5. Send the request.
    6. The application will validate the provided JWT token and check if the user is authenticated and authorized to access the secured endpoint.
    7. If the username and password match, the user is authenticated and the response from the secured endpoint will be returned.
    8. If the username and password don't match or the user is not found, the authentication will fail, and an appropriate error response will be returned.

Note: For endpoints that require additional parameters or request bodies, provide them accordingly in the request.

## Class Descriptions

- `Application`: The main class that starts the Spring Boot application.
- `WebSecurityConfig`: Configuration class that extends `WebSecurityConfigurerAdapter` and sets up Spring Security configurations.
- `JwtRequestFilter`: A filter that intercepts incoming requests and validates JWT tokens.
- `MyUserDetailsService`: A custom implementation of Spring Security's `UserDetailsService` for retrieving user details.
- `MyUserDetails`: A custom implementation of Spring Security's `UserDetails` representing user details.
- `AuthenticationRequest`: A DTO class representing the authentication request payload.
- `AuthenticationResponse`: A DTO class representing the authentication response payload.
- `HelloRestController`: A REST controller that provides an authentication endpoint and generates JWT tokens.
- `ApplicationTests`: Unit tests for the Spring Security application.

## Code Flow

1. When the application starts, the `Application` class is executed, which runs the Spring Boot application.
2. The `WebSecurityConfig` class sets up the Spring Security configurations, including the authentication manager, authentication endpoint, and JWT filter.
3. The `JwtRequestFilter` intercepts incoming requests and validates the JWT tokens by checking the authentication details.
4. The `MyUserDetailsService` class implements the `UserDetailsService` to retrieve user details, such as username and password, for authentication.
5. The `AuthenticationRequest` class represents the payload for authentication requests, including the username and password.
6. The `AuthenticationResponse` class represents the payload for authentication responses, including the JWT token.
7. The `HelloRestController` class is a REST controller that provides the authentication endpoint to generate JWT tokens.
8. The `ApplicationTests` class contains unit tests to verify the application context and perform assertions on the Spring Security configurations.

