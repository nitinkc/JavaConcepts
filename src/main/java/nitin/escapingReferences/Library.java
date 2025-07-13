package nitin.escapingReferences;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Book> books;

    public Library() {
        this.books = new HashMap<>();
    }

    public void addBook(String bookId, Book book) {
        books.put(bookId, book);
    }

    // Escaping reference: Returning internal list
    public Map<String, Book> getBooks() {
        return books;
    }

    public Book findBook(String bookId) {
        return books.get(bookId);
    }

    // Additional methods to manipulate books in the library...
}
