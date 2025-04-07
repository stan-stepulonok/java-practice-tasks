package Strings.General;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
length(): Returns the length of the string.
charAt(int index): Returns the character at the specified index.
substring(int beginIndex): Extracts a substring from the specified index to the end.
substring(int beginIndex, int endIndex): Extracts a substring from beginIndex to endIndex - 1.
indexOf(String str): Returns the index of the first occurrence of the specified string.
lastIndexOf(String str): Returns the index of the last occurrence of the specified string.
equals(Object obj): Compares the string with another object for equality.
equalsIgnoreCase(String anotherString): Compares two strings, ignoring case differences.
compareTo(String anotherString): Compares two strings lexicographically.
startsWith(String prefix): Checks if the string starts with the specified prefix.
endsWith(String suffix): Checks if the string ends with the specified suffix.
toLowerCase(): Converts the string to lowercase.
toUpperCase(): Converts the string to uppercase.
trim(): Removes leading and trailing spaces.
replace(CharSequence target, CharSequence replacement): Replaces all occurrences of a target with a replacement.
split(String regex): Splits the string based on the specified regular expression.
matches(String regex): Checks if the string matches the specified regular expression.
isEmpty(): Checks if the string is empty.
 */

public class Main {

    public static void main(String[] args) {

        /*
         Task 1: Get String Length
         You are given a string. Print its length.
         Example:
         Input: "Java Programming"
         Output: 16
         */
        System.out.println("Task 1: String length");
        String s1 = "Java Programming";
        System.out.println(s1.length());
        System.out.println();

        /*
        Task 2: Get First and Last Characters
        You are given a string. Print the first and last characters of the string.
        Example:
        Input: "language"
        Output: First: l, Last: e
         */
        System.out.println("Task 2: First/last character");
        String s2 = "language";
        char start = s2.charAt(0);
        char end = s2.charAt(s2.length() - 1);
        System.out.println("Start: " + start + "; End: " + end);
        System.out.println();

        /*
        Task 3: Convert Case
        You are given a string. Print the same string in all uppercase and then all lowercase.
        Example:
        Input: "Java"
        Output:
        JAVA
        java
         */
        System.out.println("Task 3: Upper/lowercase");
        String s3 = "Java";
        System.out.println(s3.toUpperCase());
        System.out.println(s3.toLowerCase());
        System.out.println();

        /*
        Task 4: Extract a Substring
        You are given a string and two integers: start and end. Extract the substring from start to end (exclusive).
        Example:
        Input: "Programming", start = 3, end = 8
        Output: gramm
         */
        System.out.println("Task 4: Substring");
        int indStart = 3, indEnd = 8;
        String s4 = "Programming";
        String subs4 = s4.substring(indStart, indEnd);
        System.out.println(subs4);
        System.out.println();

        /*
        Task 5: Compare Two Strings
        You are given two strings. Check if they are equal (case-sensitive), then again check ignoring case.
        Example:
        Input: "Java" and "java"
        Output:
        Equal (case-sensitive)? false
        Equal (case-insensitive)? true
         */
        System.out.println("Task 5: equals and equalsIgnoreCase");
        String s5Upper = "JAVA";
        String s5lower = "java";
        boolean isEqual = s5Upper.equals(s5lower);
        System.out.println("Equal (case-sensitive)? " + isEqual);
        isEqual = s5Upper.equalsIgnoreCase(s5lower);
        System.out.println();

        /*
        Task 6: Check for a Prefix and Suffix
        Check whether a string starts with a given prefix and ends with a given suffix.
        Example:
        String: "Introduction"
        Prefix: "Intro", Suffix: "tion"
        Output:
        Starts with Intro: true
        Ends with tion: true
         */
        System.out.println("Task 6: startsWith/endsWith");
        String s6 = "Introduction";
        String prefix = "Intro", suffix = "tion";
        System.out.println("Starts with Intro-: " + s6.startsWith(prefix));
        System.out.println("Ends with -tion: " + s6.endsWith(suffix));
        System.out.println();

        /*
        Task 7: Replace a Word
        Replace all occurrences of one word in a sentence with another.
        Example:
        Input: "I love Java", replace "Java" with "Python"
        Output: "I love Python"
         */
        System.out.println("Task 7: replace");
        String s7 = "I love Java and Java123";
        String replacement = "Python";
        String replacedReplace = s7.replace("Java", replacement);
        System.out.println("Replace: " + replacedReplace);
        String replacedReplaceAll = s7.replaceAll("Java[0-9]+", replacement);
        System.out.println("Replace All: " + replacedReplaceAll);
        System.out.println();

        /*
        Task 8: Count Vowels
        Write a method to count how many vowels (a, e, i, o, u) appear in a string.
        Example:
        Input: "education"
        Output: 5
         */
        System.out.println("Task 8: count chars");
        String s8 = "education";
        int count = 0;
        String regex = "[aeiou]";
        Pattern pattern8 = Pattern.compile(regex);
        Matcher matcher8 = pattern8.matcher(s8);
        while (matcher8.find()) {
            count++;
        }
        System.out.println("Num of vowels in education is: " + count);
        System.out.println();

        /*
        Task 9: Remove Spaces
        Remove all spaces from the given string.
        Example:
        Input: " Java is fun "
        Output: "Javaisfun"
         */
        System.out.println("Task 9: remove spaces");
        String s9 = " Java is fun ";
        String regex1 = "[ ]+";
        Pattern pattern9 = Pattern.compile(regex1);
        Matcher matcher9 = pattern9.matcher(s9);
        String replacedString = matcher9.replaceAll("");
        System.out.println("No spaces: " + replacedString);
        System.out.println();

        /*
        Task 10: Find Index of a Word
        Find the position of a word within a sentence.
        Example:
        Input: "I am learning Java"
        Find: "Java"
        Output: 15
         */
        System.out.println("Task 10: Index of word");
        String s10 = "I am learning Java";
        String toFind = "Java";
        int indexOfString = s10.indexOf(toFind);
        System.out.println("Index: " + indexOfString);
        System.out.println();

        /*
        Task 11: Concatenate Strings
        Description:
        You are given two strings.
        Create a new string that contains the first string followed by the second string.
        The final string should not have any extra spaces between the strings.
        Example Input:
        String first = "Java";
        String second = "Programming";
        Expected Output:
        JavaProgramming
         */
        System.out.println("Task 11: Concatenation");
        String s11First = "Java";
        String s11Second = "Programming";
        String resultPlus = s11First + s11Second;
        System.out.println(resultPlus);
        String resultConcat = s11First.concat(s11Second);
        System.out.println(resultConcat);
        System.out.println();

        /*
        Task 12: Censor a Word
        Description:
        Replace all appearances of a given word in a sentence with "***".
        Input: sentence = "This is stupid and that is stupid", word = "stupid"
        Output: "This is *** and that is ***"
         */
        System.out.println("Task 12: Replace a word");
        String s12 = "This is stupid and that is stupid";
        String wordToReplace = "stupid";
        s12 = s12.replaceAll(wordToReplace, "***");
        System.out.println(s12);
        System.out.println();

        /*
        Task 13: Reverse Word Case
        Description:
        Given a sentence, return the same sentence with each word reversed in case (lower becomes upper, upper becomes lower).
        Input: "Hello World"
        Output: "hELLO wORLD"
         */
        System.out.println("Task 13: Reverse Case");
        String toReverseCase = "Hello World";
        String reversedCaseStr = "";
        for (int i = 0; i < toReverseCase.length(); i++) {
            if (toReverseCase.charAt(i) >= 65 &&  toReverseCase.charAt(i) <= 90) {
                reversedCaseStr += (char)(toReverseCase.charAt(i) + 32);
            }
            else if (toReverseCase.charAt(i) >= 97 &&  toReverseCase.charAt(i) <= 122) {
                reversedCaseStr += (char)(toReverseCase.charAt(i) - 32);
            }
            else reversedCaseStr += (char)(toReverseCase.charAt(i));
        }
        System.out.println(reversedCaseStr);
        System.out.println();

        /*
        Task 14: Count Word Occurrences
        Description:
        Count how many times a specific word appears in a sentence.
        Input: "cat dog cat bird cat", word = "cat"
        Output: 3
         */
        System.out.println("Task 14: Count Words");
        String s14 = "cat dog cat bird cat";
        String wordToCount = "cat";
        int countCat = 0;
        String regexSplit = " ";
        String[] splittedStr = s14.split(regexSplit);
        for (int i = 0; i < splittedStr.length; i++) {
            if (splittedStr[i].equals(wordToCount)) {
                countCat++;
            }
        }
        System.out.println("Cat count: " + countCat);
        System.out.println();








    }

}
