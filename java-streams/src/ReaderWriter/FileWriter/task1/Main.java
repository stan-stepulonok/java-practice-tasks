package ReaderWriter.FileWriter.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
Task 1: Write a string to a .txt file using write(String).
 */
public class Main {

    public static void main(String[] args) {

        File file = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\ReaderWriter\\FileWriter\\task1\\file.txt");

        String strToWrite = "Test123!";

        try (FileWriter fw = new FileWriter(file)) {
            // Write string directly
            fw.write(strToWrite);
            fw.write("\n");
            // Write arrayOfChars
            char[] stringToArr = strToWrite.toCharArray();
            fw.write(stringToArr);
            fw.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
