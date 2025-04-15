package task1;

/*
Task 1: Division with Try-Catch
Create a method that divides two integers. Use try-catch to handle ArithmeticException when dividing by zero.
Input: 10 / 0
Output: Cannot divide by zero.
 */

public class Main {

    public static void main(String[] args) {

        int num1 = 4;
        int num2 = 2;
        System.out.println(Main.divide(num1, num2));
        System.out.println();

        num2 = 0;
        System.out.println(Main.divide(num1, num2));

    }

    public static double divide(int num1, int num2) {
        double result = 0;
        try {
            result = num1/num2;
        } catch (ArithmeticException e) {
            System.out.println(e);
            System.out.println("Default value (0) was returned as the result.");
            return result;
        }
        System.out.println("Division was done successfully!");
        return result;
    }

}
