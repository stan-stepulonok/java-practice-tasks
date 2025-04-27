package DurationPeriodClass;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1: Create and Print a Duration
        Create a Duration of 90 minutes.
        Print the number of seconds in this duration.
         */
        System.out.println("Task 1:");
        Duration dur1Chr = Duration.of(90, ChronoUnit.MINUTES);
        Duration dur1Min = Duration.ofMinutes(90);
        System.out.println(dur1Chr);
        System.out.println(dur1Min);
        System.out.println();


    }

}
