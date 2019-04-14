package agile.testing.booksearch;

import org.junit.Test;

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
        assertThat(book.getDisplayName()).isEqualTo("Agile Testing - Lisa Crispin");

        Book book2 = new Book("元智大學Agile課", null);
        assertThat(book2.getDisplayName()).isEqualTo("元智大學Agile課");

    }

}
