package DateTimeFormatterClass;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        String pattern = "";

        /*
        Task 1: Format Current Date in a Custom Style
        Get the current LocalDate.
        Format it to show: Tuesday, 29 April 2025.
        Use .format() with a suitable DateTimeFormatter.
         */
        System.out.println("Task 1: ");

        LocalDate ld1 = LocalDate.now();
        System.out.println("Original: " + ld1);

        pattern = "EEEE',' dd MMMM yyyy";
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(pattern);

        System.out.println("Format from DateTimeFormatter: " + dtf1.format(ld1));
        System.out.println("Format from LocalDate: " + ld1.format(dtf1));

        System.out.println();

        /*
        Task 2: Format LocalDateTime to Display Time with AM/PM
        Create a LocalDateTime object with the time 14:30:15.
        Format it to show: 02:30:15 PM.
         */
        System.out.println("Task 2: ");
        LocalDateTime ldt2 = LocalDateTime.now().withHour(14).withMinute(30).withSecond(15).truncatedTo(ChronoUnit.SECONDS);
        System.out.println("Original LocalDateTime: " + ldt2);
        pattern = "'Date:' yyyy-MM-dd'; Time:' hh:mm:ss a";
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(pattern);
        System.out.println("Formatterd: " + dtf2.format(ldt2));
        System.out.println();

        /*
        Task 3: Format ZonedDateTime with Time Zone
        Create a ZonedDateTime using a specific zone like Europe/Warsaw.
        Format it to output like: 2025-04-29T18:30:00+02:00[Europe/Warsaw].
         */
        System.out.println("Task 3: ");
        String timeZone3 = "Europe/Warsaw";
        ZoneId zone3 = ZoneId.of(timeZone3);
        ZonedDateTime zdt3 = ZonedDateTime.now(zone3);
        pattern = "yyyy-MM-dd'T'HH:mm:ssXXX'['VV']'";
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern(pattern);
        String result = dtf3.format(zdt3);
        System.out.println("Formatter: " + result);
        System.out.println();

        /*
        Task 4: Parse a String to LocalDate
        Given a date string like "31-12-2024", parse it into a LocalDate.
        Use LocalDate.parse(string, formatter) with a formatter that matches the input.
         */
        System.out.println("Task 4: ");
        String strToParse4 = "31-12-2024";
        System.out.println("Original string -> " + strToParse4);
        pattern = "dd-MM-yyyy";
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern(pattern);
        LocalDate ld4 = LocalDate.parse(strToParse4, dtf4);
        System.out.println("LocalDate -> " + ld4);
        System.out.println();

        /*
        Task 5: Parse a LocalDateTime String with Time
        Parse a string like "2025/01/15 17:45" into a LocalDateTime.
         */
        System.out.println("Task 5: ");
        String strToParse5 = "2025/01/15 17:45";
        System.out.println("Original string: " + strToParse5);
        pattern = "yyyy/MM/dd HH:mm";
        DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime ldt5 = LocalDateTime.parse(strToParse5, dtf5);
        System.out.println("LocalDateTime parsed: " + ldt5);
        System.out.println();

        /*
        Task 6: Format Duration (manually)
        Create a Duration of 2 hours, 15 minutes, and 30 seconds.
        Manually format and print it as: 02:15:30.
        Note: Duration has no built-in formatter — use toHoursPart(), toMinutesPart(), etc.
         */
        System.out.println("Task 6: ");
        Duration dur5 = Duration.ofHours(2).plus(15, ChronoUnit.MINUTES).plus(30, ChronoUnit.SECONDS);
        System.out.println("Duration: " + dur5);
        System.out.printf(dur5.toHoursPart() + ":" + dur5.toMinutesPart() + ":" + dur5.toSecondsPart());
        // System.out.printf("%02d:%02d:%02d%n", dur5.toHoursPart(), dur5.toMinutesPart(), dur5.toSecondsPart());
        System.out.println();

        /*
        Task 7: Round-Trip Test
        Format a LocalDateTime into a custom string.
        Parse that string back into a LocalDateTime.
        Verify both objects are equal.
         */
        System.out.println("Task 7: ");
        LocalDateTime ldt7From = LocalDateTime.now();
        System.out.println("Original: " + ldt7From);
        String from7 = ldt7From.toString();
        System.out.println("String: " + from7);
        pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
        DateTimeFormatter dtf7 = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime ld7To = LocalDateTime.parse(from7, dtf7);
        System.out.println("New: " + ld7To);
        System.out.println("Equals? ... " + ld7To.equals(ldt7From));
        System.out.println();

        /*
        Task 8: Parse and Format ZonedDateTime
        Parse a string like "2025-10-31 21:15 Europe/London" into ZonedDateTime.
        Format it back to: 31 Oct 2025, 09:15 PM (Europe/London).
         */
        System.out.println("Task 8: ");
        String strToParse8 = "2025-10-31 21:15 Europe/London";
        System.out.println("Original string: " + strToParse8);
        pattern = "yyyy-MM-dd HH:mm VV";
        DateTimeFormatter dtf8 = DateTimeFormatter.ofPattern(pattern);
        ZonedDateTime zdt8 = ZonedDateTime.parse(strToParse8, dtf8);
        System.out.println("ZonedDateTime: " + zdt8);
        pattern = "dd MMM yyyy',' hh:mm a";
        dtf8 = DateTimeFormatter.ofPattern(pattern);
        String result8 = zdt8.format(dtf8);
        System.out.println("New string: " + result8);
        System.out.println();

        /*
        Task 9: Format in ISO Format
        Take any LocalDateTime and format it using ISO_LOCAL_DATE_TIME.
        Also use BASIC_ISO_DATE with a LocalDate.
         */
        System.out.println("Task 9: ");
        LocalDateTime ldt9 = LocalDateTime.now();
        System.out.println("LocalDateTime original: " + ldt9);
        DateTimeFormatter dtf9;
        dtf9 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        System.out.println("LocalDateTime formatted: " + ldt9.format(dtf9));
        LocalDate ld9 = LocalDate.now();
        System.out.println("LocalDate original: " + ld9);
        dtf9 = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println("LocalDateTime formatted: " + ld9.format(dtf9));
        System.out.println();

        /*
        Task 10: Format with Literal Tex
        Format a LocalDateTime to something like.
        Today is 29 of April, 2025 — 10:45 AM.
        Use quoted literals inside your formatter.
         */
        System.out.println("Task 10: ");
        LocalDateTime ldt10 = LocalDateTime.now();
        System.out.println("LocalDateTime before: " + ldt10);
        pattern = "'Today is' dd 'of' MMMM',' yyyy '—' hh:mm a";
        DateTimeFormatter dtf10 = DateTimeFormatter.ofPattern(pattern);
        System.out.println("After: ");
        System.out.println(ldt10.format(dtf10));
        System.out.println();

    }

}
