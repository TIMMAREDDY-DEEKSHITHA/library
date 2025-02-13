//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.List;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Library library = new Library();
        LibrarySerializer serializer = new LibrarySerializer();
        List<Book> books = serializer.loadLibrary("resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
        } else {
            System.out.println("Loading data from books.txt...");
        }

        LibraryMenu menu = new LibraryMenu(library);
        menu.displayMenu();
    }
}
