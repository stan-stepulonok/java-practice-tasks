package Revision.task3;

/*
Task 3: Time Difference
From: 2025-04-29 08:00
To: Now
Output example:
Difference: 5 days, 124 hours
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        LocalDateTime ldtNow = LocalDateTime.now();
        System.out.println("LocalDateTime now: " + ldtNow);

        LocalDateTime ldtNowPlusFiveDays = ldtNow.plus(5, ChronoUnit.DAYS);
        System.out.println("LocalDateTime plus 5: " + ldtNowPlusFiveDays);

        System.out.println();

        // Option 1 - Period
        // Period uses LocalDate
        Period period = Period.between(ldtNow.toLocalDate(), ldtNowPlusFiveDays.toLocalDate());
        long days = period.getDays();
        System.out.println("Days from period: " + days);
        System.out.println();

        // Option 2 - Duration
        // Duration uses LocalDateTime
        Duration duration = Duration.between(ldtNow, ldtNowPlusFiveDays);
        long totalSeconds = duration.getSeconds();
        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds % 3600) / 60;
        long hours = totalSeconds / 3600;
        System.out.println("Hours: " + hours + "; Minutes: " + minutes + "; Seconds: " + seconds);
        System.out.println();

        // Option 3 - ChronoUnit
        long daysBetween = ChronoUnit.DAYS.between(ldtNow, ldtNowPlusFiveDays);
        System.out.println("Days between: " + daysBetween);

    }

}
