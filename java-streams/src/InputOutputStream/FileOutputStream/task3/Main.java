package InputOutputStream.FileOutputStream.task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Task 3: Open a file with append=true and add a new line of text to the end.
 */
public class Main {

    public static void main(String[] args) {

        String directoryPath = "F:\\Repositories\\java-practice-tasks\\java-streams\\src\\InputOutputStream\\FileOutputStream\\task3\\";
        String fileName = "output.txt";
        String filePath = directoryPath.concat(fileName);
        File fileOutput = new File(filePath);
        try {
            if (fileOutput.createNewFile()) System.out.println("The file was created.");
            else System.out.println("The file already exists.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String doNotOverwrite = "Text1\n";
        byte[] output1 = doNotOverwrite.getBytes();
        try(FileOutputStream fos = new FileOutputStream(fileOutput)) {
            fos.write(output1);
        } catch(IOException e) {
            e.printStackTrace();
        }

        String newText = "Text2\n";
        byte[] output2 = newText.getBytes();
        try(FileOutputStream fos = new FileOutputStream(fileOutput, true)) {
            fos.write(output2);
        } catch(IOException e) {
            e.printStackTrace();
        }

        byte[] verificationArray = new byte[output1.length + output2.length];
        try (FileInputStream fis = new FileInputStream(fileOutput)) {
            fis.read(verificationArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String verificationString = new String(verificationArray);
        System.out.println(verificationString);

    }

}
