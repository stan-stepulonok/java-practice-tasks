package ZonedDateTimeClass;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1:Create a ZonedDateTime for a specific Zone
        Goal:
        Create a ZonedDateTime that represents March 15, 2025, at 14:30 in the "Europe/Paris" time zone.
        ✅Expected output example:
        2025 - 03 - 15 T14:30 + 01:00[Europe / Paris]
        */
            System.out.println("Task 1: ");
            String zone1Str = "Europe/Paris";
            ZoneId zone1 = ZoneId.of(zone1Str);
            ZonedDateTime zdt1 = ZonedDateTime.of(2025, 3, 15, 14, 30, 0, 0, zone1);
            System.out.println(zdt1);
            System.out.println();

        /*
        Task 2:Convert ZonedDateTime between two zones
        Goal:
        Given a ZonedDateTime in "Asia/Tokyo", convert it to "America/New_York" time zone while keeping the instant the same.
        ✅Input example:
        2025 - 06 - 01 T09:00 + 09:00[Asia / Tokyo]
        ✅Output example:
        2025 - 05 - 31 T20:00 - 04:00[America / New_York]
        */
            System.out.println("Task 2: ");

            LocalDate ld2 = LocalDate.of(2020, 3, 30);
            LocalTime lt2 = LocalTime.of(21, 59, 45);
            ZoneId tokyo2 = ZoneId.of("Asia/Tokyo");
            ZonedDateTime zdt2Tokyo = ZonedDateTime.of(ld2, lt2, tokyo2);
            System.out.println("Tokyo -> " + zdt2Tokyo);

            Instant inst2 = zdt2Tokyo.toInstant();

            ZoneId newYork2 = ZoneId.of("America/New_York");
            ZonedDateTime zdt2NEwYork = ZonedDateTime.ofInstant(inst2, newYork2);
            System.out.println("New York -> " + zdt2NEwYork);
            System.out.println();


        /*
        Task 3:List all available Zone IDs that contain "America"
        Goal:
        Print all available ZoneId values that contain the word "America".
        ✅Output example (partial):
        America / New_York
        America / Los_Angeles
        America / Chicago
        */
            System.out.println("Task 3: ");
            Set<String> zones3 = ZoneId.getAvailableZoneIds();
            String searchZone = "America";
            Iterator<String> iter3 = zones3.iterator();
            while(iter3.hasNext()) {
                    String zone = iter3.next();
                    if (zone.contains(searchZone)) System.out.println(zone);
            }
            System.out.println();

        /*
        Task 4:Find the current time in three different time zones
        Goal:
        Print the current time in:
        "Europe/London"
        "Asia/Kolkata"
        "Australia/Sydney"
        ✅Example format:
        Current time in Europe/London:
        2025 - 04 - 26 T13:05 + 01:00[Europe / London]
        Current time in Asia/Kolkata:
        2025 - 04 - 26 T17:35 + 05:30[Asia / Kolkata]
        Current time in Australia/Sydney:
        2025 - 04 - 26 T22:05 + 10:00[Australia / Sydney]
         */
            System.out.println("Task 4: ");

            LocalDate ld4 = LocalDate.now();
            LocalTime lt4 = LocalTime.now();

            ZoneId london4 = ZoneId.of("Europe/London");
            ZoneId kolkata4 = ZoneId.of("Asia/Kolkata");
            ZoneId sydney4 = ZoneId.of("Australia/Sydney");

            System.out.println("4.1 From LocalDate/LocalTime: ");
            ZonedDateTime zdtLondon4 = ZonedDateTime.of(ld4, lt4, london4);
            System.out.println(zdtLondon4);

            System.out.println("4.2 From ZonedDateTime converted Instant: ");
            Instant inst4 = zdtLondon4.toInstant();
            ZonedDateTime zdtKolkata4 = ZonedDateTime.ofInstant(inst4, kolkata4);
            System.out.println(zdtKolkata4);

            System.out.println("4.3 From another ZonedDateTime using withZoneSameInstant: ");
            ZonedDateTime zdtSydney4 = zdtKolkata4.withZoneSameInstant(sydney4);
            System.out.println(zdtSydney4);
            System.out.println();


        /*
        Task 5:Calculate the difference between two ZonedDateTime objects
        Goal:
        Create two ZonedDateTime instances in different time zones and calculate how many hours and minutes apart they are.
        ✅Example input:
        ZonedDateTime in "America/Los_Angeles":2025 - 01 - 10 T10:00
        ZonedDateTime in "Europe/Berlin":2025 - 01 - 10 T20:00
        ✅Expected:
        Difference:
        10 hours
         */
            System.out.println("Task 5: ");

            LocalDate ld5 = LocalDate.now();
            LocalTime lt5 = LocalTime.now();
            ZoneId london5 = ZoneId.of("Europe/London");
            ZoneId kolkata5 = ZoneId.of("Asia/Kolkata");

            // take now, London
            ZonedDateTime zdtLondon5 = ZonedDateTime.now(london5);

            // use withZoneSameInstant, Kolkata
            ZonedDateTime zdtKolkata5 = zdtLondon5.withZoneSameInstant(kolkata5);

            // ChronoUnit.between() -> this calculates the difference between two instants — NOT the zone offsets, so the result is 0
            // If your two ZonedDateTime objects represent the same instant, just in different zones, then their "between" will be 0.
            long minutes = ChronoUnit.MINUTES.between(zdtLondon5, zdtKolkata5);
            System.out.println("Minutes between London and Kolkata: " + minutes);
            long hours = ChronoUnit.HOURS.between(zdtLondon5, zdtKolkata5);
            System.out.println("Hours between London and Kolkata: " + hours);
            System.out.println();

            // If you want to see the time offset difference (like London is UTC+1, Kolkata is UTC+5:30), you would need to compare zone offsets, not instants!

            ZoneOffset offsetLondon = zdtLondon5.getOffset();
            System.out.println("Offset London: " + offsetLondon);
            ZoneOffset offsetKolkata = zdtKolkata5.getOffset();
            System.out.println("Offset Kolkata: " + offsetKolkata);
            int secondsDifference = offsetKolkata.getTotalSeconds() - offsetLondon.getTotalSeconds();
            minutes = secondsDifference / 60;
            System.out.println("Minutes between London and Kolkata: " + minutes);
            hours = minutes / 60;
            System.out.println("Hours between London and Kolkata: " + hours);
            System.out.println();

        /*
        Task 6:Handle Daylight Saving Time transition
        Goal:
        Create a ZonedDateTime on March 9, 2025, 2:30 AM in "America/New_York" and observe what happens (because DST starts at 2 AM).
        ✅Expected behavior:
        You will need to notice how Java adjusts the non -existent time(2:30 AM might jump directly to 3:30 AM or throw an exception if not handled).
         */
            System.out.println("Task 6: ");
            ZoneId newYork6 = ZoneId.of("America/New_York");
            LocalDate ld6 = LocalDate.of(2025, 3, 9);
            LocalTime lt6 = LocalTime.of(2, 30, 0);
            ZonedDateTime zdt6 = ZonedDateTime.of(ld6, lt6, newYork6);
            System.out.println(zdt6);
            System.out.println();

        /*
        Task 7:Format a ZonedDateTime into a custom string
        Goal:
        Format a ZonedDateTime into this format:
        Saturday, 26 April 2025, 13:15:45 GMT + 01:00 (Europe / London)
        ✅Requirements:
        Day of week
        Full date
        Time with seconds
        Zone offset
        Zone name
         */
            System.out.println("Task 7: ");
            ZoneId london7 = ZoneId.of("Europe/London");
            LocalDate ld7 = LocalDate.of(2025, 4, 8);
            LocalTime lt7 = LocalTime.of(2, 30, 0);
            ZonedDateTime zdt7 = ZonedDateTime.of(ld7, lt7, london7);
            String pattern = "EEEE, dd MMMM yyyy, HH:mm:ss 'GMT' XX VV";
            DateTimeFormatter dtf7 = DateTimeFormatter.ofPattern(pattern);
            String result = zdt7.format(dtf7);
            System.out.println(result);
            System.out.println();


        /*
        Task 8:Parse a string into a ZonedDateTime
        Goal:
        Given the string:
        "2025-12-31T23:00:00+02:00[Europe/Kyiv]"
        Parse it into a ZonedDateTime object.
         */

        /*
        Task 9:Find all zones with a UTC +5 offset at a given moment
        Goal:
        For the current instant, find all available zones where the offset is exactly UTC + 5.
        ✅Example output:
        Asia / Karachi
        Asia / Yekaterinburg
        Indian / Kerguelen
         */



        /*
        Task 10:Compare two ZonedDateTime objects
        Goal:
        Compare two ZonedDateTime objects and check which one is earlier or later.
        ✅Example:
        ZonedDateTime A:2025 - 04 - 26 T10:00 + 02:00[Europe / Berlin]
        ZonedDateTime B:2025 - 04 - 26 T08:00 Z[UTC]
        ✅Expected:
        A is equal to B
         */


    }

}
