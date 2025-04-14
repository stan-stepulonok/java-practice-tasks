package task6;

/*
Task 6: Movie Ratings
Define an enum Rating with values like G, PG, PG13, R.
For each, associate a minimum viewer age and a description. Use a method to print details for each rating.
 */
public class Main {

    public static void main(String[] args) {
        Rating r = Rating.R;
        Rating pg13 = Rating.PG13;
        pg13.showDetails();
        System.out.println();
        r.showDetails();
    }
}
