package ReaderWriter.BufferedWriter.task3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Task 3: Use write(char[], int, int) to write selected words to a file, then close it properly.
 */
public class Main {

    public static void main(String[] args) {

        // words with numbers at the end

        String allWords = "test test1 testX test12 TEST TEST123 12345";
        String regex = "\\b[A-Za-z]+[0-9]+\\b";

        File file = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\ReaderWriter\\BufferedWriter\\task3\\file.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            Pattern pat = Pattern.compile(regex);
            Matcher mat = pat.matcher(allWords);
            while (mat.find()) {
                bw.write(mat.group());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
