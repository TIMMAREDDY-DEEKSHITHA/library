//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList();

    public Library() {
    }

    public void loadBooks(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String line;
            try {
                while((line = br.readLine()) != null) {
                    String[] details = line.split(",");
                    Book book = new Book(details[0], details[1], Integer.parseInt(details[2]));
                    this.books.add(book);
                }
            } catch (Throwable var7) {
                try {
                    br.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            br.close();
        } catch (IOException var8) {
            IOException e = var8;
            e.printStackTrace();
        }

    }

    public void viewAllBooks() {
        Iterator var1 = this.books.iterator();

        while(var1.hasNext()) {
            Book book = (Book)var1.next();
            System.out.println(book);
        }

    }

    public Book searchBookByKeyword(String keyword) {
        keyword = keyword.toLowerCase();
        Iterator var2 = this.books.iterator();

        Book book;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            book = (Book)var2.next();
        } while(!book.getTitle().toLowerCase().contains(keyword) && !book.getAuthor().toLowerCase().contains(keyword) && !String.valueOf(book.getPublicationYear()).equals(keyword));

        return book;
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
