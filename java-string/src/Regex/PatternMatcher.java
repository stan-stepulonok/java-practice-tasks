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
        System.out.println("Task 5:");
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
        System.out.println("Task 6: Mathcher - relaceAll()");
        regex = "[\\W\\s]+";
        // regex = "[^A-Za-z]+";
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
        System.out.println("Task 7:");
        String s7 = "Loving the #sunshine and #beach vibes! #vacation";
        regex = "#[A-Za-z0-9]+";
        // regex = "#[A-Za-z0-9_]+";
        ArrayList<String> hashTags = new ArrayList<>();
        Pattern p7 = Pattern.compile(regex);
        Matcher m7 = p7.matcher(s7);
        while (m7.find()) {
            hashTags.add(m7.group());
        }
        System.out.println(s7);
        System.out.println(hashTags);
        System.out.println();

        /*
        Task 8 – Check if a string contains a valid date in format YYYY-MM-DD
        Input: "The deadline is 2025-12-15"
        Expected Output: true
        Input: "Date: 2025-13-40"
        Expected Output: false
         */
        System.out.println();
        String s8 = "The deadline is 2025-12-15";
        regex = "(([1-9])|([1-9][0-9])|([1-9][0-9]{2})|([1-9][0-9]{3}))-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1]))";
        Pattern p8 = Pattern.compile(regex);
        Matcher m8 = p8.matcher(s8);
        System.out.println(s8 + " -> " + m8.find());
        s8 = "Date: 2025-13-40";
        m8.reset(s8);
        System.out.println(s8 + " -> " + m8.find());
        System.out.println();

        /*
        Task 9 – Find all duplicate words (case-insensitive)
        Input: "This is is a test Test"
        Expected Output: ["is", "Test"]
        (Hint: You’ll probably use (?i)\b(\w+)\b.*\b\1\b with a loop)
         */

        // ????????

        /*
        Task 10 – Extract domain names from URLs
        Input: "Visit https://openai.com and http://example.org now!"
        Expected Output: ["openai.com", "example.org"]
         */
        System.out.println("Task 10");
        String s10 = "Visit https://openai.com and http://example.org now!";
        regex = "https?://([a-zA-Z0-9-@+=!#$%]+\\.[a-zA-Z]{1,3}\\.?[a-zA-Z]{0,3})";
        Pattern p10 = Pattern.compile(regex);
        Matcher m10 = p10.matcher(s10);
        ArrayList<String> domains = new ArrayList<>();
        while (m10.find()) {
            domains.add(m10.group(1));
        }
        System.out.println(domains);
        System.out.println();

        /*
        Task 11 – Reuse a Pattern with multiple strings using reset()
        Input strings: "User: alice" , "User: bob42", "User: carol_smith"
        Goal: Match the username part only (after "User: "), by reusing the same matcher with reset().
        Expected Output:
        alice
        bob42
        carol_smith
        */
        System.out.println("Task 11: reset()");
        regex = "^User: ([a-zA-Z0-9_]+)$";
        String s11 = "User: alice";
        ArrayList<String> users = new ArrayList<>();
        Pattern p11 = Pattern.compile(regex);
        Matcher m11 = p11.matcher(s11);
        m11.find();
        users.add(m11.group(1));
        s11 = "User: bob42";
        m11.reset(s11).find();
        users.add(m11.group(1));
        s11 = "User: carol_smith";
        m11.reset(s11).find();
        users.add(m11.group(1));
        System.out.println(users);
        System.out.println();

        /*
        Task 12 – Extract named groups from a full name
        Input: "Full name: John A. Smith"
        Goal: Use named groups to extract:
        First name ( John)
        Middle initial (optional, like A.)
        Last name ( Smith)
         */
        System.out.println("Task 12: named groups <name>");
        String s12 = "Full name: John A. Smith";
        String firstName = "", lastName = "", middleInitial = "";
        regex = "^Full name: (?<firstName>[A-Za-z]+) (?<middleInitial>[A-Za-z]+.) (?<lastName>[A-Za-z]+)$";
        //^Full name: (?<firstName>[A-Z][a-z]+)\s(?<middleInitial>[A-Z]\.)?\s(?<lastName>[A-Z][a-z]+)$
        Pattern p12 = Pattern.compile(regex);
        Matcher m12 = p12.matcher(s12);
        if (m12.find()) {
            firstName = m12.group("firstName");
            middleInitial = m12.group("middleInitial");
            lastName = m12.group("lastName");
        }
        System.out.println("First name: " + firstName);
        if (!middleInitial.isEmpty()) {
            System.out.println("Middle initial: " + middleInitial);
        }
        System.out.println("Last name: " + lastName);
        System.out.println();

        /*
        Task 13 – Validate password using lookahead
        Input: "MyPa$$w0rd"
        Goal: Ensure password has:
        At least one digit
        At least one uppercase letter
        At least one special character ( @#$%^&+=)
        At least 8 characters
         */
        System.out.println("Task 13: positive lookahead");
        String s13 = "MyPa$$w0rd";
        regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
        System.out.println(Pattern.matches(regex, s13));
        System.out.println();

        /*
        Task 14 – Find words not preceded by “#” (using negative lookbehind)
        Input: "Check #this and that and #another"
        Goal: Find all words that are not hashtags (ie not preceded by #)
         */
        System.out.println("Task 14: negative lookbehind");
        String s14 = "Check #this and that and #another";
        ArrayList<String> nonTaggedWords = new ArrayList<>();
        regex = "\\b(?<!#)[A-Za-z]+\\b";
        Pattern p14 = Pattern.compile(regex);
        Matcher m14 = p14.matcher(s14);
        while (m14.find()) {
            nonTaggedWords.add(m14.group());
        }
        System.out.println(nonTaggedWords);
        System.out.println();

        /*
        Task 15 – Find prices only followed by a space (using positive lookahead)
        Input: "Price: $12.50 and discounted $10.00! Not valid: $20.00,"
        Goal: Extract dollar amounts only when followed by a space (not punctuation)
         */
        System.out.println("Task 15: positive lookahead");
        String s15 = "Price: $12.50 and discounted $10.00! Not valid: $20.00,";
        regex = "\\$([0-9]+\\.[0-9]{2})(?= )";
        Pattern p15 = Pattern.compile(regex);
        Matcher m15 = p15.matcher(s15);
        ArrayList<Double> prices = new ArrayList<>();
        while (m15.find()) {
            prices.add(Double.valueOf(m15.group(1)));
        }
        System.out.println(prices);
        System.out.println();

        /*
        Task 16 – Extract parts of a phone number using numbered groups
        Input :"Call me at (123) 456-7890 or at (987) 654-3210"
        Goal : Extract:
        Area code
        First 3 digits
        Print each match as` Area : 123 , Prefix : 456 , Line :Last 4 digits
        Print each match as:
        Area: 123, Prefix: 456, Line: 7890
         */
        System.out.println("Task 16:");
        String s16 = "Call me at (123) 456-7890 or at (987) 654-3210";
        regex = "\\((\\d{3})\\) (\\d{3})-(\\d{4})";
        Pattern p16 = Pattern.compile(regex);
        Matcher m16 = p16.matcher(s16);
        while (m16.find()) {
            System.out.println("----- Number: -----");
            System.out.println("Area: " + m16.group(1));
            System.out.println("Prefix: " + m16.group(2));
            System.out.println("Line: " + m16.group(3));
        }
        System.out.println();

        /*
        Task 17 – Use named groups to parse a date
        Input :"Event is scheduled for 2025-12-31"
        Goal : Extract year, month, and day using named groups:
        Year: 2025, Month: 12, Day: 31
         */
        System.out.println("Task 17: ");
        String s17 = "Event is scheduled for 2025-12-31";
        regex = "(?<year>\\d{4})-(?<month>0[1-9]|1[0-2])-(?<day>0[1-9]|[1-2][0-9]|3[0-1])";
        Pattern p17 = Pattern.compile(regex);
        Matcher m17 = p17.matcher(s17);
        int year = 1980, month = 1, day = 1;
        if (m17.find()) {
            year = Integer.valueOf(m17.group("year"));
            month = Integer.valueOf(m17.group("month"));
            day = Integer.valueOf(m17.group("day"));
        }
        System.out.println("Year: " + year + ", Month: " + month + ", Day: " + day);
        System.out.println();

        /*
        Task 18 – Extract all valid variable names using lookaheads and groups
        Input :"int valid_name = 5; int 9invalid = 2; int _alsoValid = 10;"
        Goal : Extract only the variable names that:
        Start with a letter or underscore
        Followed by letters, digits, or underscores
        Regex hint : Use a positive lookahead to ensure valid pattern to ensure valid pattern and group to extract the name.
         */
        System.out.println("Task 18: lookaheads");
        String s18 = "int valid_name = 5; int 9invalid = 2; int _alsoValid = 10;";
        ArrayList<String> validNamedVariables = new ArrayList<>();
        regex = "(?<variable>\\b(?=[a-z_])[a-zA-Z0-9_]+)\\b ?=";
        Pattern p18 = Pattern.compile(regex);
        Matcher m18 = p18.matcher(s18);
        while (m18.find()) {
            validNamedVariables.add(m18.group("variable"));
        }
        System.out.println(validNamedVariables);
        System.out.println();

        /*
        Task 19 – Validate a hex color using lookahead and group capture
        Input : "#1a2b3c", "#ABCDEF","#12345"
        Goal : Validate strings that:
        Start with#
        Followed by exactly 6 hex digits (a-fA-F0-9)
        Use a positive lookahead for total length and a numbered group for the color
        Expected matches:
        Valid: #1a2b3c
        Valid: #ABCDEF
        Invalid: #12345
         */
        System.out.println("Task 19: ");
        String s19Col1 = "#1a2b3c", s19Col2 =  "#ABCDEF", s19Col3 = "#12345";
        regex = "^#[a-fA-F0-9]{6}$"; //why lookaheads and groups???
        String resultHexColorCheck1 = "Invalid";
        if (Pattern.matches(regex, s19Col1)) {
            resultHexColorCheck1 = "Valid";
        }
        System.out.println(resultHexColorCheck1 + ": " + s19Col1);
        String resultHexColorCheck2 = "Invalid";
        if (Pattern.matches(regex, s19Col2)) {
            resultHexColorCheck2 = "Valid";
        }
        System.out.println(resultHexColorCheck2 + ": " + s19Col2);
        String resultHexColorCheck3 = "Invalid";
        if (Pattern.matches(regex, s19Col3)) {
            resultHexColorCheck3 = "Valid";
        }
        System.out.println(resultHexColorCheck3 + ": " + s19Col3);
        System.out.println();

        /*
        Task 20 – Extract all numbers not followed by a % sign (negative lookahead + group)
        Input :"85% of people agree, 100 voted, 42% disagree, 300 total"
        Goal : Find numbers not followed by% , eg 100, 300
        100
        300
         */
        System.out.println("Task 20: ");
        String s20 = "85% of people agree, 100 voted, 42% disagree, 300 total";
        regex = "\\b\\d+(?!%)\\b";
        ArrayList<Integer> nonPercentNumbers = new ArrayList<>();
        Pattern p20 = Pattern.compile(regex);
        Matcher m20 = p20.matcher(s20);
        while (m20.find()) {
            nonPercentNumbers.add(Integer.valueOf(m20.group()));
        }
        System.out.println(nonPercentNumbers);
        System.out.println();


    }

}
