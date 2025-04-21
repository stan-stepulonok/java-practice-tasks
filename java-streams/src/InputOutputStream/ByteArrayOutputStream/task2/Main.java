package InputOutputStream.ByteArrayOutputStream.task2;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
Task 2: Write bytes, call reset(), then write new content; print final output.
 */
public class Main {

    public static void main(String[] args) {

        String[] strings = {"Test1\n", "Test2\n", "Test3\n"};

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            System.out.println("Case 1, no reset in the middle: ");
            for (int i = 0; i < strings.length; i++) {
                baos.write(strings[i].getBytes());
                System.out.println("Iteration: " + i);
                System.out.println("Added to output stream " + strings[i]);
                System.out.println("The stream looks like this now -> ");
                System.out.println(baos.toString());
            }
            System.out.println("Stream at the end of reading -> ");
            System.out.println(baos.toString());

            baos.reset(); // clear the stream but do not re-create it

            System.out.println("Case 2, reset in the middle: ");
            for (int i = 0; i < strings.length; i++) {
                baos.write(strings[i].getBytes());
                System.out.println("Iteration: " + i);
                System.out.println("Added to output stream " + strings[i]);
                System.out.println("The stream looks like this now -> ");
                System.out.println(baos.toString());
                baos.reset();
                System.out.println("Reset done.");
            }
            System.out.println("Stream at the end of reading -> ");
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
