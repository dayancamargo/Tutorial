This project will show a simple spring boot application. It will start a H2 database and make available some services to see and manipulate this data, as well some examples how to implementations.

Pre-requisites:
    * jdk1.8
    * Maven

How to test:
    * Use swagger
        or
    * Import Tutorial.postman.json in postman aplication.

Some endpoints useful:
    * http://localhost:8099/swagger-ui.html
        this will show all endpoints.
        
    * http://localhost:8099/h2
        H2 console (JDBC url: jdbc:h2:mem:testdb    user:sa     pass: '' )
        
    * http://localhost:8098/health
    
    * http://localhost:8098/mappings
    
    * http://localhost:8098/beans
        These will show some information about service.
            
Useful Links:
    * How to start a project: https://start.spring.io/
                              https://github.com/spring-io/initializr/
                              
    * Spring boot: https://docs.spring.io/spring-boot/docs/current/reference/html/
    
    * H2 Data base: http://www.h2database.com/html/main.html
    
    * Logback : http://www.h2database.com/html/main.html
    
    * Spring data: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
                   https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-creating-database-queries-from-method-names/
                   
    * HttpStatus: https://en.wikipedia.org/wiki/List_of_HTTP_status_codes
    
    * Json: https://www.w3schools.com/js/js_json_intro.asp
    
    * Error Handling: https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
    
    * Maven: https://maven.apache.org/
             https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
             
    * Swagger: https://swagger.io/
               http://blog.caelum.com.br/documentando-uma-api-jax-rs-com-swagger/ (PT)
               http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api (EN)