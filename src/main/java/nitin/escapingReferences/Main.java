package nitin.escapingReferences;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("1234567890", book);

        Book retrievedBook = library.findBook("1234567890");
        retrievedBook.setTitle("New Title");

        // Output the book in the library
        System.out.println(library.findBook("1234567890").getTitle()); // Output: The Great Gatsby
    }
}

