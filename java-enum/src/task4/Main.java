package task4;

/*
Task 4: Country Population & Currency
Create an enum Country where each constant stores two values: population and currency name.
Implement a method that prints a formatted summary for each country.
 */

public class Main {

    public static void main(String[] args) {

        Country[] countries = Country.values();
        for (Country c : countries) c.printDetails();

    }

}
