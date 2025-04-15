package task9;

/*
Task 9: Custom Checked vs Unchecked
Create two custom exceptions:
CustomCheckedException (extends Exception)
CustomUncheckedException (extends RuntimeException) Write methods to throw both and handle them differently in main().
 */

public class Main {

    public static void main(String[] args) {

        try {
            CustomCheckedException checkedException = new CustomCheckedException();
            throw checkedException;
        } catch (CustomCheckedException e) {
            System.out.println("CustomCheckedException handling here -> " + e);
        }

        try {
            CustomUncheckedException uncheckedException = new CustomUncheckedException();
            throw uncheckedException;
        } catch (CustomUncheckedException e) {
            System.out.println("Unchecked exception here. Developers error. Logged the error -> " + e);
            System.out.println("Application did not crash.");
        }

        System.out.println("Throw unchecked exception without catch and crash jvm. ");
        throw new CustomUncheckedException();

    }

}
