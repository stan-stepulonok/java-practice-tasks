package StringBuilder.General;

/*
String constructors:
String(StringBuilder builder): Constructs a new String by copying the contents of the specified StringBuilder.
String(StringBuffer buffer): Constructs a new String by copying the contents of the specified StringBuffer.

StringBuilder constructors:
StringBuilder()	Creates an empty StringBuilder with an initial capacity of 16.
StringBuilder(int capacity)	Creates an empty StringBuilder with the specified initial capacity.
StringBuilder(String str)	Creates a StringBuilder initialized to the contents of the specified string.
StringBuilder(CharSequence seq)	Creates a StringBuilder initialized to the content of the specified CharSequence.

StringBuffer constructors:
StringBuffer()	Creates an empty StringBuffer with an initial capacity of 16.
StringBuffer(int capacity)	Creates an empty StringBuffer with the specified initial capacity.
StringBuffer(String str)	Creates a StringBuffer initialized to the contents of the specified string.
StringBuffer(CharSequence seq)	Creates a StringBuffer initialized to the content of the specified CharSequence.

Methods:
Method	Description
append(String s) - Appends the specified string to the current sequence.
append(Object obj) -	Appends the string representation of the object.
append(char c) - Appends the specified character to the sequence.
insert(int offset, String s) -	Inserts the specified string at the specified position.
insert(int offset, Object obj) -	Inserts the string representation of the object at the specified position.
replace(int start, int end, String s) -	Replaces the characters in a substring with the specified string.
delete(int start, int end) -	Removes the characters in the specified range.
deleteCharAt(int index) -	Removes the character at the specified position.
reverse() -	Reverses the character sequence.
substring(int start) -	Returns a new String containing characters from the specified starting position to the end.
substring(int start, int end) -	Returns a new String containing characters from the specified range.
length() -	Returns the length of the character sequence.
capacity() -	Returns the current capacity of the internal buffer.
setLength(int newLength) -	Sets the length of the character sequence.
charAt(int index) -	Returns the character at the specified index.
setCharAt(int index, char ch) -	Replaces the character at the specified index with the given character.
indexOf(String str) -	Returns the index of the first occurrence of the specified string.
indexOf(String str, int fromIndex) -	Returns the index of the first occurrence of the specified string starting from a given index.
lastIndexOf(String str) -	Returns the index of the last occurrence of the specified string.
lastIndexOf(String str, int fromIndex) -	Returns the index of the last occurrence of the specified string starting backward from a given index.
ensureCapacity(int minimumCapacity) -	Ensures that the internal capacity is at least the specified minimum value.
trimToSize() -	Reduces the internal buffer size to match the current string length.
toString() -	Returns the string representation of the character sequence.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1: Build a Greeting
        Description:
        Use a name and build a full greeting message dynamically.
        Input:
        String name = "Alice";
        Expected Output:
        Hello, Alice! Have a great day!
        */

        System.out.println("Task 1: Create StringBuilder");

        String name1 = "Alice";

        StringBuilder sb1Append = new StringBuilder();
        sb1Append.append("Hello, ").append(name1).append("! Have a great day!");
        System.out.println(sb1Append);

        StringBuilder sb1Replace = new StringBuilder("Hello, <name>! Have a great day!");
        sb1Replace.replace(7, 13, name1);
        System.out.println(sb1Replace);

        StringBuilder sb1Insert = new StringBuilder("Hello, ! Have a great day!");
        sb1Insert.insert(7, name1);
        System.out.println(sb1Insert);

        System.out.println();

        /*
        Task 2: Reverse a Word
        Description:
        Take a word and reverse its characters.
        Input:
        String word = "Builder";
        Expected Output:
        redliuB
         */

        System.out.println("Task 2: Reverse");

        String wordToReverse = "Builder";
        StringBuilder sb2 = new StringBuilder(wordToReverse);
        System.out.println("sb2 Before reverse: " + sb2);

        StringBuilder sb2FromBuilder = new StringBuilder(sb2);
        System.out.println("sb2FromBuilder Before reverse: " + sb2FromBuilder);

        StringBuilder sb2Reversed = sb2.reverse();
        System.out.println("sb2 After reverse (!): " + sb2);
        System.out.println("sb2Reversed After reverse: " + sb2Reversed);
        System.out.println("sb2FromBuilder After reverse: " + sb2FromBuilder);

        System.out.println();

        /*
        Task 3: Insert Middle Name
        Description:
        Given a full name with first and last, insert a middle name in between.
        Input:
        String fullName = "John Smith";
        String middle = "Michael";
        Expected Output:
        John Michael Smith
         */

        System.out.println("Task 3: Insert");

        String fullName3 = "John Smith";
        String middle3 = "Michael";
        int offset = 0;
        for (int i = 0; i < fullName3.length(); i++) {
            if (fullName3.charAt(i) == ' ') {
                offset = i;
                break;
            }
        }
        StringBuilder sb3 = new StringBuilder(fullName3);
        sb3.insert(offset, middle3).insert(offset, " ");
        System.out.println(sb3);

        System.out.println();

        /*
        Task 4: Delete Extra Character
        Description:
        You are given a sentence with an extra character. Remove it.
        Input:
        String sentence = "Helzlo world!";
        Expected Output:
        Hello world!
         */

        System.out.println("Task 4:");

        String sentenceError = "Helzlo world!";
        String sentenceCorrect = "Hello world!";
        StringBuilder sb4 = new StringBuilder(sentenceError);
        for (int i = 0; i < sb4.length(); i++) {
            if (sb4.charAt(i) != sentenceCorrect.charAt(i)) {
                sb4.deleteCharAt(i);
                i -= 1;
            }
        }
        System.out.println(sb4);

        System.out.println();

        /*
        Task 5: Replace Word in Sentence
        Description:
        Replace a word in the sentence using StringBuilder.
        Input:
        String sentence = "I like apples.";
        Replace "apples" with "oranges"
        Expected Output:
        I like oranges.
         */

        System.out.println("Task 5:");

        String sentenceToUpdate = "I like apples.";
        String replace = "apples";
        String replacement = "oranges";

        int replaceStartIndex = sentenceToUpdate.indexOf(replace);
        int replaceEndIndex = replaceStartIndex + replace.length();

        StringBuilder sb5 = new StringBuilder(sentenceToUpdate);

        sb5.replace(replaceStartIndex,replaceEndIndex, replacement);
        System.out.println(sb5);

        System.out.println();

        /*
        Task 6:Count Vowels
        Description:
        Build a string of vowels found in a word in order.
        Input:
        String word = "Application";
        Expected Output:
        Aio
        (Only the vowels in the order they appear.)
         */

        System.out.println("Task 6: ");

        String wordWithConsonants = "Application";
        String regex = "aeiouAEIOU";

        String wordWithVowels = "";
        StringBuilder sb6 = new StringBuilder(wordWithVowels);

        for (int i = 0; i < wordWithConsonants.length(); i++) {
            String charToStr = String.valueOf(wordWithConsonants.charAt(i));
            if (regex.contains(charToStr)) {
                sb6.append(charToStr);
            }
        }

        wordWithVowels = new String(sb6);
        System.out.println(wordWithVowels);

        System.out.println();

        /*
        Task 7: Mirror String
        Description:
        Take a word and append its reverse to itself.
        Input:
        String word = "Cat";
        Expected Output:
        Cattac
         */

        System.out.println("Task 7:");

        String toMirror = "Cat";
        StringBuilder sb7Reversed = new StringBuilder(toMirror.toLowerCase()).reverse();
        StringBuilder sb7Full = new StringBuilder(toMirror).append(sb7Reversed);
        System.out.println(sb7Full);
        System.out.println();

        /*
        Task 8: Capitalize First Letter
        Description:
        Given a lowercase name, capitalize only the first letter using StringBuilder.
        Input:
        String name = "emma";
        Expected Output:
        Emma
         */

        System.out.println("Task 8:");

        String name = "emma";
        StringBuilder sb8 = new StringBuilder();
        sb8.append(name.toUpperCase().charAt(0)).append(name).deleteCharAt(1);
        System.out.println(sb8);
        System.out.println();





    }

}
