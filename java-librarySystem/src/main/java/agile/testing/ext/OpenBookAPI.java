package agile.testing.ext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 3rd Party API
 * @author zen
 * @since 2019/04/14
 */
public class OpenBookAPI {

    private final static List<RemoteBook> books = Arrays.asList(new RemoteBook("Java Performance tuning",
                                                                               Arrays.asList("AAA", "James"),
                                                                               LocalDate.of(2001, 1, 1)),
                                                                new RemoteBook("Java Performance tuning 2nd edition",
                                                                               Arrays.asList("AAA", "James"),
                                                                               LocalDate.of(2002, 1, 1)),
                                                                new RemoteBook("C Performance tuning",
                                                                               Arrays.asList("BBB", "James"),
                                                                               LocalDate.of(1998, 2, 1)),
                                                                new RemoteBook("C Performance tuning 2nd edition",
                                                                               Arrays.asList("BBB", "James"),
                                                                               LocalDate.of(1999, 2, 1)),
                                                                new RemoteBook("C Performance tuning 3rd edition",
                                                                               Arrays.asList("BBB", "James", "May"),
                                                                               LocalDate.of(2000, 2, 1)),
                                                                new RemoteBook("C++ Primer",
                                                                               Arrays.asList("KK", "GG"),
                                                                               LocalDate.of(2003, 2, 1)),
                                                                new RemoteBook("Nodejs Performance tuning",
                                                                               Arrays.asList("CCC", "James"),
                                                                               LocalDate.of(2011, 1, 1)));

    /**
     * FIXME fake Data, should query from DB
     *
     * @param name
     * @return
     */
    public List<RemoteBook> searchBooksByName(String name) {
        return books.stream()
                    .filter(book -> book.getName()
                                        .toLowerCase()
                                        .contains(name.toLowerCase()))
                    .collect(Collectors.toList());
    }

    /**
     * FIXME fake Data, should query from DB
     *
     * @param author
     * @return
     */
    public List<RemoteBook> searchBooksByAuthor(String author) {
        return books.stream()
                    .filter(book -> book.getAuthors()
                                        .contains(author))
                    .collect(Collectors.toList());
    }

}
