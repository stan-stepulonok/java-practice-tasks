package ReaderWriter.FileWriter.task3;

/*
Task 3: Use FileWriter(String, true) to append current date and time to a log file.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;

public class Main {

    public static void main(String[] args) {

        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();

        File file = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\ReaderWriter\\FileWriter\\task3\\file.txt");

        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(ld.toString());
            fw.write("\n");
            fw.write(lt.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
