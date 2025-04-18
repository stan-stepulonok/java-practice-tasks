package InputOutputStream.FileInputStream.task1;

/*
Task 1: Open a binary file (e.g., PNG or PDF) and read it byte-by-byte using read(); count the total bytes.
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File catImage = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\InputOutputStream\\FileInputStream\\task1\\cat.png");
        try (FileInputStream fis = new FileInputStream(catImage)) {

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
