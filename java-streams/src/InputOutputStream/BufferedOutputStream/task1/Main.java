package InputOutputStream.BufferedOutputStream.task1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Task 1: Write a large byte array (e.g., 10000 bytes) to a file using BufferedOutputStream and observe the use of flush() before closing.
 */
public class Main {

    public static void main(String[] args) {

        File file = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\InputOutputStream\\BufferedOutputStream\\task1\\output.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] largeArray = new byte[10000];

        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bos.write(largeArray);
            System.out.println("Write completed.");
            // set breakpoint, check file here
            bos.flush();
            System.out.println("Flush completed.");
            // set breakpoint, check file here
            bos.close();
            System.out.println("Close completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
