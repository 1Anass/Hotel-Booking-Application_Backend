# Hotel-Booking-Application_Backend 


<h3> Table of Contents: </h3>

<h4> 1.	Entity-relationship Diagram </h4>
<h4> 2.	Data Repositories </h4>
<h4> 3.	Business Services </h4>
<h4> 4.	REST Controllers </h4>
<h4> 5.	Security and Authentication </h4>
<h4> 6.	Technology Enablers </h4>
<h4>  6.1.	 Spring Boot </h4>
<h4>  6.2.	 Hibernate </h4>
<h4>  6.3.	 Postgres </h4>
<h4>  6.4.	 Redis </h4>
<h4>  6.5.	Spring-data </h4>
<h4>  6.6.	Spring-security </h4>
<h4>  6.7.	 REST and HTTP </h4>

<h3> 1.	Entity-relationship Diagram </h3>
The following figure represents the entity-relation diagram. It contains all entities that the context of the application requires. These entities have a common set of attributes and methods. Therefore, we create a Base Entity that will encapsulate these common properties and methods within one class, and other entities will extend it. 

 This picture shows the ERD adopted <a href="https://github.com/1Anass/Hotel-Booking-Application_Backend/blob/main/ERD.png" > Figure 1: ERD </a>.

Once the entities are created, we create a database in Postgres DBMS. Then we use Hibernate (ORM framework) to create the tables that correspond to entities at runtime. The relations are implemented at runtime. This is thanks to JPA annotations that allow Hibernate to understand the structure of the database and the relation between tables. To populate the database, we add an SQL file called Data.sql under the folder resources that will be run against our database at runtime after the tables creation. 

<h3> 2.	Data Repositories </h3>

For simple data operations that our application will provide, we use data repositories. Data repositories extend the base repository that extends CRUD repository. Therefore, all repositories will have CRUD functions implemented by default at runtime. To add customized data operations, we can add functions prototypes along with the corresponding queries. Spring-data project under Spring framework allows the generation of these data operations implementation at runtime. To make Spring Boot directly expose data repositories through HTTP methods, we use the annotation @RepositoryRestSource. 
 
The following picture shows the repositories used by each service <a href="https://github.com/1Anass/Hotel-Booking-Application_Backend/blob/main/Repositories%26Services.png"> Figure 2: Repositories and Services</a>.

<h3> 3.	Business Services </h3>

The business services represent the business logic and get invoked by the web services. The server contains 4 business services:
-	User Service: this service allows creating a user with a corresponding role. Also it allows updating the user’s credentials.
-	StayPlan Service: this service allows saving temporarily a set of rooms that the user wishes to reserve in the future. The user can add, remove and update the content of the stay plan.
-	Reservation Service: the service allows the user to reserve a room within a period of time and do the checkout to complete the reservation. The status of the reservation can also be updated
-	Price Suggestion Service: this service allows the hotel provider to get a suggestion for the price of his hotel’s rooms based on other si ilar rooms on similar hotels.

<h3> 4.	REST Controllers </h3>

The REST controllers are web services that represent the non-functional aspect of the application. They get invoked by Spring Boot application server when a request is received. On their turn, they invoke the corresponding business service. There is a one-to-one mapping between the REST controllers and the business services, and hence there are 4 REST controllers.

<h3> 5.	Security and Authentication </h3>

For this app, we opted for JWT authentication. When a user first logs in, a JSON web token is sent to the user. The token is digitally signed. Whenever, the user sends a request to the server, an intercepting filter intercepts the request, parse the JSON web token to know the user and its role, and allow him only the functionality that his role gives. A security configurer is added to configure the access to multiple services of the backend depending on the type of request and the user’s role.

<h3> 6.	Technology Enablers </h3>

<h4> 6.1.Spring Boot </h4>

It is a framework that eases software production. It is built on top of Spring framework. It makes software development easier thanks to dependency injection, auto-configuration, and its projects like Spring-data and Spring-security. In the context of this application, Spring Boot is the application server that will receive requests and invoke the corresponding web services. 

<h4> 6.2. Hibernate </h4>

Hibernate is an ORM framework. It follows the specification of JPA annotations and creates the tables and their relations at runtime. Hibernate along with JPA allow the object relational mapping between entities and tables in database. 

<h4> 6.3. PostgreSQL </h4>

PostgreSQL is the DBMS that I opted for in this application, because it is powerful in relational database management. 

<h4> 6.4. Redis </h4>

Redis is an in-memory database that will be used for caching. It is used because some data only needs to be stored temporarily.

<h4> 6.5. REST and HTTP </h4>

The backend of the app was designed following REST architecture style. Web services are Restful and both data and functionality are considered resources. For each functionality/resource we attach a corresponding URI using Spring-web annotations like @GetMapping and @PostMapping. This way, we are exposing all our app functionaliyt/resources through HTTP methods.

     

