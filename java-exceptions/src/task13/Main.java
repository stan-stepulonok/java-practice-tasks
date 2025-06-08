package task13;

import java.util.logging.Logger;

/*
Task 13: RuntimeException in Loops
Write a program that loops through an array of numbers. If any element is null, catch the exception and continue processing.
Do not terminate the loop on exception.
Output Example:
5
null element found, skipping
12
 */
public class Main {

    private static final Logger logger = Logger.getLogger(task12.Main.class.getName());

    public static void main(String[] args) {

        Integer[] arrOfInts = {1, 2, null, 4, null, 5, 6};


        try {
            boolean exceptionTriggered = false;
            CustomException expectionObj = null;
            for (int i = 0; i < arrOfInts.length; i++) {
                if (arrOfInts[i] == null) {
                    expectionObj = new CustomException("Error");
                    System.out.println("Null element found, skipping...");
                    exceptionTriggered = true;
                    continue;
                }
                else System.out.println(arrOfInts[i]);
            }
            if (exceptionTriggered) throw expectionObj;
        } catch (CustomException e) {
            logger.severe("Exception: " + e.getMessage());

        }

    }

}
