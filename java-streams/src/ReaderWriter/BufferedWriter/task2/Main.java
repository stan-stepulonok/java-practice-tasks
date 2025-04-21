package ReaderWriter.BufferedWriter.task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Task 2: Write a paragraph and call flush() after every sentence.
 */
public class Main {

    public static void main(String[] args) {

        String paragraph = "It was a concerning development that he couldn't get out of his mind. " +
                "He'd had many friends throughout his early years and had fond memories of playing with them, but he couldn't understand how it had all stopped. " +
                "There was some point as he grew up that he played with each of his friends for the very last time, and he had no idea that it would be the last.";

        /*
        Regex:

        1. Split flow:
        String[] sentences = paragraph.split("(?<=[.?!…])\\s+");
          (?<=[.?!…]): positive lookbehind to match after ., ?, !, or ellipsis (…)
          \\s+: matches the space that comes after punctuation
          It keeps the punctuation attached to the sentence

        2. Matcher flow:
        Pattern pattern = Pattern.compile("[^.!?…]+[.!?…]");
          [^.!?…]+: match any text that doesn’t include sentence-ending punctuation
          [.!?…]: match the sentence-ending punctuation
          This approach preserves the sentence-ending symbol (import
         */

        File text = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\ReaderWriter\\BufferedWriter\\task2\\text.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(text))) {
            String regex = ("[^.!?…]+[.!?…] ");
            Pattern pat = Pattern.compile(regex);
            Matcher matcher = pat.matcher(paragraph);
            while (matcher.find()) {
                bw.write(matcher.group());
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
