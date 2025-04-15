package task9;

public class CustomUncheckedException extends RuntimeException {

    CustomUncheckedException() {
        System.out.println("Unchecked exception created here.");
    }

}
