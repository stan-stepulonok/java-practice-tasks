package task1;

/*
Task 1: Basic Weekdays
Create a simple enum named Weekday containing all days of the week.
Write a main method that prints each day’s name and position in the enum.
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("----- Printed directly: -----");
        Weekday monday = Weekday.MONDAY;
        System.out.println("Printed enum: " + monday);
        System.out.println("Printed enum name: " + monday.name());
        System.out.println("Printed position: " + monday.ordinal());
        System.out.println();

        System.out.println("----- Created an array from enums: -----");
        Weekday[] daysOfWeek = Weekday.values();
        for (int i = 0; i < daysOfWeek.length; i++) {
            System.out.println("Printed enum: " + daysOfWeek[i]);
            System.out.println("Printed enum name: " + daysOfWeek[i].name());
            System.out.println("Printed position: " + daysOfWeek[i].ordinal());
            System.out.println();
        }
        System.out.println();

    }

}
