package InputOutputStream.BufferedOutputStream.task2;

/*
Task 2: Write 3 lines of content and use flush() after each to see intermediate writes reflected in the file.
 */

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String[] lines = {"Test1\n", "Test2\n", "Test3\n"};

        File file = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\InputOutputStream\\BufferedOutputStream\\task2\\file.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            for (int i = 0; i < lines.length; i++) {
                // set up breakpoint here
                bos.write(lines[i].getBytes());
                bos.flush();
                // check for one line added
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
