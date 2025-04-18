package InputOutputStream.ByteArrayInputStream.task1;

/*
Task 1: Convert a string to a byte array and read it byte-by-byte using read(); convert each byte back to character and print.

ByteArrayInputStream(byte[] buf)
int read(byte[] b, int off, int len)

buf -> is an array we are reading from
b -> is an array we are reading to
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String stringToRead = "Hello123!";
        byte[] bufferFrom = stringToRead.getBytes();
        byte[] bufferTo = new byte[bufferFrom.length];
        int bytesRead;

        try (ByteArrayInputStream bais = new ByteArrayInputStream(bufferFrom)) {
            while ((bytesRead = bais.read(bufferTo)) != -1) {
                System.out.println("Iteration done.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.equals(bufferFrom, bufferTo));

    }

}
