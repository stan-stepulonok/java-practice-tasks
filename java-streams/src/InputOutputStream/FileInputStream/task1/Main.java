package InputOutputStream.FileInputStream.task1;

/*
Task 1: Open a binary file (e.g., PNG or PDF) and read it byte-by-byte using read(); count the total bytes.
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        File catImage = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\InputOutputStream\\FileInputStream\\task1\\cat.png");

        int readByte, readByteCount = 0;
        List<Integer> readByteList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(catImage)) {
            while ((readByte = fis.read()) != -1) {
                readByteList.add(readByte);
                readByteCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Bytes read: " + readByteList);
        System.out.println("Byte count: " + readByteCount);

    }

}
