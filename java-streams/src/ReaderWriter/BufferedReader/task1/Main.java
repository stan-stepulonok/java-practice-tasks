package ReaderWriter.BufferedReader.task1;

import java.io.*;

/*
Task 1: Read lines of a file using readLine() and print only those that start with a capital letter.
 */
public class Main {

    public static void main(String[] args) {

        String[] strings = {"Test1", "test2", "Test3", "test4"};

        File file = new File("F:\\Repositories\\java-practice-tasks\\java-streams\\src\\ReaderWriter\\BufferedReader\\task1\\file.txt");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < strings.length; i++) {
                bw.write(strings[i]);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String readSrt;
            while ((readSrt = br.readLine()) != null) {
                if (readSrt.charAt(0) >= 65 && readSrt.charAt(0) <= 90) System.out.println(readSrt);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }


}
