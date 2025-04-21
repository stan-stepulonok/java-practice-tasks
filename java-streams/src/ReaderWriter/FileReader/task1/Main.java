package ReaderWriter.FileReader.task1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Task 1: Read a .txt file character-by-character using read() and count vowels.
 */
public class Main {

    public static void main(String[] args) {

        // 1. Dealing with the file

        String directory = "F:\\Repositories\\java-practice-tasks\\java-streams\\src\\ReaderWriter\\FileReader\\task1\\";
        String fileName = "file.txt";
        String filePath = directory.concat(fileName);
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. Write into the file

        String writeString = "ABCDEfghi"; // use void write(String str)
        // char[] writeCharsArray = writeString.toCharArray(); // use void write(char[] cbuf)
        try (FileWriter fw = new FileWriter(file)) {
            fw.write(writeString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. Read from this file
        int readChar;
        StringBuilder readChars = new StringBuilder();
        try (FileReader fr = new FileReader(file)) {
            while ((readChar = fr.read()) != -1) {
                readChars.append((char)readChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. Count vowels
        String regex = "[aioue]";
        String vowels = new String(readChars);
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(vowels);
        int vowelsCount = 0;
        while (matcher.find()) {
            vowelsCount++;
        }
        System.out.println("Vowels count: " + vowelsCount);

    }

}
