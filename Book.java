//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler
import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return this.publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String toString() {
        return "Book{title='" + this.title + "', author='" + this.author + "', publicationYear=" + this.publicationYear + "}";
    }
}
