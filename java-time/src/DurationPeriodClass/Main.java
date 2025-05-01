package DurationPeriodClass;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1: Create and Print a Duration // use of()
        Create a Duration of 90 minutes.
        Print the number of seconds in this duration.
         */
        System.out.println("Task 1:");
        Duration dur1Chr = Duration.of(90, ChronoUnit.MINUTES);
        Duration dur1Min = Duration.ofMinutes(90);
        System.out.println("Duration as is -> " + dur1Chr);
        System.out.println("Duration as is -> " + dur1Min);
        System.out.println();

        // P stands for "Period" and is defined by the ISO-8601 standard.
        //This is the prefix used to indicate that what follows is a time-based or date-based duration.
        //Even though Java distinguishes between Duration and Period, ISO-8601 uses the same P to start both.
        // Duration -> PT1H30M
        // Period -> P2Y5M10D

        /*
        Task 2: Create and Print a Period // use of()
        Create a Period of 2 years, 5 months, and 10 days.
        Print the total number of months (years × 12 + months) and days separately.
         */
        System.out.println("Task 2:");
        Period per2 = Period.of(2, 5, 10);
        System.out.println("Period as is -> " + per2);
        int month2 = per2.getMonths();
        System.out.println("Months from period: " + month2);
        int totalMonth2 = per2.getMonths() + per2.getYears()*12;
        System.out.println("Years converted to months + months: " + totalMonth2);
        int days2 = per2.getDays();
        System.out.println("Days: " + days2);
        System.out.println("Final output: " + totalMonth2 + " months and " + days2 + " days!");
        System.out.println();

        // The result is positive if end is after start, and negative if end is before start.

        /*
        Task 3: Duration Between Two Instants
        Create two Instant objects:
        One is Instant.now().
        The second is 3 hours later.
        Calculate the Duration between them and print it.
         */
        System.out.println("Task 3: ");
        Instant inst3Now = Instant.now();
        Instant inst3NowPlus3 = inst3Now.plus(3, ChronoUnit.HOURS);
        Duration dur3 = Duration.between(inst3Now, inst3NowPlus3);
        System.out.println("Now - Now+3 -> " + dur3);
        Duration dur3Rev = Duration.between(inst3NowPlus3, inst3Now);
        System.out.println("Now+3 - Now -> " + dur3Rev);
        System.out.println();

        /*
        Task 4: Period Between Two LocalDates
        Create two LocalDate objects:
        One is today.
        The second is 1 year and 15 days later.
        Calculate the Period between them and print the number of years, months, and days.
         */
        System.out.println("Task 4: ");
        LocalDate ld4 = LocalDate.now();
        LocalDate ld4Later = ld4.plus(1, ChronoUnit.YEARS).plus(15, ChronoUnit.DAYS);
        System.out.println("Before: " + ld4);
        System.out.println("After: " + ld4Later);
        Period per4 = Period.between(ld4, ld4Later);
        System.out.println("Period: " + per4);
        System.out.println("Years: " + per4.getYears());
        System.out.println("Months: " + per4.getMonths());
        System.out.println("Days: " + per4.getDays());
        System.out.println();

        /*
        Task 5: Showcase Difference — Time vs Date
        Try calculating the Duration between two LocalDate objects.
        What happens?
        Then calculate the Period between two LocalTime (or Instant) objects.
        What happens?
         */
        System.out.println("Task 5: ");

        System.out.println("Case 1: working with dates, use Period");
        String date51 = "2024-12-31", date52 = "2025-11-30";
        LocalDate ld5Before = LocalDate.parse(date51);
        LocalDate ld5After = LocalDate.parse(date52);
        System.out.println("Valid case - Period for dates: ");
        Period per5Val = Period.between(ld5Before, ld5After);
        System.out.println(per5Val);
        try {
            System.out.println("Invalid case - Duration for dates: ");
            Duration dur5Inv = Duration.between(ld5Before, ld5After);
            System.out.println(dur5Inv);
        } catch (RuntimeException e) {
            System.out.println(e);
            System.out.println("Exception in thread main java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds");
        }

        System.out.println("Case 2: working with time, use Duration");
        String time51 = "13:13:13", time52 = "23:23:23";
        LocalTime lt5Before = LocalTime.parse(time51);
        LocalTime lt5After = LocalTime.parse(time52);
        System.out.println("Valid case - Duration for time: ");
        Duration dur5Val = Duration.between(lt5Before, lt5After);
        System.out.println(dur5Val);
        System.out.println("Invalid case - Period for time: ");
        // Period per5Inv = Period.between(lt5Before, lt5After); // fails with the compilation error, date expected as params
        System.out.println("Compilation error!");
        System.out.println();

        /*
        Task 6: Add Duration and Period
        Create a LocalDateTime for now.
        Add a Duration of 10 hours to it.
        Then add a Period of 1 month to it.
        Print all results.
         */
        System.out.println("Task 6: ");
        LocalDateTime ldt6 = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        System.out.println("LocalDateTime before -> " + ldt6);
        Duration dur6 = Duration.ofHours(10);
        ldt6 = ldt6.plus(dur6);
        System.out.println("LocalDateTime after adding Duration 10 hours -> " + ldt6);
        Period per6 = Period.ofMonths(1);
        ldt6 = ldt6.plus(per6);
        System.out.println("LocalDateTime after adding Period 1 months -> " + ldt6);
        System.out.println();

        /*
        Task 7: Parse Duration and Period from String
        Parse a Duration from the string "PT36H" (36 hours).
        Parse a Period from the string "P2Y3M" (2 years 3 months).
        Print both.
         */
        System.out.println("Task 7: ");
        String durationStr = "PT36H";
        Duration dur7 = Duration.parse(durationStr);
        System.out.println("Duration: " + dur7);
        String periodStr = "P2Y3M";
        Period per7 = Period.parse(periodStr);
        System.out.println("Period: " + per7);
        System.out.println();

        /*
        Task 8: Truncate Duration
        Create a Duration of 2 hours 45 minutes 30 seconds.
        Truncate it to minutes (drop seconds part).
        Print before and after truncation.
         */
        System.out.println("Task 8: ");
        Duration dur8 = Duration.ofHours(2);
        dur8 = dur8.plus(45, ChronoUnit.MINUTES).plus(30, ChronoUnit.SECONDS);
        System.out.println("Duration before truncation -> " + dur8);
        dur8.truncatedTo(ChronoUnit.MINUTES);
        System.out.println("Duration after truncation -> " + dur8); // S remains
        System.out.println();

        // Example of usage:
        // duration built in method -> public boolean isNegative()
        // if (duration.isNegative()) { System.out.println("You are overdue!"); }

        /*
        Task 9: Negative Durations and Periods
        Create a Duration representing -5 minutes.
        Create a Period representing -2 days.
        Print both and explain the difference.
         */
        System.out.println("Task 9: ");
        Duration dur9 = Duration.ofMinutes(-5);
        System.out.println("Negative minute duration: " + dur9);
        Period per9 = Period.ofDays(-2);
        System.out.println("Negative days period: " + per9);
        System.out.println();

        /*
        Task 10: Bonus: Duration vs Period in Loops
        Starting from today, add 1 Period of 1 month each loop step.
        In another loop, starting from now, add 1 Duration of 30 days each step.
        After 6 iterations:
        Compare the final dates.
        Are they the same or different?
        Print your conclusions.
         */
        System.out.println("Task 10: ");
        System.out.println("Original: " + LocalDateTime.now());
        LocalDateTime ldt10Dur = LocalDateTime.now();
        for (int i = 0; i < 6; i++) {
            ldt10Dur = ldt10Dur.plus(Duration.ofDays(30));
        }
        LocalDateTime ldt10Per = LocalDateTime.now();
        for (int i = 0; i < 6; i++) {
            ldt10Per = ldt10Per.plus(Period.ofMonths(1));
        }
        System.out.println("Added duration 30 days: " + ldt10Dur);
        System.out.println("Added period 1 months: " + ldt10Per);
        System.out.println();

    }

}
