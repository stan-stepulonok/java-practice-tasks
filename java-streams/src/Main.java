/*
----------------------------- 1. InputStream / OutputStream (Byte Streams) -----------------------------
Common Uses: For reading and writing binary data: images, audio files, PDFs, etc.

1.1 FileInputStream
- Description:
FileInputStream is used for reading raw byte data from files. Suitable for binary data like images, audio, or any non-text files.
- Constructors:
FileInputStream(String name) throws FileNotFoundException   // Takes a file path as a string.
FileInputStream(File file) throws FileNotFoundException     // Takes a File object representing the file.
- Methods:
int read() throws IOException               // Reads a single byte.
int read(byte[] b) throws IOException       // Reads bytes into a byte array.
int read(byte[] b, int off, int len) throws IOException // Reads bytes into array with offset and length.
void close() throws IOException             // Closes the input stream.

1.2 BufferedInputStream
- Description:
Adds buffering to an existing InputStream to improve efficiency during reading operations.
- Constructors:
BufferedInputStream(InputStream in)             // Wraps an existing InputStream.
BufferedInputStream(InputStream in, int size)   // Adds custom buffer size.
- Main Methods:
int read() throws IOException
int read(byte[] b, int off, int len) throws IOException
void close() throws IOException

1.3 ByteArrayInputStream
- Description:
Allows reading from a byte array as an input stream.
- Constructors:
ByteArrayInputStream(byte[] buf)                              // Wraps an entire byte array.
ByteArrayInputStream(byte[] buf, int offset, int length)      // Reads from a portion of the array.
- Main Methods:
int read()                                 // Reads the next byte of data.
int read(byte[] b, int off, int len)
void reset()                               // Resets the stream to the beginning.

1.4 FileOutputStream
- Description:
Writes raw byte data to a file. Used for binary output.
- Constructors:
FileOutputStream(String name) throws FileNotFoundException                    // File path string.
FileOutputStream(File file) throws FileNotFoundException                      // File object.
FileOutputStream(String name, boolean append) throws FileNotFoundException    // Append mode.
- Main Methods:
void write(int b) throws IOException        // Writes a single byte.
void write(byte[] b) throws IOException     // Writes an entire byte array.
void write(byte[] b, int off, int len) throws IOException // Writes part of a byte array.
void close() throws IOException

1.5 BufferedOutputStream
- Description:
Buffers data while writing to another OutputStream for performance.
- Constructors:
BufferedOutputStream(OutputStream out)              // Wraps an OutputStream.
BufferedOutputStream(OutputStream out, int size)    // Custom buffer size.
- Main Methods:
void write(int b) throws IOException
void write(byte[] b, int off, int len) throws IOException
void flush() throws IOException             // Flushes the buffer.
void close() throws IOException

1.6 ByteArrayOutputStream
- Description:
A stream that writes data into a byte array. The buffer grows as needed.
- Constructors:
ByteArrayOutputStream()            // Default buffer size.
ByteArrayOutputStream(int size)    // Custom initial size.
- Main Methods:
void write(int b)
void write(byte[] b, int off, int len)
byte[] toByteArray()                        // Returns written data as byte array.
String toString()                           // Converts written bytes to string.
void reset()                                // Resets the stream.
void close() throws IOException
 */

/*
----------------------------- 2. Character Streams -----------------------------

2.1 FileReader
- Description:
Reads character files. Decodes bytes using the platform's default charset.
- Constructors:
FileReader(String fileName) throws FileNotFoundException      // File path string.
FileReader(File file) throws FileNotFoundException            // File object.
- Main Methods:
int read() throws IOException                // Reads a single character.
int read(char[] cbuf) throws IOException     // Reads characters into array.
int read(char[] cbuf, int off, int len) throws IOException
void close() throws IOException

2.2 BufferedReader
- Description:
Reads text efficiently using a buffer. Provides the readLine() method.
- Constructors:
BufferedReader(Reader in)           // Wraps a Reader.
BufferedReader(Reader in, int sz)   // With custom buffer size.
- Main Methods:
String readLine() throws IOException         // Reads a line of text.
int read(char[] cbuf, int off, int len) throws IOException
void close() throws IOException

2.3 CharArrayReader
- Description:
Reads characters from a char array.
- Constructors:
CharArrayReader(char[] buf)
CharArrayReader(char[] buf, int offset, int length)
- Main Methods:
int read() throws IOException
int read(char[] b, int off, int len) throws IOException
void close() throws IOException

2.4 FileWriter
- Description:
Writes characters to a file using default charset.
- Constructors:
FileWriter(String fileName) throws IOException                       // File path string.
FileWriter(File file) throws IOException                             // File object.
FileWriter(String fileName, boolean append) throws IOException       // Append mode.
- Main Methods:
void write(int c) throws IOException         // Writes a single character.
void write(char[] cbuf) throws IOException
void write(char[] cbuf, int off, int len) throws IOException
void write(String str) throws IOException
void write(String str, int off, int len) throws IOException
void close() throws IOException

2.5 BufferedWriter
- Description:
Buffers characters for efficient writing. Offers newLine() for platform-specific line breaks.
- Constructors:
BufferedWriter(Writer out)            // Wraps a Writer.
BufferedWriter(Writer out, int sz)    // With custom buffer size.
- Main Methods:
void write(int c) throws IOException
void write(char[] cbuf, int off, int len) throws IOException
void newLine() throws IOException
void flush() throws IOException
void close() throws IOException

2.6 CharArrayWriter
- Description:
Writes characters to a char array that grows automatically.
- Constructors:
CharArrayWriter()
CharArrayWriter(int initialSize)
- Main Methods:
void write(int c)
void write(char[] c, int off, int len)
char[] toCharArray()
String toString()
void reset()
void close() throws IOException
 */

