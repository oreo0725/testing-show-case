package agile.testing;

import agile.testing.booksearch.Book;
import agile.testing.booksearch.BookRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author zen
 * @since 2019/04/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookRepoIntegrationTest {

    @Autowired
    private BookRepo bookRepo;

    @Test
    public void test_findByIsbn() throws Exception {
        // GIVEN 
        
        // WHEN 
        Book b = bookRepo.findByIsbn("xxxx-yyyy-1");

        // THEN
        assertThat(b.getTitle()).isEqualTo("Agile Testing");
        
    }

}