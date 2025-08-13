/*

-------- 1. Functional Interface --------
Description:
- A functional interface is an interface that has exactly one abstract method.
- Abstract methods define the contract that a lambda expression will implement.
- Functional interfaces are the foundation for lambdas in Java.
- Functional Interface represents a single action or behavior
- The one abstract method is the essence of the interface — what the lambda must define.
- Default, static, and Object methods are support crew — they don’t change the essence, but they make the interface easier and safer to use.
- Designed to be used with lambdas and method references (without functional interfaces, Java wouldn't know what a lambda means)
- Often marked with @FunctionalInterface (optional, but recommended; it makes the compiler check that you only have one abstract method.)

It can have:
- One abstract method (required — defines the interface's main purpose)
- Any number of default or static methods (optional)
- Any number of Object methods (like toString, equals — don't count towards the "one" rule)

Example:

// Simple:
@FunctionalInterface
interface MyPrinter {
    void print(String msg);
}

// Full
@FunctionalInterface
interface MyProcessor {

    // 1. Abstract method (required for functional interface)
    String process(String input);

    // 2. Default method (optional)
    default void log(String msg) {
        System.out.println("[LOG] " + msg);
    }

    // 3. Static method (optional)
    static void printInfo() {
        System.out.println("MyProcessor interface for processing strings.");
    }

    // 4. Object method (allowed; does NOT count towards the one-abstract-method rule)
    @Override
    boolean equals(Object obj);
}

Interface                - Abstract Method   - Purpose
Predicate<T> boolean     - test(T t)	     - Test condition, returns boolean
Function<T,R> R          - apply(T t)	     - Transform T to R
Supplier<T>	T            - get()	         - Supply a value without arguments
Consumer<T>	void         - accept(T t)	     - Take a value, return nothing
UnaryOperator<T> T       - apply(T t)	     - Function from T to T
BinaryOperator<T> T      - apply(T t1, T t2) - Combine two T’s into one T
BiPredicate<T,U> boolean - test(T t, U u)    -	Predicate with 2 parameters
BiFunction<T,U,R> R      - apply(T t, U u)	 - Function with 2 inputs, 1 output
BiConsumer<T,U> void     - accept(T t, U u)	 - Consumer with 2 parameters
Runnable
Callable
Comparator
----------------------------------------

-------- 2. Default methods --------

Default method:
- A default method is a method in an interface that has a body (implementation) and uses the default keyword.
- It was introduced in Java 8 to allow adding new methods to existing interfaces without breaking classes that already implement them.
- Before Java 8, if you added a new method to an interface, all implementing classes would be forced to implement it — breaking backward compatibility.
- They provide a standard implementation in the interface itself.
- Existing classes do not need to override them, unless they want to change behavior.

Example (before Java 8):

// Version 1 of the API
// both classes ConsolePrinter and FilePrinter correctly implement void print(String text)

interface Printer {
    void print(String text);
}

class ConsolePrinter implements Printer {
    public void print(String text) {
        System.out.println(text);
    }
}

class FilePrinter implements Printer {
    public void print(String text) {
        // Writes text to a file...
        System.out.println("Writing to file: " + text);
    }
}

// Version 2 of the API
// ConsolePrinter and FilePrinter will not work UNLESS the new method printWithTimestamp(String text) is implemented

interface Printer {
    void print(String text);
    // New method — added in version 2
    void printWithTimestamp(String text);
}

// Version 2 of the API with backward compatibility
// Since printWithTimestamp(String text) is marked as default, nothing is required from ConsolePrinter and FilePrinter to keep working as is

interface Printer {
    void print(String text);

    default void printWithTimestamp(String text) {
        System.out.println(System.currentTimeMillis() + ": " + text);
    }
}

Note: default methods are the addition to abstract; abstract can be called withing default methods
----------------------------------------

-------- 3. Lambda expression --------
Description:
- A lambda expression is  a short, concise way to represent an implementation of a functional interface (an interface with exactly one abstract method).
- A lambda expression is essentially an instance of a functional interface — the lambda provides the implementation for that single abstract method.
- You can think of a lambda as an anonymous function
- Before Java 8, you had to write verbose anonymous inner classes to pass behavior as a method argument.

Before Java 8:
list.sort(new Comparator<String>() {
    public int compare(String a, String b) {
        return a.compareTo(b);
    }
});

After Java 8:
list.sort((a, b) -> a.compareTo(b));

Lambda has:
- Parameters → input values.
- Body → what it does.
- Return type → inferred automatically.

Structure:
(parameters) -> expression
(parameters) -> { statements; }

Types of Lambdas:

  // 1. Number of Parameters

    // 1.1 0 parameters

@FunctionalInterface
interface Task {
    void execute();
}

Task t = () -> System.out.println("No parameters");
t.execute();

    // 1.2 1 parameter

interface Transformer {
    int transform(int x);
}

Transformer doubler = x -> x * 2;
System.out.println(doubler.transform(5)); // 10

    // 1.3 2 parameters

@FunctionalInterface
interface Adder {
    int add(int a, int b);
}

Adder sum = (a, b) -> a + b;
System.out.println(sum.add(3, 4)); // 7

  // 2. Return Value

    // 2.1 Single expression (implicit return)

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

Calculator multiply = (a, b) -> a * b;
System.out.println(multiply.calculate(3, 5)); // 15

    // 2.2 Multiple statements (explicit return)

@FunctionalInterface
interface VerboseCalculator {
    int calculate(int a, int b);
}

VerboseCalculator calc = (a, b) -> {
    System.out.println("Adding numbers...");
    int sum = a + b;
    return sum;
};
System.out.println(calc.calculate(4, 6)); // 10

    // 2.3 Parameter Type Declaration

@FunctionalInterface
interface StringCombiner {
    String combine(String a, String b);
}

StringCombiner combinerExplicit = (String a, String b) -> a + " " + b; // added String
System.out.println(combiner.combine("Hello", "World")); // Hello World

StringCombiner combinerInference = (a, b) -> a + " " + b; // not type param String
System.out.println(combiner.combine("Java", "Lambdas")); // Java Lambdas

    // 2.4 Capturing Variables from Scope

@FunctionalInterface
interface Greeter {
    void greet();
}

String greeting = "Hello"; // effectively final
Greeter g = () -> System.out.println(greeting + ", world!");
g.greet(); // Hello, world!

 */

