package task14;

/*
Task 15: Custom Exception with Extra Fields
Create a custom exception with an errorCode field.
Pass both a message and code in the constructor. Display both when catching it.
 */
public class Main {

    public static void main(String[] args) {
        CustomException exc = new CustomException("Error Message", 999);
        try {
            throw exc;
        } catch (CustomException e) {
            System.out.println(e.getMessage());
            System.out.println(e.errorCode);
        }

    }

}
