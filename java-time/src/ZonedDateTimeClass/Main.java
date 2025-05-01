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
            // "2025-12-31T23:00:00+02:00[Europe/Kyiv]" standard ISO format.
            System.out.println("Task 8: ");
            String zdtStr8 = "2025-12-31T23:00:00+02:00[Europe/Kyiv]";
            ZonedDateTime zdt8 = ZonedDateTime.parse(zdtStr8);
            System.out.println(zdt8);
            System.out.println();

        /*
        Task 9:Find all zones with a UTC +5 offset at a given moment
        Goal:
        For the current instant, find all available zones where the offset is exactly UTC + 5.
        ✅Example output:
        Asia / Karachi
        Asia / Yekaterinburg
        Indian / Kerguelen
         */
            System.out.println("Task 9: ");
            Instant now = Instant.now();
            Set<String> allZones = ZoneId.getAvailableZoneIds();
            for (String zoneIdStr : allZones) {
                    ZoneId zoneId9 = ZoneId.of(zoneIdStr);
                    ZonedDateTime zdt9 = now.atZone(zoneId9);
                    ZoneOffset offset9 = zdt9.getOffset();
                    if (offset9.equals(ZoneOffset.ofHours(5))) {
                            System.out.println(zoneId9);
                    }
            }
            System.out.println();

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
            System.out.println("Task 10: ");
            String zdt10aStr = "2025-04-26T10:00+02:00[Europe/Berlin]";
            String zdt10bStr = "2025-04-26T08:00Z[UTC]";
            ZonedDateTime zdt10a = ZonedDateTime.parse(zdt10aStr);
            ZonedDateTime zdt10b = ZonedDateTime.parse(zdt10bStr);
            int compResult = zdt10a.compareTo(zdt10b);
            if (compResult == 0) System.out.println("ZonedDateTime are equal!");
            else System.out.println("ZonedDateTime are not equal!");
            System.out.println();

            /*
            Task 11: Create ZonedDateTime in Different Ways
            Create three ZonedDateTime objects:
            One for now in your system default time zone.
            One for now in the "America/New_York" time zone.
            One for a specific date and time: 2023-12-25 15:30, in the "Asia/Tokyo" time zone.
            Print each of them nicely (use DateTimeFormatter to show full date and time with zone).
             */
            System.out.println("Task 11: ");
            // now, default system zone
            ZonedDateTime zdt11Now = ZonedDateTime.now();
            System.out.println("Raw -> Current zoned time system: " + zdt11Now);
            // new york
            LocalTime lt11 = LocalTime.now();
            LocalDate ld11 = LocalDate.now();
            ZoneId nyZone11 = ZoneId.of("America/New_York");
            ZonedDateTime zdt11Ny = ZonedDateTime.of(ld11, lt11, nyZone11);
            System.out.println("Raw -> Current zoned time NY: " + zdt11Ny);
            // tokyo specific
            ZoneId tokZone11 = ZoneId.of("Asia/Tokyo");
            ZonedDateTime zdt11Tok = ZonedDateTime.of(2023, 12, 25, 15, 30, 0,0,  tokZone11);
            System.out.println("Raw -> Current zoned time Tok: " + zdt11Tok);
            // format
            String pattern11 = "'Year: ' yyyy '; Month: ' MM '; Day: ' dd '; Hour: ' HH '; Minute: ' mm '; Offset: ' XX '; Zone: ' VV";
            DateTimeFormatter dtf11 = DateTimeFormatter.ofPattern(pattern11);
            String localPretty = zdt11Now.format(dtf11);
            String nyPretty = zdt11Ny.format(dtf11);
            String tokPretty = zdt11Tok.format(dtf11);
            System.out.println("Pretty -> Current zoned time system: " + localPretty);
            System.out.println("Pretty -> Current zoned time Tok: " + nyPretty);
            System.out.println("Pretty -> Current zoned time Tok: " + tokPretty);
            System.out.println();

            /*
            Task 12: Add and Subtract Time Across Zones
            Take a ZonedDateTime of now in "Europe/London".
            Add 5 hours and subtract 2 days.
            Then convert (with withZoneSameInstant) this updated time to "Australia/Sydney" and "America/Los_Angeles".
            Print all results.
            Observe and explain the differences in hours between zones.
             */
            System.out.println("Task 12: ");

            String zoneName = "Europe/London";
            ZoneId zone12Lond = ZoneId.of(zoneName);
            ZonedDateTime zdt12Lond = ZonedDateTime.now(zone12Lond);
            System.out.println("London original: " + zdt12Lond);

            ZonedDateTime zdt12LondModif = zdt12Lond.plusHours(5).minusDays(2);
            System.out.println("London modified: " + zdt12LondModif);

            Instant lond12ToInst = zdt12LondModif.toInstant();

            ZoneId zone12Aus = ZoneId.of("Australia/Sydney");
            ZonedDateTime zdt12Austr = ZonedDateTime.ofInstant(lond12ToInst, zone12Aus);
            System.out.println("Australia modified: " + zdt12Austr);
            ZoneId zone12La = ZoneId.of("America/Los_Angeles");
            ZonedDateTime zdt12La = ZonedDateTime.ofInstant(lond12ToInst, zone12La);
            System.out.println("Australia modified: " + zdt12La);
            System.out.println();

            /*
            Task 13: Parse and Format ZonedDateTime Strings
            Given the string "2025-04-26T10:15:30+02:00[Europe/Paris]", parse it into a ZonedDateTime.
            Then format it in 3 styles:
            ISO format (DateTimeFormatter.ISO_ZONED_DATE_TIME)
            Custom format like "dd MMM yyyy HH:mm:ss z"
            Only date and time without zone (example: "yyyy-MM-dd HH:mm:ss")
             */
            System.out.println("Task 13");
            String zdtToParse = "2025-04-26T10:15:30+02:00[Europe/Paris]";
            ZonedDateTime zdt13 = ZonedDateTime.parse(zdtToParse);

            String formatted;

            DateTimeFormatter dtf13iso = DateTimeFormatter.ISO_ZONED_DATE_TIME;
            formatted = zdt13.format(dtf13iso);
            System.out.println("ISO -> " + formatted);

            String pattern13 = "dd MMM yyyy HH:mm:ss z";
            DateTimeFormatter dtf13custom = DateTimeFormatter.ofPattern(pattern13);
            formatted = zdt13.format(dtf13custom);
            System.out.println("Custom -> " + formatted);

            pattern13 = "yyyy-MM-dd HH:mm:ss";
            DateTimeFormatter dtf13short = DateTimeFormatter.ofPattern(pattern13);
            formatted = zdt13.format(dtf13short);
            System.out.println("Short -> " + formatted);
            System.out.println();

            /*
            Task 14: Compare ZonedDateTime Moments
            Create two ZonedDateTime instances:
            One in "Asia/Kolkata" at 2025-01-01 10:00.
            One in "Europe/Paris" at 2025-01-01 5:00.
            Check if they represent the same instant in time (hint: use isEqual).
            Also, check if the first is before or after the second (hint: use isBefore and isAfter).
             */
            System.out.println("Task 14: ");

            LocalTime lt14Ten = LocalTime.parse("10:00");
            LocalTime lt14Five = LocalTime.parse("05:00");
            LocalDate ld14 = LocalDate.parse("2025-01-01");

            ZoneId zone14Kolk = ZoneId.of("Asia/Kolkata");
            ZoneId zone14Par = ZoneId.of("Europe/Paris");

            ZonedDateTime zdt14Kolk = ZonedDateTime.of(ld14, lt14Ten, zone14Kolk);
            ZonedDateTime zdt14Par = ZonedDateTime.of(ld14, lt14Five, zone14Par);

            System.out.println("Asia/Kolkata at 2025-01-01 10:00 before Europe/Paris at 2025-01-01 5:00? ... " + zdt14Kolk.isBefore(zdt14Par));
            System.out.println("Asia/Kolkata at 2025-01-01 10:00 after Europe/Paris at 2025-01-01 5:00? ... " + zdt14Kolk.isAfter(zdt14Par));
            System.out.println("Asia/Kolkata at 2025-01-01 10:00 equals Europe/Paris at 2025-01-01 5:00? ... " + zdt14Kolk.isEqual(zdt14Par));
            System.out.println();

    }

}
