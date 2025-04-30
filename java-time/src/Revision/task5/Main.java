package Revision.task5;

/*
Task 5: Simulated Ping
Add an artificial delay
Output:
Ping response time: 1.5 seconds
 */

import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        Instant instOne = Instant.now();
        System.out.println("Instant 1: " + instOne);

        for (int i = 0; i < 10; i++) {
            System.out.println("Operation completed.");
        }

        Instant instTwo = Instant.now();
        System.out.println("Instant 2: " + instTwo);

        Duration durationBetweenInst = Duration.between(instOne, instTwo);
        System.out.println("Duration as is: " + durationBetweenInst);
        System.out.println("Duration sec: " + durationBetweenInst.getSeconds());
        System.out.println("Duration nano: " + durationBetweenInst.getNano());

    }

}
