package ReaderWriter.InputStreamReaderOutputStreamWriter.task1;

// 1. Create a ByteArrayInputStream from a UTF-8 encoded string.
// 2. Use InputStreamReader to read characters.
// 3. Write the same characters into a ByteArrayOutputStream using OutputStreamWriter.
// 4. Convert ByteArrayOutputStream to a String and print it.

/*
UTF-8 encoded string
You don't embed encoding into the String itself — you define encoding when you go from String ↔ byte[] or when you read/write to external sources.
✅ 1. Converting String to byte[]
String str = "Hello, world!";
byte[] utf8Bytes = str.getBytes("UTF-8"); // OR byte[] utf8Bytes = str.getBytes(StandardCharsets.UTF_8);
✅ 2. Converting byte[] to String
String restored = new String(utf8Bytes, "UTF-8"); // OR String restored = new String(utf8Bytes, StandardCharsets.UTF_8);
✅ 3. When writing to a file
Writer writer = new OutputStreamWriter(new FileOutputStream("output.txt"), StandardCharsets.UTF_8);
BufferedWriter writer = Files.newBufferedWriter(Paths.get("output.txt"), StandardCharsets.UTF_8);
✅ 4. Reading from a file
BufferedReader reader = new BufferedReader(
    new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8)
);
 */

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {

        // create a string and convert it to bytes so that ByteArrayInputStream could read them
        String str = "Test123!";
        byte[] bytesFromString = str.getBytes(StandardCharsets.UTF_8);

        // Create a String where the final result is stored
        String result = "default";

        // create ByteArrayInputStream and InputStreamReader
        try(ByteArrayInputStream bais = new ByteArrayInputStream(bytesFromString);
            InputStreamReader isr = new InputStreamReader(bais);
            ByteArrayOutputStream boas = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(boas)) {

            // create a char array where the data will be stored after InputStreamReader reads it
            char[] bufferStorage = new char[bytesFromString.length];

            // InputStreamReader reads from ByteArrayInputStream and saves data into array
            int byteRead;
            int index = 0;
            while ((byteRead = isr.read()) != -1) {
                bufferStorage[index] = (char)byteRead;
                index++;
            }

            // OutputStreamWriter writes data from bufferStorage array into ByteArrayOutputStream
            osw.write(bufferStorage, 0, bufferStorage.length);
            osw.flush();

            // Obtain String from ByteArrayOutputStream
            result = boas.toString(StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);

    }

}
