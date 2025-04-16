package ComparableComparatorMix.task1;

import java.util.Comparator;

public class Book implements Comparable<Book> {

    private String title;
    private double price;

    public static Comparator<Book> titleComparator = new Comparator<>() {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.title.compareTo(book2.title);
        }
    };

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Book bookToCompareTo) {
        double delta = this.price - bookToCompareTo.price;
        if (delta < 0) return -1;
        else if (delta > 0) return 1;
        else return 0;
    }

}
