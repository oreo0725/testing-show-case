package agile.testing.booksearch;

import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author zen
 * @since 2019/04/14
 */
public class BookTest {

    /**
     * bad format test
     *
     * @throws Exception
     */
    @Test
    public void test_getDisplayName() throws Exception {
        Book book = new Book("Agile Testing", "Lisa Crispin");
        book.setPublishedDate(LocalDate.of(2008, 1, 1));
        assertThat(book.getDisplayName()).isEqualTo("AGILE TESTING - LISA CRISPIN [2008/01/01]");

        Book book2 = new Book("元智大學Agile課", null);
        assertThat(book2.getDisplayName()).isEqualTo("元智大學AGILE課 [UNKNOWN PUBLISHED DATE]");

    }

}
