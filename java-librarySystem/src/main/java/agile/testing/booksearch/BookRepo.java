package agile.testing.booksearch;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zen
 * @since 2019/04/26
 */
public interface BookRepo extends JpaRepository<Book, Integer> {

    Book findByIsbn(String isbn);
}
