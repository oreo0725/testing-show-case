# Book management service

This is a demo project for using junit and mockito.
Project is build with [Springboot](https://spring.io/projects/spring-boot) and [H2](https://stackabuse.com/integrating-h2-database-with-spring-boot/) embed Database

java project env:
- gradle
- springboot + h2

Suggest use [Intellij](https://www.jetbrains.com/idea/) as your IDE

### Files
src
- booksearch/Book.java - Book entity class
- booksearch/BookRepo.java - A DAO class for Book entity
- booksearch/BookService.java - Provide service function of Book such as *find*, *add*
- ext/OpenBookAPI.java - fake external API component
- utils/TimeMachine.java - A wrapper to use static function related to time.
- SpringBoot2JdbcWithH2Application.java - A bootstrap application class to start the H2 database service

test
- booksearch/BookParameterizedTest.java - unit test for Book.java (better pattern)
- booksearch/BookTest.java - unit test for Book.java (not-good pattern)
- booksearch/BookServiceTest.java - unit test for BookServiceTest.java
- BookRepoIntegrationTest.java - An integration test for BookRepo.java

## How to run

### Tests:

In Intellij, right click on the *test file* > Run

### Database bootstrap application:

On `SpringBoot2JdbcWithH2Application.java`, right on the main function and run.