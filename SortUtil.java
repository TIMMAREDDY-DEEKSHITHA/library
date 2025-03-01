//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtil {
    public SortUtil() {
    }

    public static void bubbleSort(List<Book> books, Comparator<Book> comparator) {
        int n = books.size();

        for(int i = 0; i < n - 1; ++i) {
            for(int j = 0; j < n - i - 1; ++j) {
                if (comparator.compare((Book)books.get(j), (Book)books.get(j + 1)) > 0) {
                    Collections.swap(books, j, j + 1);
                }
            }
        }

    }

    public static void insertionSort(List<Book> books, Comparator<Book> comparator) {
        for(int i = 1; i < books.size(); ++i) {
            Book key = (Book)books.get(i);

            int j;
            for(j = i - 1; j >= 0 && comparator.compare((Book)books.get(j), key) > 0; --j) {
                books.set(j + 1, (Book)books.get(j));
            }

            books.set(j + 1, key);
        }

    }

    public static void quickSort(List<Book> books, Comparator<Book> comparator, int low, int high) {
        if (low < high) {
            int pi = partition(books, comparator, low, high);
            quickSort(books, comparator, low, pi - 1);
            quickSort(books, comparator, pi + 1, high);
        }

    }

    private static int partition(List<Book> books, Comparator<Book> comparator, int low, int high) {
        Book pivot = (Book)books.get(high);
        int i = low - 1;

        for(int j = low; j < high; ++j) {
            if (comparator.compare((Book)books.get(j), pivot) <= 0) {
                ++i;
                Collections.swap(books, i, j);
            }
        }

        Collections.swap(books, i + 1, high);
        return i + 1;
    }
}
