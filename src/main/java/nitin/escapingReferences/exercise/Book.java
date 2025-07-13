package nitin.escapingReferences.exercise;

public class Book {
    private final int id;
    private final String title;
    private final String author;
    private Price price;

    public Book(int id, String title, String author, Double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = new Price(price);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return title + " by " + author;
    }

    public Price getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = new Price(price);
    }
}
