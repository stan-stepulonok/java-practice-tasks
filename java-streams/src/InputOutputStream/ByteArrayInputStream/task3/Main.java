package InputOutputStream.ByteArrayInputStream.task3;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
Task 3: Read a portion, then call reset() and re-read the data to verify reset functionality.
 */
public class Main {

    public static void main(String[] args) {

        byte[] bufferFrom = {1, 2, 3, 4, 5};
        byte[] bufferToBeforeReset = new byte[bufferFrom.length];
        byte[] bufferToAfterReset = new byte[bufferFrom.length];
        int readBytes;
        int offset = 1, length = 3;

        System.out.println("Original array: " + Arrays.toString(bufferFrom));

        try (ByteArrayInputStream bais = new ByteArrayInputStream(bufferFrom, offset, length)) {
            while ((readBytes = bais.read(bufferToBeforeReset, offset, length)) != -1) {
                System.out.println("Iteration1");
            }
            System.out.println("Before reset array: " + Arrays.toString(bufferToBeforeReset));
            bais.reset();
            readBytes = 0;
            while ((readBytes = bais.read(bufferToAfterReset, offset, length)) != -1) {
                System.out.println("Iteration2");
            }
            System.out.println("After reset array: " + Arrays.toString(bufferToAfterReset));
            System.out.println("Equals: " + Arrays.equals(bufferToBeforeReset, bufferToAfterReset));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
