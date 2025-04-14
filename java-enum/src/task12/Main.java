package task12;

/*
Task 13: Day Scheduler
Make an enum Day representing the days of the week.
In each constant, define a method that returns scheduled activities for that day.
Use it in a planner application.
 */

public class Main {

    public static void main(String[] args) {

        Activity act = new Activity("Some Activity");
        Scheduler.MONDAY.assignActivity(act);
        Scheduler.MONDAY.showActivity();

    }

}
