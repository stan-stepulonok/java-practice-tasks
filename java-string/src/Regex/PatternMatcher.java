package Regex;

/*
Pattern Class

Constructors:
public static Pattern compile(String regex);
public static Pattern compile(String regex, int flags);

Main Methods:
static Pattern compile(String regex): Compiles a regex pattern.
Matcher matcher(CharSequence input): Creates a matcher for the given input.
String[] split(CharSequence input): Splits the input around matches of the pattern.
static boolean matches(String regex, CharSequence input): Checks if the entire input matches the regex.
String pattern(): Returns the regex as a string.
 */

/*
Matcher Class

Constructors:
The Matcher class does not have public constructors.
Matchers are created by invoking the matcher method of a Pattern object.

Main Methods:
boolean matches(): Checks if the entire input matches the pattern.
boolean find(): Attempts to find the next subsequence that matches the pattern.
boolean find(int start): Starts the search from a specified index.
String group(): Returns the last matched subsequence.
int start(): Returns the start index of the last match.
int end(): Returns the end index of the last match.
int groupCount(): Returns the number of capturing groups in the pattern.
String replaceAll(String replacement): Replaces every match in the input with the specified string.
 */

/*
Special Characters: Regex uses special characters like . (any character), * (zero or more), + (one or more), ? (optional), etc.
Escape these characters with a backslash (\) if you need to match them literally.

Flags: Flags like CASE_INSENSITIVE, MULTILINE, and DOTALL can be used to modify the regex behavior.

Character Classes:
[abc]: Matches any character inside the brackets.
[^abc]: Matches any character not inside the brackets.
[a-z]: Matches a range of characters.

Quantifiers:
*: Matches zero or more occurrences.
+: Matches one or more occurrences.
?: Matches zero or one occurrence.
{n}: Matches exactly n occurrences.
{n,}: Matches at least n occurrences.
{n,m}: Matches between n and m occurrences.

Anchors:
^: Matches the start of the input.
$: Matches the end of the input.
Groups: Parentheses () are used to create capturing groups for extracting matched substrings.
Non-capturing Groups: Use (?:...) to group without capturing.
\b: Matches a word boundary.
\B: Matches a position that is not a word boundary.
Use \b to match word boundaries -> \b[a-zA-Z0-9]+\b -> String regex = "\\b\\w+\\b"; OR String regex = "\\b[a-zA-Z0-9]+\\b";
Pattern pattern = Pattern.compile("\\bword\\b", Pattern.CASE_INSENSITIVE);

Groups and Captures
(abc): Defines a group to capture abc.
(?:abc): Defines a non-capturing group for abc.
(?<name>abc): Defines a named group to capture abc with the name name.
Regex: (ab)(cd) String: "abcd"
Group 1: "ab"
Group 2: "cd"
In Java, you can access these groups using matcher.group(1) and matcher.group(2).
String regex = "(ab)(cd)";
String input = "abcd";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(input);
if (matcher.find()) {
    System.out.println("Group 1: " + matcher.group(1)); // Output: ab
    System.out.println("Group 2: " + matcher.group(2)); // Output: cd
}
Another example, in the regex (\d{3})(\d{2})(\d{4}), the digits will be captured in three separate groups:
Group 1: First three digits
Group 2: Next two digits
Group 3: Last four digits
Non-Capturing Groups
If you don’t need to capture a part of the pattern for later use, you can use non-capturing groups with (?:...).
Named Groups
Regex: (?<firstName>\w+)\s(?<lastName>\w+) String: "John Doe"
Group firstName: "John"
Group lastName: "Doe"
String regex = "(?<firstName>\\w+)\\s(?<lastName>\\w+)";
String input = "John Doe";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(input);
if (matcher.find()) {
    System.out.println("First Name: " + matcher.group("firstName")); // Output: John
    System.out.println("Last Name: " + matcher.group("lastName"));   // Output: Doe
}

Alternation
a|b: Matches either a or b.

Escape Sequences
\: Escapes special characters (e.g., \. matches a literal dot).
Special characters to escape: . ^ $ * + ? { } [ ] \ | ( )

Predefined Character Classes:
.: Matches any character except a newline (\n).
\d: Matches any digit (equivalent to [0-9]).
\D: Matches any non-digit (equivalent to [^0-9]).
\w: Matches any word character (letters, digits, or _).
\W: Matches any non-word character (anything not in \w).
\s: Matches any whitespace (spaces, tabs, line breaks).
\S: Matches any non-whitespace character.

Lookaheads and Lookbehinds
These are called "zero-width assertions", which means they check for conditions ahead or behind a certain point without consuming any characters in the string.
Lookaheads:
Lookahead checks if something comes after a certain point, without including it in the match.
(?=abc): Positive lookahead. Matches if abc follows the current position.
(?!abc): Negative lookahead. Matches if abc does not follow.
\w+(?=\d) - positive
Matches a word (\w+) only if it is followed by a digit.
"abc1" → matches "abc" ✅
"abc" → no match ❌
\w+(?!\d) - negative (reversed to previous)
Lookbehinds:
(?<=abc): Positive lookbehind. Matches if abc precedes the current position.
(?<!abc): Negative lookbehind. Matches if abc does not precede.
(?<=\$)\d+
Matches digits only if they are preceded by a dollar sign.
"Price: $100" → matches "100" ✅
"Price: 100" → no match ❌

Greedy vs. Reluctant Quantifiers
Greedy: Matches as much as possible (.*).
Reluctant: Matches as little as possible (.*?).

Logical Operators in Character Classes
1. Intersection (&&)
[a-z&&[^i-n]]
[a-z]: Matches all lowercase letters.
[^i-n]: Excludes the range i to n.
[a-z&&[^i-n]]: Matches all lowercase letters except those between i and n.
2. Union (| or no operator)
[a-zA-Z]
Matches any lowercase (a-z) or uppercase (A-Z) letter.
3. Symmetric Difference (^ inside [])

Best Practices:
Always test your regex patterns with different cases to ensure correctness.
Use Pattern.compile() for repeated use of the same regex to improve performance.
Avoid excessive use of quantifiers like .* to prevent performance issues with long inputs.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

    public static void main(String[] args) {

        String regex = "";
        boolean result;

        /*
        Task 1 – Find all digits in a string
        Input: "Order #12345 was shipped on 2024-06-21."
        Expected Output: ["1", "2", "3", "4", "5", "2", "0", "2", "4", "0", "6", "2", "1"]
         */
        System.out.println("Task 1: Matcher");
        regex = "([\\d])";
        String s1 = "Order #12345 was shipped on 2024-06-21.";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(s1);
        ArrayList<String> nums1 = new ArrayList<>();
        while (m1.find()) {
            nums1.add(m1.group());
        }
        System.out.println(s1);
        System.out.println(nums1);
        System.out.println();

        /*
        Task 2 – Extract all words starting with capital letters
        Input: "Alice went to Wonderland and met the Mad Hatter"
        Expected Output: ["Alice", "Wonderland", "Mad", "Hatter"]
         */
        System.out.println("Task 2: Matcher");
        regex = "\\b[A-Z]+\\w*\\b";
        String s2 = "Alice went to Wonderland and met the Mad Hatter";
        Pattern p2 = Pattern.compile(regex);
        Matcher m2 = p2.matcher(s2);
        ArrayList<String> arrList = new ArrayList<>();
        while (m2.find()) {
            arrList.add(m2.group());
        }
        System.out.println(s2);
        System.out.println(arrList);
        System.out.println();

        /*
        Task 3 – Check if the entire string is a valid IPv4 address
        Input: "192.168.1.1"
        Expected Output: true
        Input: "256.100.10.50"
        Expected Output: false
         */
        System.out.println("Task 3: matches()");
        //IPv4 addresses are usually represented in dot-decimal notation, consisting of four decimal numbers, each ranging from 0 to 255, separated by dots
        regex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}"
                + "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";
        String s3 = "192.168.1.1";
        result = Pattern.matches(regex, s3);
        System.out.println("regex -> 192.168.1.1 = " + result);
        System.out.println();

        /*
        Task 4 – Count how many times "Java" appears as a whole word
        Input: "Java is fun. I like JavaScript, but Java more."
        Expected Output: 2
         */
        System.out.println("Task 4: ");
        regex = "\\bjava\\b";
        String s4 = "Java is fun. I like JavaScript, but Java more.";
        int javaCount = 0;
        Pattern p4 = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m4 = p4.matcher(s4);
        while (m4.find()) {
            javaCount++;
        }
        System.out.println("Java is fun. I like JavaScript, but Java more. -> Java mentioned " + javaCount + " times.");
        System.out.println();

        /*
        Task 5 – Extract email addresses from a paragraph
        Input: "Contact us at support@example.com or admin@domain.org."
        Expected Output: ["support@example.com", "admin@domain.org"]
         */
        System.out.println("Task 6:");
        regex = "\\b[a-zA-Z0-9.-]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+\\.?[a-zA-Z0-9]*\\b";
        String s5 = "Contact us at support@example.com or admin@domain.org.";
        Pattern p5 = Pattern.compile(regex);
        Matcher m5 = p5.matcher(s5);
        ArrayList<String> emails5 = new ArrayList<>();
        while (m5.find()) {
            emails5.add(m5.group());
        }
        System.out.println(s5);
        System.out.println(emails5);
        System.out.println();

        /*
        Task 6 – Replace all non-alphabetic characters with space
        Input: "Hello, world! Let's code in Java 17."
        Expected Output: "Hello world Let s code in Java "
        (Note: You’ll likely use matcher.replaceAll() here)
         */
        System.out.println("Task 7: Mathcher - relaceAll()");
        regex = "[\\W\\s]+";
        String s6 = "Hello, world! Let's code in Java 17.";
        Pattern p6 = Pattern.compile(regex);
        Matcher m6 = p6.matcher(s6);
        String replaced = m6.replaceAll(" ");
        System.out.println(s6);
        System.out.println(replaced);
        System.out.println();

        /*
        Task 7 – Extract all hashtags from a social media post
        Input: "Loving the #sunshine and #beach vibes! #vacation"
        Expected Output: ["#sunshine", "#beach", "#vacation"]
         */
        System.out.println("task 7:");
        String s7 = "Loving the #sunshine and #beach vibes! #vacation";
        regex = "#[A-Za-z0-9]+";
        ArrayList<String> hashTags = new ArrayList<>();
        Pattern p7 = Pattern.compile(regex);
        Matcher m7 = p7.matcher(s7);
        while (m7.find()) {
            hashTags.add(m7.group());
        }
        System.out.println(s7);
        System.out.println(hashTags);
        System.out.println();



    }

}
