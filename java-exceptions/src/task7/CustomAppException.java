package task7;

public class CustomAppException extends Exception {

    CustomAppException(Throwable cause) {
        super(cause);
        System.out.println("Created a custom exception.");
    }

}
