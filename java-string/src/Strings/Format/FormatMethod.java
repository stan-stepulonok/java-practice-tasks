package Strings.Format;

/*
Under the Hood:
Both use Formatter internally.

String:
static String format(String format, Object... args): Formats the string using the specified format and arguments.
Use %s for string values.
Use %d for integers.
Use %f for floating-point values; precision can be specified (e.g., %.2f).
Use %c for single characters.
Use %b for boolean values.
Escape % with %% if a literal percent sign is needed.
Argument indexing is supported: %1$s refers to the first argument as a string, %2$d refers to the second as an integer, etc.
 */

public class FormatMethod {

    public static void main(String[] args) {

        /*
        Task 1: Format a Greeting
        Description:
        Create a formatted string using a name and a city. Use String.format() to return this message:
        Expected Output:
        Hello Alice, welcome to Paris!
        Input:
        String name = "Alice";
        String city = "Paris";
         */
        System.out.println("Task 1:");
        String name1 = "Alice";
        String city1 = "Paris";
        String result1 = "Hello %s, welcome to %s!%n";
        result1 = String.format(result1, name1, city1);
        System.out.println(result1);

        /*
        Task 2: Format an Integer with Padding
        Description:
        Given a number, create a string that represents the number in a 5-character-wide field, padded with zeros.
        Input:
        int number = 42;
        Expected Output:
        00042
         */
        System.out.println("Task 2:");

        int number2 = 42;
        String resultFormatHardcoded = "%05d";
        resultFormatHardcoded = String.format(resultFormatHardcoded, number2);
        System.out.println(resultFormatHardcoded);
        System.out.println();

        /*
        Task 3: Format a Floating-Point Number
        Description:
        Given a decimal number, create a string that formats it to 2 decimal places.
        Input:
        double price = 5.6789;
        Expected Output:
        5.68
         */
        System.out.println("Task 3:");
        double price = 5.6789;
        String result3 = "%.2f";
        result3 = String.format(result3, price);
        System.out.println(result3);
        System.out.println();

        /*
        Task 4: Format a Table Row
        Description:
        Format data into aligned columns using fixed widths. The string should align the name to the left and the score to the right.
        Input:
        String name = "John";
        int score = 95;
        Expected Output:
        Name: John Score: 95
        (Assume name uses 12 characters width, score uses 10.)
         */
        System.out.println("Task 4:");
        String name41 = "Johny";
        int score41 = 95;
        String player41 = "Name: %12s | Score: %10d";
        player41 = String.format(player41, name41, score41);
        String name42 = "John";
        int score42 = 100;
        String player42 = "Name: %12s | Score: %10d";
        player42 = String.format(player42, name42, score42);
        System.out.println(player41);
        System.out.println(player42);
        System.out.println();

        /*
        Task 5: Add Leading Spaces
        Description:
        Return a string version of an integer that is right-aligned in a field of 6 characters (with leading spaces).
        Input:
        int id = 77;
        Expected Output:
        77 (4 spaces before the number)
         */
        System.out.println("Task 5:");
        int id = 77;
        String result5 = "%6d";
        result5 = String.format(result5, id);
        System.out.println(result5);
        System.out.println();

        /*
        Task 6: Combine Multiple Values
        Description:
        Create a string with three values (string, int, float) all formatted correctly into one sentence.
        Input:
        String product = "Apples";
        int quantity = 3;
        double cost = 1.25;
        Expected Output:
        You bought 3 Apples for $1.25 each.
         */
        System.out.println("Task 6:");
        String product = "Apples";
        int quantity = 3;
        double cost = 1.25;
        String result6 = "You bought %d %s for $%.2f each.";
        result6 = String.format(result6, quantity, product, cost);
        System.out.println(result6);
        System.out.println();

        /*
        Task 7: Display Percentage
        Description:
        You are given a double. Format it to 1 decimal place and add a percent sign.
        Input:
        double ratio = 0.845;
        Expected Output:
        84.5%
         */
        System.out.println("Task 7:");
        double ratio = 0.845;
        ratio *= 100;
        String result7 = "%.1f%%";
        result7 = String.format(result7, ratio);
        System.out.println(result7);
        System.out.println();

        /*
        Task 8: Format with Unicode
        Description:
        Insert a Unicode heart symbol in a formatted message.
        Input:
        String user = "Emma";
        Expected Output:
        Emma \u2665 Java → when printed: Emma ♥ Java
         */
        System.out.println("Task 8:");
        String user = "Emma";
        String result8 = "%s \u2665 Java";
        result8 = String.format(result8, user);
        System.out.println(result8);

    }

}
