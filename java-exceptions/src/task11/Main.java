package task11;

/*
Task 11: Throwing Exception from Constructor
Create a class whose constructor validates input. If invalid, it throws a custom exception.
Instantiate it in main() and handle the error.
 */
public class Main {

    public static void main(String[] args) {

        Integer intObj = 3;

        try {
            TestClass instance = new TestClass(intObj);
        } catch (CustomException e) {
            System.out.println(e);
        }


    }

}
