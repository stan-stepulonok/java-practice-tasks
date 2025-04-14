package task7;

/*
Task 7: Shapes with Area Calculation
Create an enum Shape with constants CIRCLE, SQUARE, TRIANGLE.
Add abstract methods and override them to calculate area given different parameters.
 */

public class Main {

    public static void main(String[] args) {

        Shape square = Shape.SQUARE;
        System.out.println(square.calculateArea());

        Shape circle = Shape.CIRCLE;
        System.out.println(circle.calculateArea());

        Shape triangle = Shape.TRIANGLE;
        System.out.println(triangle.calculateArea());

    }

}
