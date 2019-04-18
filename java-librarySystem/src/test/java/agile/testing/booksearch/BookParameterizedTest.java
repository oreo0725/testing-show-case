package agile.testing.booksearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author zen
 * @since 2019/04/14
 */
@RunWith(Parameterized.class)
public class BookParameterizedTest {

    @Parameterized.Parameters(name = "{index}: bookName[{0}], author[{1}], publishedDate[{2}] => \"{3}\"")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{"A book on C", "Kelley", LocalDate.of(1984, 12, 1), "A BOOK ON C - KELLEY [1984/12/01]"},
                                             {"Agile Testing", "Lisa Crispin", LocalDate.of(2008, 1, 1), "AGILE TESTING - LISA CRISPIN [2008/01/01]"},
                                             {"失傳絕學", null, null, "失傳絕學 [UNKNOWN PUBLISHED DATE]"},
                                             {"元智大學Agile課", null, LocalDate.of(2019, 4, 20), "元智大學AGILE課 [2019/04/20]"}});
    }

    private String bookName;
    private String authorName;
    private LocalDate publishedDate;
    private String displayName;

    public BookParameterizedTest(String bookName,
                                 String authorName,
                                 LocalDate publishedDate,
                                 String displayName) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishedDate = publishedDate;
        this.displayName = displayName;
    }


    @Test
    public void test_getDisplayName() throws Exception {
        Book book = new Book(bookName, authorName);
        book.setPublishedDate(publishedDate);
        assertThat(book.getDisplayName()).isEqualTo(displayName);
    }
}
