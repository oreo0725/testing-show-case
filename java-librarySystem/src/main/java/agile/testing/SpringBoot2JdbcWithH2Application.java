package agile.testing;

import agile.testing.booksearch.BookRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zen
 * @since 2019/04/26
 */
@SpringBootApplication
public class SpringBoot2JdbcWithH2Application implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookRepo bookRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2JdbcWithH2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Book book = new Book("Agile Testing", "Lisa Crispin");
//        book.setPublishedDate(LocalDate.of(2008, 1, 1));
//
//        Book book2 = new Book("元智大學Agile課", null);
//
//        logger.info("Insert books -> {}", bookRepo.saveAll(Arrays.asList(book, book2)));

        logger.info("All books -> {}", bookRepo.findAll());

        logger.info("*********************");
        logger.info("*** http://localhost:8080/h2-console ");
        logger.info("*********************");
    }
}