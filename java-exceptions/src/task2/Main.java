package task2;

/*
Task 2: Multiple Catch Blocks
Read a file path and divide two numbers. Handle:
FileNotFoundException
ArithmeticException Use two separate catch blocks.
Output:
File not found.
Cannot divide by zero.
Resource released. (in finally)
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        int divident = 4;
        int result;

        File fileWith2 = new File("F:\\Repositories\\java-practice-tasks\\java-exceptions\\src\\task2\\fileWith2.txt");
        result = Main.divide(divident, fileWith2);
        System.out.println(result);
        System.out.println();

        File fileWith0 = new File("F:\\Repositories\\java-practice-tasks\\java-exceptions\\src\\task2\\fileWith0.txt");
        result = Main.divide(divident, fileWith0);
        System.out.println(result);
        System.out.println();

        File fileInvalidPAth = new File("F:\\Repositories\\java-practice-tasks\\java-exceptions\\src\\task2\\fileWithInvalid.txt");
        result = Main.divide(divident, fileInvalidPAth);
        System.out.println(result);
        System.out.println();


    }

    public static int divide(int divident, File filePath) {
        int divisor;
        int result = 1;
        StringBuilder divisorStr = new StringBuilder("");
        int readByte;
        try {
            FileInputStream fis = new FileInputStream(filePath);
            while ((readByte = fis.read()) != -1) {
                divisorStr.append((char)readByte);
            }
            fis.close();
            divisor = Integer.parseInt(new String(divisorStr));
            result = divident/divisor;
        } catch (ArithmeticException | IOException e) {
            System.out.println(e);
            System.out.println("Default result (1) is returned.");
            return result;
        }
        System.out.println("Division was done successfully!");
        return result;
    }

}
