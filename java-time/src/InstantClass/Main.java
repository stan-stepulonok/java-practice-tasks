package InstantClass;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        /*
        Task 1: Create and Print Current Instant
        Create an Instant representing the current moment.
        Print it directly.
         */
        System.out.println("Task 1: ");
        Instant ins1 = Instant.now();
        System.out.println(ins1);
        System.out.println();

        /*
        Task 2: Instant from Specific Epoch Seconds
        Create an Instant representing exactly 1700000000 seconds since the epoch (1970-01-01T00:00:00Z).
        Print it.
         */
        System.out.println("Task 2: ");
        long epochSec2 = 1700000000;
        Instant ins2 = Instant.ofEpochSecond(epochSec2);
        System.out.println(ins2);
        System.out.println();

        /*
        Task 3: Add and Subtract Time from Instant
        Create an Instant.now().
        Add 10 minutes to it.
        Subtract 3 hours from it.
        Print the results.
         */
        System.out.println("Task 3:");
        Instant ins3 = Instant.now();
        System.out.println("Original: " + ins3);
        ins3 = ins3.plus(10, ChronoUnit.MINUTES).minus(3, ChronoUnit.HOURS);
        System.out.println("Modified: " + ins3);
        System.out.println();

        /*
        Task 4: Convert Instant to LocalDateTime in a Specific Zone
        Take Instant.now().
        Convert it to LocalDateTime in "Asia/Seoul" time zone.
        Print it.
         */
        System.out.println("Task 4: ");
        Instant ins4 = Instant.now();
        ZoneId zone4Seoul = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdt4 = ZonedDateTime.ofInstant(ins4, zone4Seoul); // not required by task, but the method is the same
        LocalDateTime ldt4 = LocalDateTime.ofInstant(ins4, zone4Seoul);
        System.out.println(zdt4);
        System.out.println(ldt4);
        System.out.println();

        /*
        Task 5: Parse Instant from a String
        Parse the string "2025-05-01T12:00:00Z" into an Instant.
        Print the parsed instant.
         */
        System.out.println("Task 5: ");
        String toParse5 = "2025-05-01T12:00:00Z";
        Instant ins5 = Instant.parse(toParse5);
        System.out.println(ins5);

        /*
        Task 6: Compare Two Instants
        Create two Instant objects:
        One is now.
        One is 5 seconds later (addSeconds(5)).
        Check if the first is before or after the second (use isBefore, isAfter).
         */
        System.out.println("Task 6: ");
        Instant ins6Now = Instant.now();
        Instant ins6Plus = ins6Now.plus(5, ChronoUnit.SECONDS);
        System.out.println(ins6Now + " is before " + ins6Plus + "? ... " + ins6Now.isBefore(ins6Plus));
        System.out.println(ins6Now + " is after " + ins6Plus + "? ... " + ins6Now.isAfter(ins6Plus));
        System.out.println();

        /*
        Task 7: Duration Between Two Instants
        Create two Instant objects (one now, one after 2 hours).
        Calculate the Duration between them.
        Print the number of seconds and minutes difference.
         */
        System.out.println("Task 7: ");
        Instant ins7Now = Instant.now();
        Instant ins7Plus = ins7Now.plus(2, ChronoUnit.HOURS);
        Duration dur7 = Duration.between(ins7Now, ins7Plus);
        System.out.println("Duration: " + dur7);
        long durationHours = dur7.toHours();
        System.out.println("Duration in hours between " + ins7Now + " and " + ins7Plus + " is " + durationHours);
        System.out.println();

        /*
        Task 8: Instant to and from Milliseconds
        Create an Instant from System.currentTimeMillis().
        Print it.
        Then get the milliseconds from that instant back.
         */
        System.out.println("Task 8: ");
        long millis8 = System.currentTimeMillis();
        System.out.println(millis8);
        Instant ins8 = Instant.ofEpochMilli(millis8);
        System.out.println(ins8);
        millis8 = ins8.toEpochMilli();
        System.out.println(millis8);
        System.out.println();

        /*
        Task 9: Truncate Instant to Seconds
        Create an Instant.now().
        Truncate it to seconds (drop milliseconds/nanoseconds part).
        Print the original and truncated instants.
         */
        System.out.println("Task 9: ");
        Instant ins9 = Instant.now();
        System.out.println(ins9);
        ins9 = ins9.truncatedTo(ChronoUnit.SECONDS);
        System.out.println(ins9);
        System.out.println();

    }

}
