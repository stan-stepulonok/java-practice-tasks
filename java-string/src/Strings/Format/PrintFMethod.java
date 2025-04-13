package Strings.Format;

/*
System.out.printf() is used to format output. It's like System.out.print() but allows formatted strings, using format specifiers.
System.out.printf("format string", arguments...);
Specifier	Description	Example Output
%s	String	"Java"
%d	Integer (decimal)	42
%f	Floating-point (decimal)	3.14
%n	New line	(new line)
%c	Character	'A'
%.2f	Floating-point with 2 decimals	3.14
%10s	Right-align string in 10 characters	" Java"
%-10s	Left-align string in 10 characters	"Java "
 */

public class PrintFMethod {

    public static void main(String[] args) {
        /*
        Task 1: Greet with a Name
        Input:
        String name1 = "John";
        Goal: Print: Hello, John! using printf.
         */
        System.out.println("Task 1:");
        String name1 = "John";
        System.out.printf("Hello, %s!%n", name1);
        System.out.println();

        /*
        Task 2: Print Age and Country
        Inputs:
        String name2 = "Maria";
        int age2 = 28;
        String country2 = "Spain";
        Goal:
        Print something like:
        Maria is 28 years old and lives in Spain.
         */
        System.out.println("Task 2:");
        String name2 = "Maria";
        int age2 = 28;
        String country2 = "Spain";
        System.out.printf("%s is %d years old and lives in %s.%n", name2, age2, country2);
        System.out.println();

        /*
        Task 3: Display a Price
        Input:
        double price = 12.3456;
        Goal:
        Print it like:
        Price: $12.35
         */
        System.out.println("Task 3:");
        double price3 = 12.3456;
        System.out.printf("Price: $%.2f%n", price3);
        System.out.println();

        /*
        Task 4: Tabular Output (Alignment)
        Input:
        String product1 = "Apple", product2 = "Banana";
        int price1 = 3, price2 = 5;
        Goal:
        Product    Price
        Apple        3
        Banana       5
         */
        System.out.println("Task 4:");
        String product1 = "Apple", product2 = "Banana";
        int price1 = 3, price2 = 5;
        System.out.println("Product    Price");
        System.out.printf("%s%9d%n", product1, price1);
        System.out.printf("%s%8d%n", product2, price2);
        System.out.println();

        /*
        Task 5: Character Info
        Input:
        char grade = 'A';
        String subject = "Math";
        Goal:
        Print: Grade in Math: A
         */
        System.out.println("Task 5:");
        char grade = 'A';
        String subject = "Math";
        System.out.printf("Grade in %s: %c%n", subject, grade);
        System.out.println();

        /*
        Task 6: Format Name in a Box
        Input:
        String name = "Emma";
        Goal:
        Print:
        +----------+
        |    Emma  |
        +----------+
        (Hint: Use %10s with |)
         */
        System.out.println("Task 6:");
        String name = "Emma";
        System.out.println("+----------+");
        System.out.printf("|%7s   |%n", name);
        System.out.println("+----------+");
        System.out.println();
    }

}