/*
----------------------------- 3. Read Logic -----------------------------
Input classes like InputStream and Reader recognize there's something to read using:
- internal buffering,
- file metadata,
- or by checking the stream state (like reaching end-of-stream).

Here's how they typically know:

1. read() Return Values
The most common way to check if there's data is to call .read() and check its return:
For InputStream and Reader, read() returns:
A non-negative int: a byte or character read.
-1: End of stream (nothing more to read).

2. available() Method (InputStream only)
Tells how many bytes can be read without blocking.
Doesn't work for all streams (like FileInputStream, yes; SocketInputStream, maybe not accurately).

3. Buffered Streams + Internal Buffering
Classes like BufferedReader or BufferedInputStream use an internal buffer.
They pre-load chunks of data, which helps check for new input efficiently.
Methods like .ready() in Reader indicate whether the stream is ready to be read (i.e., won’t block).

4. Real-Time Sources (like Sockets)
Streams connected to sockets or pipes may block until data arrives.
Java handles this using threads or non-blocking I/O (java.nio package) if needed.
 */

/*
----------------------------- 4. Tasks -----------------------------
Practice Tasks: Byte Streams
Copy binary file: Use FileInputStream and FileOutputStream to copy an image.
Buffered performance test: Compare file copy with and without BufferedInputStream/BufferedOutputStream.
Byte array roundtrip: Read a file into ByteArrayOutputStream, then convert to byte array and print.
In-memory processing: Read data from ByteArrayInputStream, manipulate bytes, and write with FileOutputStream.
Write programmatically: Create a ByteArrayOutputStream, write bytes A to Z, and print the result as a String.
-----
Practice Tasks: Character Streams
Read a text file: Use FileReader and print characters one by one.
Line-by-line reader: Use BufferedReader to read lines and count how many start with a specific word.
Write uppercased content: Read a .txt file and write it to another using BufferedWriter, converting text to uppercase.
Char array processing: Use CharArrayWriter to store a string, then read it using CharArrayReader.
CSV processor: Use FileWriter to write a CSV file, then read it with BufferedReader and print selected columns.
Reverse lines: Read a file with BufferedReader, reverse each line, and write with BufferedWriter.
-----
Byte Stream Tasks

FileInputStream
Task 1: Open a binary file (e.g., PNG or PDF) and read it byte-by-byte using read(); count the total bytes.
Task 2: Use read(byte[] b) to read chunks of 1024 bytes from a file and print the number of bytes read in each iteration.
Task 3: Use read(byte[], int, int) to fill a portion of a byte array with file contents starting from offset 2 and read up to 10 bytes.

BufferedInputStream
Task 1: Wrap a FileInputStream using BufferedInputStream and read the entire file using read(byte[], int, int); measure the time taken using System.nanoTime().
Task 2: Create a BufferedInputStream with a small buffer (e.g., 8 bytes) and compare its performance with a large buffer (e.g., 8192 bytes).

ByteArrayInputStream
Task 1: Convert a string to a byte array and read it byte-by-byte using read(); convert each byte back to character and print.
Task 2: Use read(byte[], int, int) to extract specific portions from a byte array.
Task 3: Read a portion, then call reset() and re-read the data to verify reset functionality.

FileOutputStream
Task 1: Write an array of ASCII characters as bytes into a new file using write(byte[]).
Task 2: Use write(byte[], int, int) to write only the last 5 bytes of an array.
Task 3: Open a file with append=true and add a new line of text to the end.

BufferedOutputStream
Task 1: Write a large byte array (e.g., 10000 bytes) to a file using BufferedOutputStream and observe the use of flush() before closing.
Task 2: Write 3 lines of content and use flush() after each to see intermediate writes reflected in the file.

ByteArrayOutputStream
Task 1: Write several strings converted to byte arrays into the stream, then retrieve the result using toByteArray() and toString().
Task 2: Write bytes, call reset(), then write new content; print final output.

Character Stream Tasks

FileReader
Task 1: Read a .txt file character-by-character using read() and count vowels.
Task 2: Use read(char[]) to read chunks of text into a buffer and print each buffer until EOF.
Task 3: Use read(char[], int, int) to skip the first 2 characters in the buffer and read the next 4.

BufferedReader
Task 1: Read lines of a file using readLine() and print only those that start with a capital letter.
Task 2: Read a file line-by-line and count how many lines contain a specific word (e.g., "Java").
Task 3: Combine read(char[], int, int) to read custom-sized chunks from an input stream wrapped in a BufferedReader.

FileWriter
Task 1: Write a string to a .txt file using write(String).
Task 2: Use write(char[], int, int) to write only a specific section of a character array.
Task 3: Use FileWriter(String, true) to append current date and time to a log file.

BufferedWriter
Task 1: Write multiple lines of a poem to a file using newLine() between lines.
Task 2: Write a paragraph and call flush() after every sentence.
Task 3: Use write(char[], int, int) to write selected words to a file, then close it properly.
 */

public class Main {
    public static void main(String[] args) {
    }
}