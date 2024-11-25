# UCUPostIt Backend

## Requisitos Previos

- **Java 17** 
- **Maven 3.8+** 
- **MySQL**
- **

---

## Dependencias del Proyecto

### Spring Boot
1. **Spring Boot Starter Data JPA**  
   - Para el manejo de operaciones con bases de datos mediante JPA (Java Persistence API), que a su vez se basa en un ORM (Object-Relational Mapping) Hibernate, que se encarga de mapear los objetos Java a las tablas de la base de datos, facilitando la manipulacion de los datos, sin tener que escribir SQL. 
   - Documentación: [Spring Data JPA](https://spring.io/projects/spring-data-jpa)

2. **Spring Boot Starter Web**  
   - **Artifact**: `spring-boot-starter-web`  
   - Configuración base para crear aplicaciones web RESTful.  
   - Documentación: [Spring Web](https://spring.io/projects/spring-boot)

3. **Spring Boot Starter Test**  
   - **Artifact**: `spring-boot-starter-test`  
   - Herramientas para escribir y ejecutar pruebas unitarias y de integración.  
   - Documentación: [Spring Testing](https://spring.io/guides/gs/testing-web/)

### MySQL
4. **MySQL Connector**  
   - **Artifact**: `mysql-connector-j`  
   - Controlador JDBC para conectarse a bases de datos MySQL.  
   - Documentación: [MySQL Connector/J](https://dev.mysql.com/doc/connector-j/)

### MapStruct
5. **MapStruct**  
   - **Artifact**: `mapstruct` y `mapstruct-processor`  
   - **Versión**: `1.5.3.Final`  
   - Herramienta para generar automáticamente mapeadores entre las Entidades y los DTOs.  
   - Documentación: [MapStruct](https://mapstruct.org/)

--- 

### Arquitectura  
**API Restful**  
- Recibe solicitudes HTTP como **GET**, **POST**, **PUT** y **DELETE**, y devuelve las respuestas correspondientes.  
- En las respuestas, incluye códigos de estado HTTP (por ejemplo, **200 OK** si está todo bien, **404 Not Found** si no se encuentra el recurso).  
- Además de los códigos de estado, la respuesta puede contener valores simples como **booleanos** o **números**. En algunos casos, cuando es necesario, también puede devolver un **body** con los datos solicitados en formato **JSON**.
 