import java.util.*;

public class Main {
    public static void main(String[] args) {

/*
        Task 1 – Filtering Numbers
        Description:
        Given a list of integers, display only the even numbers.
        Output example:
        Original list: [3, 7, 8, 2, 5, 6, 10]
        Even numbers: [8, 2, 6, 10]
        */
        System.out.println("Task 1: ");

        LinkedList<Integer> llist1 = new LinkedList<>();
        llist1.offer(3);
        llist1.offer(7);
        llist1.offer(8);
        llist1.offer(2);
        llist1.offer(5);
        llist1.offer(6);
        llist1.offer(10);
        System.out.println("Original list: " + llist1);

        // EvenFilter Interface

        // implementation
        EvenFilter filter1 = list -> {
            ListIterator<Integer> literator1 = llist1.listIterator();
            Integer element;
            while(literator1.hasNext()) {
                element = literator1.next();
                if (element % 2 == 0) {
                    System.out.print(element + " ");
                }
            }
        };

        // execution
        System.out.println("Even elements: ");
        filter1.evenFilter(llist1);

        System.out.println("\n");

/*
        Task 2 – Sorting Strings by Length
        Description:
        Given a list of strings, sort them in ascending order of their length.
        Output example:
        Original list: [apple, fig, banana, kiwi, cherry]
        Sorted by length: [fig, kiwi, apple, cherry, banana]
        */
        System.out.println("Task 2:");

        ArrayList<String> arrlist2 = new ArrayList<>(List.of(
                "apple",
                "banana",
                "kiwi",
                "cherry",
                "fig"
        ));
        System.out.println("Original list: " + arrlist2);

        // ListReverser
        // implementation
        ListLengthComparator lrev1 = list -> {
            Comparator<String> lengthCompar = (s1, s2) -> Integer.compare(s1.length(), s2.length());
            Collections.sort(list,  lengthCompar);
        };

        // execution
        lrev1.lengthCheck(arrlist2);
        System.out.println("Reversed list: " + arrlist2);

        System.out.println();

/*
        Task 3 – Transforming to Uppercase
        Description:
        Given a list of names, transform each name into uppercase.
        Output example:
        Original names: [John, alice, Mark, emily]
        Uppercase names: [JOHN, ALICE, MARK, EMILY]
*/
        System.out.println("Task 3:");

        ArrayList<String> arrList2 = new ArrayList<>(List.of(
                "John",
                "alice",
                "Mark",
                "emily"
        ));
        System.out.println("Original list: " + arrList2);

        // ListUpperCaser
        ListUpperCaser lup1 = list -> {
            Iterator<String> arrliterator3 = arrList2.iterator();
            String strToUpper;
            int currentIndex = 0;
            while (arrliterator3.hasNext()) {
                strToUpper = arrliterator3.next().toUpperCase();
                arrList2.set(currentIndex, strToUpper);
                currentIndex++;
            }
        };

        lup1.listUpper(arrList2);
        System.out.println("Uppercased list: " + arrList2);
        System.out.println();

/*
        Task 4 – Custom Greeting
        Description:
        Given a list of names, display a greeting for each name in the format: "Hello, <name>!".
        Output example:
        Hello, John!
        Hello, Alice!
        Hello, Mark!
        Hello, Emily!
*/
        System.out.println("Task 4:");

        ArrayList<String> arlist4 = new ArrayList<>(List.of("John", "Alice", "Mark"));

        // Greeter
        String greeting1 = "Hello, ", greeting2 = "!";
        Greeter greeter = list -> {
            Iterator<String> arrliterator4 = arlist4.iterator();
            while (arrliterator4.hasNext()) {
                System.out.println(greeting1 + arrliterator4.next() + greeting2);
            }
        };

        greeter.greet(arlist4);
        System.out.println();

/*
        Task 5 – Finding the Longest Word
        Description:
        Given a list of words, find the longest word.
        Output example:
        Words: [cat, elephant, dog, hippopotamus, ant]
        Longest word: hippopotamus
        */
        System.out.println("Task 5:");

        ArrayList<String> arrlist5 = new ArrayList<>(List.of("cat", "elephant", "dog", "hippopotamus", "ant"));

        // LongestLengthFinder
        LongestLengthFinder llf = list -> {
            int longestWordIndex = 0, currentIndex = 0, logestWordLength = 0;
            Iterator<String> iter5 = list.iterator();
            String strToCheck;
            while (iter5.hasNext()) {
                strToCheck = iter5.next();
                if (strToCheck.length() > logestWordLength) {
                    longestWordIndex = currentIndex;
                    logestWordLength = strToCheck.length();
                }
                currentIndex++;
            }
            System.out.println("Longest word is: " + arrlist5.get(longestWordIndex));
        };

        llf.findLongest(arrlist5);
        System.out.println();

        /*
        Task 6 – Summing Values
        Description:
        Given a list of integers, calculate the sum of all numbers.
        Output example:
        Numbers: [4, 7, 1, 9, 3]
        Sum: 24
         */
        System.out.println("Task 6:");

        ArrayList<Integer> arrlist6 = new ArrayList<>(List.of(4, 7, 9, 1, 3));
        System.out.println("List: " + arrlist6);

        // Summarize
        Summarize summarizer = list -> {
            int sumOfInts = 0;
            Iterator<Integer> iter6 = arrlist6.iterator();
            while (iter6.hasNext()) {
                sumOfInts += iter6.next();
            }
            return sumOfInts;
        };

        System.out.println("Sum of elements: " + summarizer.sum(arrlist6));
        System.out.println();

/*
        Task 7 – Removing Duplicates
        Description:
        Given a list of integers, remove duplicate values and display the unique numbers.
        Output example:
        Original list: [2, 5, 2, 7, 8, 7, 3]
        Unique numbers: [2, 5, 7, 8, 3]
*/
        System.out.println("Task 7: ");

        ArrayList<Integer> arlist7 = new ArrayList<>(List.of(2, 5, 6, 7, 2, 9, 5, 5));
        System.out.println("Original list: " + arlist7);

        DuplicateRemover dr = list -> {
            Iterator<Integer> iter7 = arlist7.iterator();
            while (iter7.hasNext()) {
                Integer elementInt = iter7.next();
                for (int i = list.indexOf(elementInt) + 1; i < list.size(); i++) {
                    if (list.get(i).equals(elementInt)) iter7.remove();
                }
            }
        };

        dr.removeDuplicates(arlist7);
        System.out.println("Modified list: " + arlist7);
        System.out.println();

/*
        Task 8 – Filtering by Starting Letter
        Description:
        Given a list of strings, display only the ones starting with the letter 'A' (case-insensitive).
        Output example:
        Original list: [apple, Banana, apricot, Cherry, avocado]
        Words starting with A: [apple, apricot, avocado]
        */
        System.out.println("Task 8: ");
        ArrayList<String> arlist8 = new ArrayList<>(List.of("apple", "Banana", "apricot", "Cherry", "Avocado"));

        FirstLetterChecker flc = list -> {
            Iterator<String> iter8 = arlist8.iterator();
            while (iter8.hasNext()) {
                String strToCheck = iter8.next().toLowerCase();
                char ch = strToCheck.charAt(0);
                if (ch == 'a') {
                    System.out.println(strToCheck);
                }
            }
        };

        flc.checkFirstLetter(arlist8);
        System.out.println();

    }
}

@FunctionalInterface
interface EvenFilter {
    void evenFilter(List<Integer> list);
}

@FunctionalInterface
interface ListLengthComparator {
    void lengthCheck(List<String> list);
}

@FunctionalInterface
interface ListUpperCaser {
    void listUpper(List<String> list);
}

@FunctionalInterface
interface Greeter {
    void greet(List<String> list);
}

@FunctionalInterface
interface LongestLengthFinder {
    void findLongest(List<String> list);
}

@FunctionalInterface
interface Summarize {
    int sum(List<Integer> list);
}

@FunctionalInterface
interface DuplicateRemover {
    void removeDuplicates(List<Integer> list);
}

@FunctionalInterface
interface FirstLetterChecker {
    void checkFirstLetter(List<String> list);
}