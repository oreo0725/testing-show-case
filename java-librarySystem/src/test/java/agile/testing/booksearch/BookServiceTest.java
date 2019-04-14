package agile.testing.booksearch;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

/**
 *
 */
public class BookServiceTest {

    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        bookService = new BookService();
    }

    @Test
    public void test_getBookCount() throws Exception {

        assertThat(bookService.getBookCount()).isEqualTo(0);
    }

    /**
     * NG test function format
     * @throws Exception
     */
    @Test
    public void testGetBookCount() throws Exception {
        Book book = new Book("Book1", "Peter");
        bookService.add(book);

        // GIVEN
        assertThat(bookService.getBookCount()).isEqualTo(1);

        Book book2 = new Book("Book1", "Peter");

        try{

            bookService.add(book2);

            fail("Should not be here");
        }
        catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(IllegalArgumentException.class);
        }

    }

    @Test
    public void testAdd() throws Exception {
        Book book = new Book("Book1", "Peter");
        bookService.add(book);

        assertThat(book.getIndexDateTime()).isEqualTo(LocalDateTime.now());
    }

}
