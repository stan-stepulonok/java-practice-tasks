package ComparableComparatorMix.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Sort Books by Price using Comparable, then by Title using Comparator
Create a Book class with title and price.
Use Comparable<Book> to sort by price ascending.
Then use a Comparator<Book> to sort by title.
Price:
[Book{title='C', price=20.0}, Book{title='B', price=30.0}, Book{title='A', price=50.0}]
Title:
[Book{title='A', price=50.0}, Book{title='B', price=30.0}, Book{title='C', price=20.0}]
 */
public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("C", 20);
        Book book2 = new Book("B", 30);
        Book book3 = new Book("A", 50);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        System.out.println("Before: " + books);

        Collections.sort(books);
        System.out.println("Comparable (price): " + books);

        books.sort(Book.titleComparator);
        System.out.println("Comparator (title): " + books);

    }

}
