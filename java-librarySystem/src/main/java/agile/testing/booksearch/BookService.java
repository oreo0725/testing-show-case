package agile.testing.booksearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zen
 * @since 2019/04/14
 */
public class BookService {

    private List<Book> bookList = new ArrayList<>();

    public int getBookCount() {
        return bookList.size();
    }

    public void add(Book book) {
        bookList.forEach(b -> {
            if (b.getTitle()
                 .equals(book.getTitle())) {
                throw new IllegalArgumentException("There is already a book named " + book.getTitle());
            }
        });

        bookList.add(book);
    }
}
