package LocalDateTimeClass;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1: Create Current DateTime
        Task: Create a LocalDateTime object that stores the current system date and time, and print it.
        Expected Output Example:
        Current datetime: 2025-04-26T15:30:45.123
         */
        System.out.println("Task 1: ");
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println("Full: " + ldt1);
        System.out.println("Truncated: " + ldt1.truncatedTo(ChronoUnit.SECONDS));
        System.out.println();

        /*
        Task 2: Create Specific DateTime
        Task: Create a LocalDateTime for 2025-12-31 at 23:59:59 using the of(...) method.
        Expected Output:
        Created datetime: 2025-12-31T23:59:59
         */
        System.out.println("Task 2: ");
        LocalDateTime ldt2 = LocalDateTime.of(2025, 12, 31, 23, 59,59);
        System.out.println(ldt2);
        System.out.println();

        /*
        Task 3: Parse a DateTime from String
        Task: Parse "2023-07-15T18:20:30" into a LocalDateTime object.
        Expected Output:
        Parsed datetime: 2023-07-15T18:20:30
         */
        System.out.println("Task 3: ");
        String ldt3Str = "2023-07-15T18:20:30";
        LocalDateTime ldt3 = LocalDateTime.parse(ldt3Str);
        System.out.println(ldt3);
        System.out.println();

        /*
        Task 4: Get DateTime Components
        Task: From a LocalDateTime.now(), print:
        Year
        Month Value
        Day of Month
        Hour
        Minute
        Second
        Nano
         */
        System.out.println("Task 4: ");
        LocalDateTime ldt4 = LocalDateTime.now();
        int year = ldt4.getYear();
        int monthNum = ldt4.getMonthValue();
        Month monthName = ldt4.getMonth();
        int dayNum = ldt4.getDayOfMonth();
        DayOfWeek dayName = ldt4.getDayOfWeek();
        int hour = ldt4.getHour();
        int minute = ldt4.getMinute();
        int second = ldt4.getSecond();
        int nano = ldt4.getNano();
        System.out.println("LocalDateTime -> " + ldt4);
        System.out.println("Values: -> " + year + " " + monthNum + " " + monthName + " " + dayNum + " " + dayName + " " + hour + " " + minute + " " + second + " " + nano );
        System.out.println();

        /*
        Task 5: Add and Subtract DateTime
        Task: From 2024-01-01T10:00:
        Add 10 days and 5 hours
        Subtract 30 minutes
         */
        System.out.println("Task 5: ");
        String ldt5Str = "2024-01-01T10:00:00";
        LocalDateTime ldt5Original = LocalDateTime.parse(ldt5Str);
        LocalDateTime ldt5Modif = ldt5Original.plusDays(10).plusHours(5).minusMinutes(30);
        System.out.println("Original: " + ldt5Original);
        System.out.println("Modified: " + ldt5Modif);
        System.out.println();

        /*
        Task 6: Compare DateTimes
        Task: Compare LocalDateTime.of(2025, 5, 1, 12, 0) and current time.
        Print if:
        First is before now
        First is after now
        First equals now
         */
        System.out.println("Task 6: ");
        LocalDateTime ldt6Comp = LocalDateTime.of(2025, 5, 1, 12, 0, 0).truncatedTo(ChronoUnit.SECONDS);
        LocalDateTime ldt6Now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        System.out.println(ldt6Now + " before " + ldt6Comp + "? ... " + ldt6Now.isBefore(ldt6Comp));
        System.out.println(ldt6Now + " after " + ldt6Comp + "? ... " + ldt6Now.isAfter(ldt6Comp));
        boolean compResult = (ldt6Now.compareTo(ldt6Comp) == 0);
        System.out.println(ldt6Now + " equals " + ldt6Comp + "? ... " + compResult);
        System.out.println();

        /*
        Task 7: Use with() to Change DateTime
        Task: From 2025-07-20T22:15:
        Change the year to 2030
        Change the minute to 0
         */
        System.out.println("Task 7: ");
        String ldt7Str = "2025-07-20T22:15:00";
        LocalDateTime ld7 = LocalDateTime.parse(ldt7Str);
        LocalDateTime ld7ModifWith = ld7.withYear(2030).withMinute(0);
        System.out.println("Original: " + ld7.truncatedTo(ChronoUnit.SECONDS));
        System.out.println("Modified: " + ld7ModifWith.truncatedTo(ChronoUnit.SECONDS));
        System.out.println();

        /*
        Task 8: Truncate DateTime
        Task: Use truncatedTo(ChronoUnit.HOURS) and truncatedTo(ChronoUnit.DAYS) on the current datetime.
         */
        System.out.println("Task 8: ");
        LocalDateTime ldt8 = LocalDateTime.now();
        ldt8 = ldt8.truncatedTo(ChronoUnit.SECONDS);
        System.out.println(ldt8);
        System.out.println();

        /*
        Task 9: Duration Between Two DateTimes
        Task: Find the number of minutes between:
        2025-04-26T08:00 and 2025-04-26T10:30
         */
        System.out.println("Task 9: ");
        LocalDateTime ldtBefore = LocalDateTime.of(2025, 04, 26, 8, 0, 0);
        LocalDateTime ldtAfter = LocalDateTime.of(2025, 04, 26, 10, 30, 0);
        long minutesBetween = ChronoUnit.MINUTES.between(ldtBefore, ldtAfter);
        System.out.println("Minutes between: " + minutesBetween);
        System.out.println();

         /*
        Task 10: Format LocalDateTime
        Task: Format LocalDateTime.now() into pattern "dd-MM-yyyy HH:mm:ss".
        Example:
        26-04-2025 15:31:10
         */
        System.out.println("Task 10: ");
        String formatPattern = "dd-MM-yyyy HH:mm:ss";
        LocalDateTime ldt10 = LocalDateTime.now();
        System.out.println("Before formatting: " + ldt10);
        DateTimeFormatter dtf10 = DateTimeFormatter.ofPattern(formatPattern);
        String resultFormatted = ldt10.format(dtf10);
        System.out.println("After formatting str: " + resultFormatted);
        System.out.println();

        /*
        Task 11: Get Start and End of Day
        Task: For LocalDateTime.now(), print:
        - Start of day (time set to 00:00)
        - End of day (time set to 23:59:59.999999999)
         */
        System.out.println("Task 11: ");
        LocalDateTime ldt11 = LocalDateTime.now();
        LocalDateTime ldt11Start = ldt11.withHour(0).withMinute(0);
        LocalDateTime ldt11End = ldt11.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
        System.out.println(ldt11);
        System.out.println(ldt11Start);
        System.out.println(ldt11End);
        System.out.println();

        /*
        Task 12: Calculate Days Between Two Dates
        Task: Calculate the number of days between 2024-05-01 and 2025-05-01.
         */
        System.out.println("Task 12: ");
        LocalDateTime ldt12One = LocalDateTime.of(2024, 5, 1, 0,0,0);
        LocalDateTime ldt12Two = LocalDateTime.of(2025, 5, 1, 0,0,0);
        long daysBetween = ChronoUnit.DAYS.between(ldt12One, ldt12Two);
        System.out.println("Days between " + ldt12One + " and " + ldt12Two + " -> " + daysBetween);
        System.out.println();

        /*
        Task 13: Find Next Monday at 9 AM
        Task: From LocalDateTime.now(), calculate the next Monday 9:00 AM.
         */
        System.out.println("Task 13: ");
        LocalDateTime ldt13 = LocalDateTime.now();
        System.out.println("Original: " + ldt13);
        LocalDateTime ldt13NextMonday = ldt13.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).withHour(9).withMinute(0).withSecond(0).withNano(0);
        System.out.println("Monday 9: " + ldt13NextMonday);
        System.out.println();

        /*
        Task 14: Custom Formatter with Text
        Task: Format LocalDateTime.now() like:
        "Today is Saturday, 26 of April 2025 at 15:45"
         */
        System.out.println("Task 14: ");
        LocalDateTime ldt14 = LocalDateTime.now();
        System.out.println("Original: " + ldt14);
        System.out.println("Approach 1: ");
        int year14 = ldt14.getYear();
        int dayMonth14 = ldt14.getDayOfMonth();
        DayOfWeek dayName14 = ldt14.getDayOfWeek();
        String dayName14Str = dayName14.toString().substring(0, 1) + dayName14.toString().substring(1).toLowerCase();
        Month monthName14 = ldt14.getMonth();
        String monthName14Str = monthName14.toString().substring(0, 1) + monthName14.toString().substring(1).toLowerCase();
        int hour14 = ldt14.getHour();
        int min14 = ldt14.getMinute();
        String result = String.format("Today is %s, %d of %s %d at %d:%d", dayName14Str, dayMonth14, monthName14Str, year14, hour14, min14);
        System.out.println(result);
        System.out.println("Approach 2: ");
        String pattern14 = "'Today is' EEEE, d 'of' MMMM yyyy 'at' HH:mm";
        DateTimeFormatter ftf14 = DateTimeFormatter.ofPattern(pattern14);
        result = ldt14.format(ftf14);
        System.out.println(result);
        System.out.println();

        /*
        Task 15: Check if the Year is Leap Year
        Task: Write code to check if the current year is a leap year.
         */
        System.out.println("Task 15: ");
        LocalDateTime ldt15 = LocalDateTime.now();
        boolean isLeap = ldt15.toLocalDate().isLeapYear();
        System.out.println(isLeap);
        System.out.println();

        /*
        Task 16: Add 2 Weeks, Subtract 3 Days
        Task: Starting from 2025-06-01T08:00, add 2 weeks, then subtract 3 days.
         */
        System.out.println("Task 16: ");
        String ldt16Str = "2025-06-01T08:00"; // do not need to DateTimeFormtatter as this is parsable
        LocalDateTime ldt16 = LocalDateTime.parse(ldt16Str);
        System.out.println("Original: " + ldt16);
        LocalDateTime ldt16Modif = ldt16.plusWeeks(2).minusDays(3);
        System.out.println("Modified: " + ldt16Modif);
        System.out.println();

        /*
        Task 17: Find the First Day of a Given Month
        Task: For LocalDateTime.of(2025, 10, 15, 14, 30), find the first day of October at midnight.
         */
        System.out.println("Task 17: ");
        LocalDateTime ldt17 = LocalDateTime.of(2025, 10, 15, 14, 30);
        System.out.println("Original: " + ldt17);
        ldt17 = ldt17.with(TemporalAdjusters.firstDayOfMonth()).withHour(0).withMinute(0);
        System.out.println("the 1st of October: " + ldt17);
        System.out.println();

        /*
        Task 18: Roll Over to Next Month
        Task: Add 40 days to 2025-01-25T12:00 and print the result.
         */
        System.out.println("Task 18: ");
        String ldt18Str = "2025-01-25T12:00";
        LocalDateTime ldt18 = LocalDateTime.parse(ldt18Str);
        System.out.println("Original: " + ldt18);
        ldt18 = ldt18.plusDays(40);
        System.out.println("+40 days: " + ldt18);
        System.out.println();

         /*
        Task 19: Get Day of Week and Month Name
        Task: From current datetime, print:
        - Day of week (name)
        - Month (name)
         */
        System.out.println("Task 19: ");
        LocalDateTime ldt19 = LocalDateTime.now();
        System.out.println(ldt19.getMonth());
        System.out.println(ldt19.getDayOfWeek());
        System.out.println();

        /*
        Task 20: Difference in Hours and Minutes
        Task: Find the difference in hours and minutes between:
        2025-04-26T06:15 and 2025-04-26T12:45
         */
        System.out.println("Task 20: ");
        String ldt20Str1 = "2025-04-26T06:15", ldt20Str2 = "2025-04-26T12:45";
        LocalDateTime ldt20One = LocalDateTime.parse(ldt20Str1);
        LocalDateTime ldt20Two = LocalDateTime.parse(ldt20Str2);
        long hoursBetween20 = ChronoUnit.HOURS.between(ldt20One, ldt20Two);
        System.out.println("Hours between " + ldt20One + " and " + ldt20Two + " -> " + hoursBetween20);
        long minutesBetween20 = ChronoUnit.MINUTES.between(ldt20One, ldt20Two);
        System.out.println("Hours between " + ldt20One + " and " + ldt20Two + " -> " + minutesBetween20);
        System.out.println();

    }

}
