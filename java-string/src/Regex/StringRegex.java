package Regex;

import java.util.ArrayList;
import java.util.Arrays;

public class StringRegex {

    public static void main(String[] args) {

        String regex = "";
        boolean result = false;

        /*
        Task 1 – Match only digits
        Input: "123456"
        Expected Output: true
        Input: "123abc"
        Expected Output: false
         */
        System.out.println("Task 1: matches()");
        regex = "[0-9]+";
        String s1T = "123456";
        result = s1T.matches(regex);
        System.out.println("[0-9] -> 123456 = " + result);
        String s1F = "123abc";
        result = s1F.matches(regex);
        System.out.println("[0-9] -> 123abc = " + result);
        System.out.println();

        /*
        Task 2 – Split a sentence by spaces
        Input: "Java is powerful"
        Expected Output: ["Java", "is", "powerful"]
         */
        System.out.println("Task 2: split()");
        regex = "[ ]+";
        String s2 = "Java is powerful";
        String[] splittedString = s2.split(regex);
        String splittedStringToStr = Arrays.toString(splittedString);
        System.out.println(splittedStringToStr);
        System.out.println();

        /*
        Task 3 – Remove all digits from a string
        Input: "abc123xyz"
        Expected Output: "abcxyz"
         */
        System.out.println("Task 3: replaceAll()");
        regex = "\\d+";
        String s3 = "abc123xyz";
        s3 = s3.replaceAll(regex, "");
        System.out.println(s3);
        System.out.println();

        /*
        Task 4 – Keep only lowercase letters
        Input: "Hello123World"
        Expected Output: "elloorld"
         */
        System.out.println("Task 4: replaceAll()");
        regex = "^[a-z]+";
        String s4 = "Hello123World";
        s4 = s4.replaceAll(regex, "");
        System.out.println(s4);
        System.out.println();

        /*
        Task 5 – Replace multiple spaces with a single space
        Input: "  Java    is fun   "
        Expected Output: "Java is fun"
         */
        System.out.println("Task 5: replaceAll()");
        regex = "[ ]{2,}";
        //regex = "\\s{2,}";
        String s5 = "  Java    is fun   ";
        s5 = s5.replaceAll(regex, " ").trim();
        System.out.println(s5);
        System.out.println();

        /*
        Task 6 – Check if a string is a valid email
        Input: "name@example.com"
        Expected Output: true
        Input: "name@.com"
        Expected Output: false
         */
        System.out.println("Task 6: matches()");
        regex = "[a-zA-Z0-9!#$%^&?;:()]+@[a-zA-Z0-9]+\\.[a-zA-Z]{1,3}\\.?[a-zA-Z]*";
        //regex = "[\\w.-]+@[\\w-]+\\.[a-zA-Z]{2,6}";
        String s6 = "name@example.com";
        result = s6.matches(regex);
        System.out.println("[a-zA-Z0-9!#$%^&?;:()]+@[a-zA-Z0-9]+\\.[a-zA-Z]{1,3}\\.?[a-zA-Z]* -> name@example.com = " + result);
        System.out.println();

        /*
        Task 7 – Split on commas and optional spaces
        Input: "apple, banana ,cherry , mango"
        Expected Output: ["apple", "banana", "cherry", "mango"]
         */
        System.out.println("Task 7: split()");
        regex = " *,+ *";
        //regex = "\\s*,\\s*";
        String s7 = "apple, banana ,cherry , mango";
        String[] fruitsArray = s7.split(regex);
        for (String fruit : fruitsArray) {
            System.out.print(fruit + " ");
        }
        System.out.println("\n");

        /*
        Task 8 – Replace all vowels with *
        Input: "Regular Expressions"
        Expected Output: "R*g*l*r *xpr*ss**ns"
         */
        System.out.println("Task 8: replaceAll()");
        regex = "[aieouAIEOU]+";
        //regex = "(?i)[aeiou]";
        // (?i) - This is an inline flag that enables case-insensitive matching
        String s8 = "Regular Expressions";
        s8 = s8.replaceAll(regex, "*");
        System.out.println(s8);
        System.out.println();

        /*
        Task 9 – Check if a string contains only letters (upper or lower)
        Input: "Java"
        Expected Output: true
        Input: "Java123"
        Expected Output: false
         */
        System.out.println("Task 9: matches()");
        regex = "[A-Za-z]+";
        String s9 = "Java";
        result = s9.matches(regex);
        System.out.println("[A-Za-z]+ -> Java = " + result);
        s9 = "Java123";
        result = s9.matches(regex);
        System.out.println("[A-Za-z]+ -> Java123 = " + result);
        System.out.println();

        /*
        Task 10 – Find all words that start with 'un'
        Input: "unknown universe unity unrelated"
        Expected Output: ["unknown", "universe", "unity", "unrelated"]
         */
        System.out.println("Task 10: split()");
        regex = "\\b([Uu][Nn][A-Za-z]+)\\b";
        String s10 = "uNknown Universe nart unity uxa unrelated";
        ArrayList<String> unWords = new ArrayList<>();
        String[] splitteds10 = s10.split(" ");
        for (int i = 0; i < splitteds10.length; i++) {
            if (splitteds10[i].matches(regex)) {
                unWords.add(splitteds10[i]);
            }
        }
        System.out.println(unWords);
        System.out.println();

    }

}
