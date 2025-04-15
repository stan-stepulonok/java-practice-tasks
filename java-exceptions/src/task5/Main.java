package task5;

/*
Task 5: Input Validation
Ask the user for an integer input. If the input is not an integer, catch a NumberFormatException.
If it's negative, throw IllegalArgumentException.
Input: "abc" → Number format issue
Input: -2 → Negative number entered
Finally: Validation complete.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int input;
        boolean waitingForValidNumber = true;
        while (waitingForValidNumber) {
            try {
                System.out.println("Enter a positive number: ");
                input = s.nextInt();
                if (input < 0) throw new IllegalArgumentException();
                waitingForValidNumber = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("You have entered incorrect data.");
                System.out.println(e);
                s.nextLine(); // ✅ Clear invalid input -> if entered abc, it's still there in the scanner!!!
            } catch (IllegalArgumentException e) {
                System.out.println("You have entered a negative number.");
                System.out.println(e);
                s.nextLine(); // ✅ Clear invalid input
            }
            if (waitingForValidNumber) continue;
            System.out.println("Thank you for providing the number!");
        }
    }

}
