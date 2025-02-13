//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private UserInteractionLogger logger = new UserInteractionLogger();
    private LibrarySerializer serializer = new LibrarySerializer();

    public LibraryMenu(Library library) {
        this.library = library;
        List<Book> books = this.serializer.loadLibrary("resources/data/library.ser");
        if (books != null) {
            library.setBooks(books);
            System.out.println("Library loaded successfully.");
        } else {
            System.out.println("No saved library found. Loading default books.");
            library.loadBooks("resources/data/books.txt");
        }

    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\n=== Main Menu ===\n");
            System.out.println("1. View All Books");
            System.out.println("2. Sort Books by Title");
            System.out.println("3. Sort Books by Author");
            System.out.println("4. Sort Books by Year");
            System.out.println("5. Search for a Book by Title");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    this.library.viewAllBooks();
                    this.logger.logViewAllBooks();
                    break;
                case 2:
                    SortUtil.bubbleSort(this.library.getBooks(), Comparator.comparing(Book::getTitle));
                    System.out.println("Books sorted by title:");
                    this.library.viewAllBooks();
                    this.logger.logSort("title");
                    break;
                case 3:
                    SortUtil.insertionSort(this.library.getBooks(), Comparator.comparing(Book::getAuthor));
                    System.out.println("Books sorted by author:");
                    this.library.viewAllBooks();
                    this.logger.logSort("author");
                    break;
                case 4:
                    SortUtil.quickSort(this.library.getBooks(), Comparator.comparingInt(Book::getPublicationYear), 0, this.library.getBooks().size() - 1);
                    System.out.println("Books sorted by year:");
                    this.library.viewAllBooks();
                    this.logger.logSort("year");
                    break;
                case 5:
                    System.out.print("Enter a key word of the book (e.g., title or author name");
                    String title = scanner.nextLine();
                    Book foundBook = this.library.searchBookByKeyword(title);
                    if (foundBook != null) {
                        System.out.println("Book found: " + String.valueOf(foundBook));
                        this.logger.logSearch(title);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    this.serializer.saveLibrary(this.library.getBooks(), "resources/data/library.ser");
                    System.out.println("Library saved successfully. Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
