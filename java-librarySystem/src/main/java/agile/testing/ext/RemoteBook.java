package agile.testing.ext;

import java.time.LocalDate;
import java.util.List;

/**
 * @author zen
 * @since 2019/04/14
 */
public class RemoteBook {
    private String locateLibrary;
    private String name;
    private List<String> authors;
    private LocalDate publishedDate;

    public RemoteBook(String name,
                      List<String> authors,
                      LocalDate publishedDate) {
        this.name = name;
        this.authors = authors;
        this.publishedDate = publishedDate;
    }

    public String getLocateLibrary() {
        return locateLibrary;
    }

    public void setLocateLibrary(String locateLibrary) {
        this.locateLibrary = locateLibrary;
    }

    public String getName() {
        return name;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    @Override
    public String toString() {
        return "RemoteBook{" + "locateLibrary='" + locateLibrary + '\'' + ", name='" + name + '\'' + ", authors="
                + authors + ", publishedDate=" + publishedDate + '}';
    }
}
