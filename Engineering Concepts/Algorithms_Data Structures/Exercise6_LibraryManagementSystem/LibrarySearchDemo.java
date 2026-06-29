import java.util.Arrays;
import java.util.Comparator;

public class LibrarySearchDemo {
    public static Book linearSearchByTitle(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearchByTitle(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid];
            }

            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(501, "Clean Code", "Robert C. Martin"),
                new Book(502, "Effective Java", "Joshua Bloch"),
                new Book(503, "Data Structures", "Seymour Lipschutz"),
                new Book(504, "Java Complete Reference", "Herbert Schildt")
        };

        System.out.println("Linear search for Effective Java:");
        System.out.println(linearSearchByTitle(books, "Effective Java"));

        Arrays.sort(books, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));

        System.out.println("\nBinary search for Effective Java after sorting by title:");
        System.out.println(binarySearchByTitle(books, "Effective Java"));
    }
}
