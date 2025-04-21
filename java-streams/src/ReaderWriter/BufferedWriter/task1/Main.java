package ReaderWriter.BufferedWriter.task1;

/*
Task 1: Write multiple lines of a poem to a file using newLine() between lines.
 */

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String poem = "No man is an island,\n" +
                "Entire of itself,\n" +
                "Every man is a piece of the continent,\n" +
                "A part of the main.\n" +
                "If a clod be washed away by the sea,\n" +
                "Europe is the less.\n" +
                "As well as if a promontory were.\n" +
                "As well as if a manor of thy friend’s\n" +
                "Or of thine own were:\n" +
                "Any man’s death diminishes me,\n" +
                "Because I am involved in mankind,\n" +
                "And therefore never send to know for whom the bell tolls;\n" +
                "It tolls for thee.";

        String directoryPath = "F:\\Repositories\\java-practice-tasks\\java-streams\\src\\ReaderWriter\\BufferedWriter\\task1\\";
        String fileName = "poem.txt";
        String filePath = directoryPath.concat(fileName);
        File poemObj = new File(filePath);
        try {
            if (poemObj.createNewFile()) { // can skip and FileWriter will create a file itself
                System.out.println("The file was successfully created.");
            } else {
                System.out.println("The file already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(poemObj))) {
            bw.write(poem);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder verificationPoem = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(poemObj))) {
            String readLine;
            while ((readLine = br.readLine()) != null) { // read line by line
                verificationPoem.append(readLine).append("\n"); // \n characters are not included, so need to add them manually
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(verificationPoem);

    }

}
