package task3;

/*
Task 3: Coffee Sizes
Define an enum CoffeeSize with constants SMALL, MEDIUM, LARGE, each having a volume in ml and a price.
Use these values in a method that prints full information for all sizes.
 */

public class Main {

    public static void main(String[] args) {

        CoffeeSize small = CoffeeSize.SMALL;
        CoffeeSize medium = CoffeeSize.MEDIUM;
        CoffeeSize large = CoffeeSize.LARGE;

        small.displayCoffeeSizeInfo();
        medium.displayCoffeeSizeInfo();
        large.displayCoffeeSizeInfo();

    }

}
