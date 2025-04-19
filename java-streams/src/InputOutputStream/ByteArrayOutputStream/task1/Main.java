package InputOutputStream.ByteArrayOutputStream.task1;

/*
Task 1: Write several strings converted to byte arrays into the stream, then retrieve the result using toByteArray() and toString().
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String s1 = "Test1", s2 = "Test2", s3 = "Test3";
        String result1, result2, result3;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write(s1.getBytes());
            result1 = new String(baos.toByteArray()); // convert to array and then convert to string
            System.out.println(result1);

            baos.write(s2.getBytes());
            result2 = baos.toString(); // use toString directly
            System.out.println(result2);

            /*
            Test1
            Test1Test2 -----> note that output stream keeps the bytes read from the first iteration;
             */

            baos.reset();
            baos.write(s3.getBytes());
            result3 = baos.toString(); // use toString directly
            System.out.println(result3);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
