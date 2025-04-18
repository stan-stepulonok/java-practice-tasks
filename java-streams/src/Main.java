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
/*
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
 */



public class Main {
    public static void main(String[] args) {
    }
}