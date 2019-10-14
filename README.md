# spring-boot-task
Tasks to be Done Post Demo

Master
Complete all the endpoints for CRUD operations on Muzix

view-data
Use h2-console to view in-memory data

query-annotation
Add an endpoint to search trackByName. Understand @Query and parameter passing to @Query

swagger-2
Generate API documentation using Swagger 2

exception-handling
Create custom exceptions TrackNotFoundException, TrackAlreadyExistsException in a com.stack....exceptions package. Perform appropriate exception handling and propagation back.

seed-data
Running Logic on Startup in Spring. Create seed data to pre-fill the database with movie information whenever the application starts. Use both approaches: Approach 1: ApplicationListener Approach 2: CommandLineRunner (Find out how it differs from ApplicationRunner)

global-error
Global exception using Controller advice 

application.properties
Remove all hardcoded data from the application code to application.properties a) by using @Value. b) by using @PropertySource c) by using Environment d) by using @ConfigurationProperties (https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/core/env/ Environment.html) 

Lombok
Add @Lombok (https://drive.google.com/file/d/1QQpEQZbDD9pmW2qrhYsx5N9XYQ5bJ5dM/view) 

dummy-service
Create another service implementation TrackDummyServiceImpl. Use @Primary and @Qualifier annotations to specify which implementation to use.

profile
Use @Profile to run the application with the existing service implementation, and the new TrackDummyServiceImpl implementation.

mysql
Swap in-memory H2 database with MySQL.

mysql
Create two additional properties file application-dev.properties that contains configuration for H2 and application-prod.properties that contains configurations for MySQL.

spring-developer-tool
Use spring developer tool and verify that changes are getting reflected without the need of restarting the server

actuator
Use spring boot actuator to collect metrics for your service endpoints


LATEST CODE IN spring-developer-tool
