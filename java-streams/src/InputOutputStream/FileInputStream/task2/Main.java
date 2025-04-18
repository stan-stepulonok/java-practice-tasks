package InputOutputStream.FileInputStream.task2;

import java.io.FileInputStream;
import java.io.IOException;

/*
Task 2: Use int read(byte[] b) to read chunks of 1024 bytes from a file and print the number of bytes read in each iteration.
int:
>0: actual number of bytes read
0: (rare) means no bytes read, but not EOF (depends on the stream type)
-1: end of stream (nothing left to read)
 */
public class Main {

    public static void main(String[] args) {

        int bytesRead, arraySize = 1024, iterationsCount = 0, totalBytesRead = 0;
        byte[] buffer = new byte[arraySize];
        String filePath = "F:\\Repositories\\java-practice-tasks\\java-streams\\src\\InputOutputStream\\FileInputStream\\task2\\file.txt";

        try (FileInputStream fis = new FileInputStream(filePath)) {
            while ((bytesRead = fis.read(buffer)) != -1) {
                iterationsCount++;
                totalBytesRead += bytesRead;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Iterations: " + iterationsCount);
        System.out.println("Total bytes read: " + totalBytesRead);

    }

}
