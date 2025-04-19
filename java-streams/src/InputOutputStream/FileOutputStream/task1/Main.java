package InputOutputStream.FileOutputStream.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/*
Task 1: Write an array of ASCII characters as bytes into a new file using write(byte[]).

- What is ASCII?
ASCII, stands for American Standard Code for Information Interchange.
It is a 7-bit character code where each individual bit represents a unique character.
This page shows the extended ASCII table which is based on the Windows-1252 character set which is an 8 bit ASCII table with 256 characters and symbols.
It includes all ASCII codes from standard ASCII, and it is a superset of ISO 8859-1 in terms of printable characters.
In the range 128 to 159 (hex 80 to 9F), ISO/IEC 8859-1 has invisible control characters, while Windows-1252 has writable characters.
Windows-1252 is probably the most-used 8-bit character encoding in the world.

- What does "ASCII characters" mean?
It simply means you're working with characters whose numeric values (code points) fall within the standard ASCII range, which is: 0–127
Each of these values maps to a character — letters, numbers, punctuation, or control characters.

- How to create a file?
If you write this:
  String filePath = "ascii_output.txt";
  File file = new File(filePath);
You're giving a relative path — meaning:
The file will be created in the project's root directory, i.e., the directory from which your Java program is being run.
Want to know exactly where? Add this line to your code:
  System.out.println("Absolute path: " + file.getAbsolutePath());
If your project is located at: F:\Repositories\java-practice-tasks\
Then the file will be created at: F:\Repositories\java-practice-tasks\ascii_output.txt
Want to create the file in a specific folder? Just give a full or relative path:
  String filePath = "src\\resources\\ascii_output.txt";  // relative to project
  // or
  String filePath = "F:\\MyFiles\\ascii_output.txt";     // absolute path
To create a file physically on a disk use method: public boolean createNewFile() throws IOException
  if (file.createNewFile()) {
     System.out.println("New file created.");
   } else {
     System.out.println("File already exists.");
   }
When you do: File file = new File(filePath);
You're not creating a physical file on disk — you're just creating a File object in memory that represents a path (which may or may not exist).
 */
public class Main {

    public static void main(String[] args) {

        // define paths
        String directoryPath = "F:\\Repositories\\java-practice-tasks\\java-streams\\src\\InputOutputStream\\FileOutputStream\\task1\\";
        String fileName = "output.txt";
        String filePath = directoryPath.concat(fileName);
        File fileForOutput = new File(filePath);

        // create a file in directory and store bool result
        boolean isFileCreated = false;
        try {
            isFileCreated = fileForOutput.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // print the message to indicate the result
        if (isFileCreated) System.out.println("The file was successfully created!");
        else System.out.println("The file already exists!");

        // work with array

        char[] arrayOfCharsFrom = {'1', 'a', '#'};
        String charsToString = new String(arrayOfCharsFrom);
        byte[] arrayOfBytesFrom = charsToString.getBytes(StandardCharsets.US_ASCII);

        // write into the file (Output Stream)

        try (FileOutputStream fos = new FileOutputStream(fileForOutput)) {
            fos.write(arrayOfBytesFrom); // you can write a single byte using write(int byte) method, and it is converted to byte automatically
        } catch (IOException e) {
            e.printStackTrace();
        }

        // test by reading (Input Stream)
        char[] verificationArr = new char[3];
        int readByte, index = 0;
        try (FileInputStream fis = new FileInputStream(fileForOutput)) {
            while ((readByte = fis.read()) != -1 && index < 3) {
                verificationArr[index] = (char)readByte;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Original array: " + Arrays.toString(arrayOfCharsFrom));
        System.out.println("Read from file array: " + Arrays.toString(verificationArr));

    }

}
