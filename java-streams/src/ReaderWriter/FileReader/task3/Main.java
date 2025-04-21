package ReaderWriter.FileReader.task3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
Task 3: Use read(char[], int, int) to skip the first 2 characters in the buffer and read the next 4.
 */
public class Main {

    public static void main(String[] args) {

        File file = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\ReaderWriter\\FileReader\\task3\\file.txt");

        String dataOriginal = "TEST";
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(dataOriginal);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String dataModified = "";
        try (FileReader fr = new FileReader(file)) {
            char[] arrayOfReadChars = new char[6];
            fr.read(arrayOfReadChars, 2, 4);
            dataModified = new String(arrayOfReadChars);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(dataModified);


    }

}
