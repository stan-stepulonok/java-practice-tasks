package ReaderWriter.FileWriter.task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
Task 2: Use write(char[], int, int) to write only a specific section of a character array.
 */
public class Main {

    public static void main(String[] args) {

        File file = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\ReaderWriter\\FileWriter\\task2\\file.txt");

        String strToWrite = "xxTest123!xx";
        char[] stringToChar = strToWrite.toCharArray();

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(stringToChar, 2, 8);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
