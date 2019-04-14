package agile.testing.booksearch;

import java.time.LocalDate;

/**
 * @author zen
 * @since 2019/04/14
 */
public class Book {

    private String title;
    private String author;
    private LocalDate releaseDate;
    private String isbn;

    public Book(String title,
                String author) {
        this.title = title;
        this.author = author;
    }

    public String getDisplayName() {
        if (this.getAuthor() != null) {
            return String.format("%s - %s", getTitle(), getAuthor());
        }
        return getTitle();
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + ", releaseDate=" + releaseDate
                + ", isbn='" + isbn + '\'' + '}';
    }
}
