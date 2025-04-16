package Comparator.task2;

import Comparator.task1.PriceComparator;
import Comparator.task1.Product;

import java.util.ArrayList;
import java.util.List;

/*
Sort Movies by Rating, then Title (Chained Comparator)
Create a Movie class with title and rating.
Use a Comparator<Movie> to:

Sort by rating descending.
If two movies have the same rating, sort by title alphabetically.

Sample Output:
[Movie{title='Inception', rating=9.0}, Movie{title='Interstellar', rating=9.0}, Movie{title='Avatar', rating=7.8}]
 */
public class Main {

    public static void main(String[] args) {

        Movie m1 = new Movie("XYZ", 30);
        Movie m2 = new Movie("CDE", 20);
        Movie m3 = new Movie("EFG", 25);
        Movie m4 = new Movie("ABC", 25);
        List<Movie> moviesList = new ArrayList<>();
        moviesList.add(m1);
        moviesList.add(m2);
        moviesList.add(m3);
        moviesList.add(m4);

        System.out.println("Before: " + moviesList);

        RatingTitleComparator ratingTitleComparatorInstance = new RatingTitleComparator();
        moviesList.sort(ratingTitleComparatorInstance);

        System.out.println("After: " + moviesList);


    }

}
