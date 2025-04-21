package InputOutputStream.BufferedInputStream.task1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

/*
Task 1: Wrap a FileInputStream using BufferedInputStream and read the entire file using read(byte[], int, int);
measure the time taken using System.nanoTime().
 */

public class Main {

    public static void main(String[] args) {

        String pathToFile = "F:\\Repositories\\java-practice-tasks\\java-streams\\src\\InputOutputStream\\BufferedInputStream\\task1\\file.txt";
        File fileToRead = new File(pathToFile);
        int bytesRead;
        long arraySize = fileToRead.length();
        byte[] readBytesArray = new byte[(int)arraySize];

        Instant start, end;
        Duration fileInputStreamDuration, bufferedInoutStreamDuration;

        start = Instant.now();
        try (FileInputStream fis = new FileInputStream(fileToRead)) {
            while ((bytesRead = fis.read(readBytesArray)) != -1) {
                System.out.println("Iteration done.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = Instant.now();

        fileInputStreamDuration = Duration.between(start,end);

        start = Instant.now();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileToRead))) {
            while ((bytesRead = bis.read(readBytesArray)) != -1) {
                System.out.println("Iteration done.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = Instant.now();

        bufferedInoutStreamDuration = Duration.between(start,end);

        System.out.println("fileInputStreamDuration: " + fileInputStreamDuration.toNanos());
        System.out.println("bufferedInoutStreamDuration: " + bufferedInoutStreamDuration.toNanos());

    }

}
