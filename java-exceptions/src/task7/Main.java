package task7;

/*
Task 7: Exception Propagation
Create:
readNumber() that throws IOException
processNumber() that catches it and rethrows a CustomAppException
Catch CustomAppException in main() and print its cause.
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Main.processNumber();
        } catch(CustomAppException e) {
            System.out.println("CustomAppException caught here: "  + e);
        }

    }

    public static void readNumber() throws IOException {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = s.nextInt();
        s.close();
        throw new IOException();
    }

    public static void processNumber() throws CustomAppException {
        try {
            Main.readNumber();
        } catch (IOException e) {
            System.out.println("IO exception caught here: " + e);
            throw new CustomAppException(e);
        }
    }

}
