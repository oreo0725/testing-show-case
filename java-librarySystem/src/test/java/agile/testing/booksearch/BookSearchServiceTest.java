package agile.testing.booksearch;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
public class BookSearchServiceTest {

    private BookSearchService bookSearchService;

    @Before
    public void setUp() throws Exception {
        bookSearchService = new BookSearchService();
    }

    @Test
    public void test_getBookCount() throws Exception {

        assertThat(bookSearchService.getBookCount()).isEqualTo(0);
    }

}
