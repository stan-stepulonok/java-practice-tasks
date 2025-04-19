package InputOutputStream.ByteArrayInputStream.task2;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/*
Task 2: Use read(byte[], int, int) to extract specific portions from a byte array.
 */
public class Main {

    public static void main(String[] args) {

        int offset = 2, length = 3; // 2, 3, 4
        int bytesRead;
        String stringToRead = "XX123XX";
        byte[] bufferFrom = stringToRead.getBytes();
        byte[] bufferTo = new byte[bufferFrom.length];

        try (ByteArrayInputStream bais = new ByteArrayInputStream(bufferFrom, offset, length)) {
            while ((bytesRead = bais.read(bufferTo, offset, length)) != -1) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String readString = new String(bufferTo);
        System.out.println(readString);


    }

}
