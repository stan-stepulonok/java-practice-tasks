package Comparator.task2;

import java.util.Comparator;

public class RatingTitleComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {
        int compareResult = Double.compare(movie1.getRating(), movie2.getRating());
        if (compareResult == 0) {
            compareResult = movie1.getTitle().compareTo(movie2.getTitle());
        }
        return compareResult;
    }

}
