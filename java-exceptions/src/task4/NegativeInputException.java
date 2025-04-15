package task4;

public class NegativeInputException extends Exception {

    NegativeInputException(String customMessage) {
        super();
        System.out.println("Exception message: " + customMessage);
    }

}
