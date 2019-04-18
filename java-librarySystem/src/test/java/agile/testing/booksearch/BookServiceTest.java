package agile.testing.booksearch;

import agile.testing.ext.OpenBookAPI;
import agile.testing.ext.RemoteBook;
import agile.testing.utils.TimeMachineUtils;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.BDDMockito.given;

/**
 *
 */
public class BookServiceTest {

    private BookService bookService;

    private OpenBookAPI openBookAPI = Mockito.mock(OpenBookAPI.class);

    @Before
    public void setUp() throws Exception {
        bookService = new BookService(openBookAPI);
    }

    @Test
    public void test_getBookCount() throws Exception {

        assertThat(bookService.getBookCount()).isEqualTo(0);
    }

    /**
     * NG test function format
     *
     * @throws Exception
     */
    @Test
    public void testGetBookCount() throws Exception {
        Book book = new Book("Book1", "Peter");
        bookService.add(book);

        // GIVEN
        assertThat(bookService.getBookCount()).isEqualTo(1);

        Book book2 = new Book("Book1", "Peter");

        try {

            bookService.add(book2);

            fail("Should not be here");
        } catch (Exception e) {
            assertThat(e).isExactlyInstanceOf(IllegalArgumentException.class);
        }

    }

    @Test
    public void testAdd() throws Exception {
        LocalDateTime nowTime = LocalDateTime.of(2019, 4, 13, 11, 59, 41);
        TimeMachineUtils.useFixedClockAt(nowTime);

        Book book = new Book("Book1", "Peter");
        bookService.add(book);

        assertThat(book.getIndexDateTime()).isEqualTo(nowTime);
    }

    /**
     * NG test function structure
     *
     * @throws Exception
     */
    @Test
    public void testFindRemoteBooksByName() throws Exception {

        List<RemoteBook> books = Arrays.asList(new RemoteBook("Java Performance tuning",
                                                              Arrays.asList("AAA", "James"),
                                                              LocalDate.of(2001, 1, 1)),
                                               new RemoteBook("Java Performance tuning 2nd edition",
                                                              Arrays.asList("AAA", "James"),
                                                              LocalDate.of(1992, 1, 1)));
        //mock openBookAPI to return fake data
        given(openBookAPI.searchBooksByName("Java")).willReturn(books);

        List<RemoteBook> searchResult = bookService.findRemoteBooksByName("Java");
        System.out.println(searchResult);
        assertThat(searchResult).hasSize(1);

    }

}
