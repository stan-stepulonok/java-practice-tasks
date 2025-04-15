package task4;

/*
Task 4: Custom Exception
Create a custom exception called NegativeInputException. Throw it when a method receives a negative number.
In main(), call the method with -5.
Output: Custom exception: Negative input not allowed.
 */

public class Main {

    public static void main(String[] args) {

        int result;

        result = Main.positiveMultiplication(3);
        System.out.println(result);
        System.out.println();

        result = Main.positiveMultiplication(-3);
        System.out.println(result);
        System.out.println();

    }

    public static int positiveMultiplication(int num) {
        try {
            if (num < 0) throw new NegativeInputException("Negative number passed as parameter.");
        } catch (NegativeInputException e) {
            System.out.println(e);
        }
        return num * 3;
    }

}
