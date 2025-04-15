package task8;

/*
Task 8: Rethrow Exception
Write a method that catches a NumberFormatException and rethrows it after logging a message.
Show how rethrowing works in exception propagation.

Logging a message simply means: "Print or record a message when something goes wrong."
In beginner-friendly or small apps, logging a message usually just means:
System.out.println("Invalid number format: " + e.getMessage());

In real-world apps, logging uses a logger tool:
Logger logger = Logger.getLogger(MyClass.class.getName());
logger.severe("Invalid input: " + e.getMessage());

 */
public class Main {

    public static void main(String[] args) {

        try {
            Main.multiply(2, 3);
        } catch (CustomException e) {
            System.out.println("Here we will handle the exception.");
        }

    }

    public static void multiply(int num1, int num2) throws CustomException {
        System.out.println(num1 * num2);
        try {
            System.out.println("Try in method.");
            CustomException exceptionObject = new CustomException();
            throw exceptionObject;
        } catch (CustomException e) {
            System.out.println("Catch in method: " + e);
            throw e;
        }
    }

}
