package InputOutputStream.BufferedInputStream.task2;

/*
Task 2: Create a BufferedInputStream with a small buffer (e.g., 8 bytes) and compare its performance with a large buffer (e.g., 8192 bytes).
 */

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        String path = "F:\\Repositories\\java-practice-tasks\\java-streams\\src\\InputOutputStream\\BufferedInputStream\\task2\\cat.png";
        File fileToRead = new File(path);

        int bytesRead, smallBuffer = 8, largeBuffer = 8192;
        byte[] bufferSmall = new byte[smallBuffer];
        byte[] bufferLarge = new byte[largeBuffer];

        Instant start, end;
        Duration smallBufferDuration, largeBufferDuration;
        long smallBufferDurationNano, largeBufferDurationNano;

        start = Instant.now();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileToRead))) {
            while ((bytesRead = bis.read(bufferSmall)) != -1) {
                System.out.println("Iteration made.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        end = Instant.now();
        smallBufferDuration = Duration.between(start, end);
        smallBufferDurationNano = smallBufferDuration.toNanos();

        start = Instant.now();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileToRead))) {
            while ((bytesRead = bis.read(bufferLarge)) != -1) {
                System.out.println("Iteration made.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        end = Instant.now();
        largeBufferDuration = Duration.between(start, end);
        largeBufferDurationNano = largeBufferDuration.toNanos();

        System.out.println("smallBufferDuration: " + smallBufferDurationNano);
        System.out.println("largeBufferDuration: " + largeBufferDurationNano);



    }

}
