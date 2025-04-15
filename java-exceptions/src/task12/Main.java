package task12;

/*
Task 12: Exception Logging
Use Logger to log exception details when an exception is caught.
Create a method that randomly throws exceptions
Log the full stack trace
 */

import java.util.logging.Logger;

/*
Logger is part of Java’s java.util.logging package.
It’s used to log messages at different levels (info, warning, error, etc.), instead of using plain System.out.println().

It's especially useful for:
Tracking application events
Debugging
Logging exceptions

import java.util.logging.Logger;
public class Example {
    private static final Logger logger = Logger.getLogger(Example.class.getName());
}

catch (Exception e) {
    logger.severe("Something went wrong: " + e.getMessage());
}

OR

import java.util.logging.Level;
catch (Exception e) {
    logger.log(Level.SEVERE, "Exception occurred", e);
}

Logging Levels You Can Use:
Level	Description
SEVERE	Something seriously wrong (e.g. crash)
WARNING	Something unexpected happened
INFO	Normal app events/info
CONFIG	Configuration details
FINE/FINER/FINEST	Detailed debugging info

 */
public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        int num = (int)(Math.random() * 2);
        System.out.println(num);

        try {
            if (num == 1) throw new CustomException("Custom Message");
        } catch (CustomException e) {
            logger.severe("Something went wrong: " + e.getMessage());
        }

    }

}
