package ReaderWriter.BufferedReader.task2;

/*
Task 2: Read a file line-by-line and count how many lines contain a specific word (e.g., "Java").
 */

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        File file = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\ReaderWriter\\BufferedReader\\task2\\file.txt");

        String[] strings = {"notJava", "Java 1", "1 java", "1 Java 1", "test"};

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < strings.length; i++) {
                bw.write(strings[i]);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int javaCounter = 0;
        String regex = "\\bjava\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String readLine;
            while ((readLine = br.readLine()) != null) {
                matcher = pattern.matcher(readLine);
                if (matcher.find()) javaCounter++;
                matcher.reset();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Java count: " + javaCounter);

    }

}
