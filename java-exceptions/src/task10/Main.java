package task10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Task 10: Try-with-Resources
Use try-with-resources to read a file with BufferedReader. Ensure the file is closed automatically.
Catch IOException
Show how AutoCloseable works
 */
public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("F:\\Repositories\\java-practice-tasks\\java-exceptions\\src\\task10\\fileToRead.txt"))) {
            StringBuilder result = new StringBuilder("");
            int byteReadFromFile;
            while ((byteReadFromFile = br.read()) != -1) {
                result.append((char)byteReadFromFile);
            }
            System.out.println(result);
        } catch (IOException e) {
            System.out.println(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("This Does Not Exist"))) {
            StringBuilder result = new StringBuilder("");
            int byteReadFromFile;
            while ((byteReadFromFile = br.read()) != -1) {
                result.append((char)byteReadFromFile);
            }
            System.out.println(result);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
