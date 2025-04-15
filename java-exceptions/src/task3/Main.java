package task3;

import java.util.Locale;

/*
Task 3: Nested Try-Catch
Use a nested try-catch where:
Inner block throws a NullPointerException
Outer block catches a RuntimeException
Print messages from each catch block
 */
public class Main {

    public static void main(String[] args) {

        String s = "TEST";
        s = Main.modifyString(s);
        System.out.println(s);
    }

    public static String modifyString(String s) {
        try {
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                System.out.println("Inner -> " + e);
            }
        } catch (RuntimeException e) {
            System.out.println("Outer -> " + e);
        }
        return s.toLowerCase();
    }



}
