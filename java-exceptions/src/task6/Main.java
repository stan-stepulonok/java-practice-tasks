package task6;

/*
A chained exception is when one exception is caused by another.
Java allows you to associate a cause (another throwable) with a throwable,
so you can track the original error source through layers of abstraction.

✅ How to Use Chained Exceptions

1. Using Constructors
Most exception classes have a constructor like this:
Exception(String message, Throwable cause)
throw new Exception("High-level error", originalException);

2. Using initCause()
It’s a method that sets the "cause" of an exception after you've already created it.
Throwable cause = new NullPointerException("null pointer");
Exception ex = new Exception("Something went wrong", cause);

If you already created an exception and want to set the cause later:
Exception e = new Exception("Something went wrong");
e.initCause(originalException);
throw e;

You can only call initCause() once. If you try it a second time, it throws IllegalStateException.
ex.initCause(new NullPointerException());  // Works
ex.initCause(new IOException());           // IllegalStateException
*/

/*
Task 6: Chained Exceptions
Catch an IllegalArgumentException, then throw a new IllegalStateException() with initCause() to chain them.
Print the chained exception stack trace.
 */
public class Main {

    public static void main(String[] args) {

        IllegalArgumentException illegalArgumentE = new IllegalArgumentException("This is an illegal argument exception.");
        IllegalStateException illegalStateE = new IllegalStateException("This is an illegal state exception.");

        try {
            System.out.println("Try block throws illegalArgumentE.");
            throw illegalArgumentE;
        } catch (IllegalArgumentException e1) {
            System.out.println("Catch block catches illegalArgumentE.");
            System.out.println(e1);
            System.out.println();
            try {
                System.out.println("Try block throws illegalStateE.");
                throw illegalStateE.initCause(e1);
            } catch (Throwable e2) {
                System.out.println("Catch block catches illegalStateE.");
                e2.printStackTrace();
                System.out.println();
            }
        } finally {
            System.out.println("Finally block.");
            System.out.println();
        }
    }

    /*
F:\Tools\jdk\21.01\bin\java.exe "-javaagent:F:\Tools\IntelliJ IDEA Community Edition 2023.2.2\lib\idea_rt.jar=58661:F:\Tools\IntelliJ IDEA Community Edition 2023.2.2\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath F:\Repositories\java-practice-tasks\java-exceptions\out\production\java-exceptions task6.Main
Try block throws illegalArgumentE.
Catch block catches illegalArgumentE.
java.lang.IllegalArgumentException: This is an illegal argument exception.

Try block throws illegalStateE.
Catch block catches illegalStateE.

Finally block.

java.lang.IllegalStateException: This is an illegal state exception.
	at task6.Main.main(Main.java:40)
Caused by: java.lang.IllegalArgumentException: This is an illegal argument exception.
	at task6.Main.main(Main.java:39)

Process finished with exit code 0
     */

}
