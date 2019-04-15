package agile.testing.booksearch;

import agile.testing.ext.OpenBookAPI;
import agile.testing.ext.RemoteBook;
import agile.testing.utils.TimeMachine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        int existBookId = findExistedBook(book);
        if (existBookId >= 0) {
            throw new IllegalArgumentException(
                    "There is already a book named " + book.getTitle() + " [id:" + existBookId + "]");
        }
        bookList.add(book);
        book.setIndexDateTime(TimeMachine.now());
    }

    public List<RemoteBook> findRemoteBooksByName(String bookName) {
        OpenBookAPI openBookAPI = new OpenBookAPI();
        return openBookAPI.searchBooksByName(bookName)
                          .stream()
                          .filter(book -> book.getPublishedDate()
                                              .isAfter(LocalDate.of(1999, 12, 31)))
                          .collect(Collectors.toList());
    }

    private int findExistedBook(Book book) {
        int existBookId = -1;
        for (int i = 0, n = bookList.size(); i < n; i++) {
            Book b = bookList.get(i);
            if (b.getTitle()
                 .equals(book.getTitle())) {
                existBookId = i;
                break;
            }
        }
        return existBookId;
    }

    public static void main(String[] args) {
        BookService bookService = new BookService();
        System.out.println(bookService.getBookCount());

        Book book = new Book("文思不藏私", "Vince");

        bookService.add(book);
        System.out.println(bookService.getBookCount());
    }

}
