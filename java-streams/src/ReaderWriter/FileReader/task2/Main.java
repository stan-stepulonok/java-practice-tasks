package ReaderWriter.FileReader.task2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
Task 2: Use read(char[]) to read chunks of text into a buffer and print each buffer until EOF (end of file).
 */
public class Main {

    public static void main(String[] args) {

        String toWrite = "Test123!#";
        File file = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\ReaderWriter\\FileReader\\task2\\file.txt");

        /*
        When you use new FileWriter(File file):
        1. If the file doesn't exist, Java will -> Create it automatically
        2. If the file does exist, Java will -> Truncate it (erase its contents) and then write the new data
         */


        try (FileWriter fw = new FileWriter(file)) {
            fw.write(toWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] buffer = new char[3];
        int readChars;
        try (FileReader fr = new FileReader(file)) {
            while ((readChars = fr.read(buffer)) != -1) {
                System.out.println(new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
