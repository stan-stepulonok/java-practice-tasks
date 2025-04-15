package task14;

public class CustomException extends Exception {

    public String errorMessage;
    public int errorCode;

    CustomException(String errorMessage, int errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

}
