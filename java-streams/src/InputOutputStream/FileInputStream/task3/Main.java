package InputOutputStream.FileInputStream.task3;

/*
Task 3: Use read(byte[], int, int) to fill a portion of a byte array with file contents starting from offset 2 and read up to 10 bytes.
“Read up to 10 bytes from the file, and put them starting at index 2 in the array.”
2 = starting index in your array
10 = how many bytes to try to read
12 total, xx23456789(10)(11)(12), xx - empty
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int readBytes, byteArraySize = 12;
        byte[] readBytesArray = new byte[byteArraySize];
        String filePath = "F:\\Repositories\\java-practice-tasks\\java-streams\\src\\InputOutputStream\\FileInputStream\\task3\\file.txt";
        File fileToRead = new File(filePath);

        try(FileInputStream fis = new FileInputStream(fileToRead)) {
            while ((readBytes = fis.read(readBytesArray, 2, 10)) != -1) {
                System.out.println(Arrays.toString(readBytesArray));
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
