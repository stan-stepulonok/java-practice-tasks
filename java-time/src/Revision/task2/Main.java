package Revision.task2;

/*
Task 2: Stopwatch Simulation
Start: 09:00:00
End: 10:45:30
Output:
Elapsed: 1 hours, 45 minutes, 30 seconds
 */

import java.time.Duration;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        LocalTime ltStart = LocalTime.of(9, 0, 0);
        System.out.println("Start LocalTime: " + ltStart);

        LocalTime ltEnd = LocalTime.of(10, 45, 30);
        System.out.println("End LocalTime: " + ltEnd);

        Duration durationElapsed = Duration.between(ltStart, ltEnd);
        System.out.println("Duration elapsed as is: " + durationElapsed);

        System.out.println("Total seconds: " + durationElapsed.getSeconds());

        long seconds = durationElapsed.getSeconds() % 60;
        long minutes = (durationElapsed.getSeconds() % 3600) / 60;
        long hours = durationElapsed.getSeconds() / 3600;

        System.out.println("Elapsed: " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds");

    }

}
