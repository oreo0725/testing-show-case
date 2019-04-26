package agile.testing.booksearch;

import agile.testing.utils.TimeMachine;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zen
 * @since 2019/04/14
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private LocalDate publishedDate;
    private String isbn;
    private LocalDateTime indexDateTime = TimeMachine.now();

    public Book() {
    }

    public Book(String title,
                String author) {
        this.title = title;
        this.author = author;
    }

    @Transient
    public String getDisplayName() {
        String display = getTitle();
        if (this.getAuthor() != null) {
            display += " - " + getAuthor();
        }
        display += String.format(" [%s]",
                                 this.getPublishedDate() != null ?
                                         publishedDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) :
                                         "unknown published date");
        return display.toUpperCase();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
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

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getIndexDateTime() {
        return indexDateTime;
    }

    public void setIndexDateTime(LocalDateTime indexDateTime) {
        this.indexDateTime = indexDateTime;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + ", publishedDate="
                + publishedDate + ", isbn='" + isbn + '\'' + ", indexDateTime=" + indexDateTime + '}';
    }
}
