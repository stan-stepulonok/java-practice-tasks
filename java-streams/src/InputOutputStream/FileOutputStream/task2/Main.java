package InputOutputStream.FileOutputStream.task2;

/*
Task 2: Use write(byte[], int, int) to write only the last 5 bytes of an array.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String directory = "F:\\Repositories\\java-practice-tasks\\java-streams\\src\\InputOutputStream\\FileOutputStream\\task2\\";
        String fileName = "output.txt";
        String filePath = directory.concat(fileName);
        File fileOutput = new File(filePath);

        byte[] arrOfBytesOutput = {1, 2, 3, 4, 5, 6}; // 2 - 6
        byte[] arrOfBytesInput = new byte[5];

        try (FileOutputStream fos = new FileOutputStream(fileOutput);
             FileInputStream  fis = new FileInputStream(fileOutput)) {

            if (fileOutput.createNewFile()) System.out.println("File was successfully created.");
            else System.out.println("The file already exists.");
            fos.write(arrOfBytesOutput, 1, 5);

            arrOfBytesInput = fis.readAllBytes();
            System.out.println(Arrays.toString(arrOfBytesInput));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
