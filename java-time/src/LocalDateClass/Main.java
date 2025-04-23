package LocalDateClass;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1:Create Current Date
        Task:
        Create a LocalDate object that stores the current date and print it.
        Expected Output Example:
        Current date:2025-04-23
         */
        System.out.println("Task 1:");
        LocalDate ld1 = LocalDate.now();
        System.out.println(ld1);
        System.out.println();

        /*
        Task 2: Create a Specific Date
        Task: Create a date using the of(int year, int month, int dayOfMonth) method for your birthday.
        Expected Output Example:
        Birthday: 1999-07-15
         */
        System.out.println("Task 2:");
        int year = 2025;
        int month = 12;
        int dayOfMonth = 30;
        LocalDate ld2 = LocalDate.of(year, month, dayOfMonth);
        System.out.println(ld2);
        System.out.println();

        /*
        Task 3: Parse a Date from String
        Task: Parse the following string into a LocalDate: "2020-12-25".
        Expected Output:
        Parsed date: 2020-12-25
         */
        System.out.println("Task 3:");
        // ISO_LOCAL_DATE_TIME -> yyyy-MM-dd'T'HH:mm:ss -> "2023-08-15T14:30:00" -> "2020-12-25"
        String strDate3 = "2020-12-25";
        LocalDate ld3 = LocalDate.parse(strDate3);
        System.out.println(ld3);
        System.out.println();

        /*
        Task 4: Get Date Components
        Task: From today’s date, print:
        Day of week
        Day of month
        Day of year
        Month
        Year
        Expected Output Example:
        Day of week: WEDNESDAY
        Day of month: 23
        Day of year: 113
        Month: APRIL
        Year: 2025
         */
        System.out.println("Task 4:");
        LocalDate ld4 = LocalDate.now();
        DayOfWeek dayWeekEnum = ld4.getDayOfWeek();
        Month monthEnum = ld4.getMonth();
        int monthNum = ld4.getMonthValue();
        int yearNum = ld4.getYear();
        int dayNum = ld4.getDayOfMonth();
        System.out.println("Day of week enum: " + dayWeekEnum);
        System.out.println("Month enum: " + monthEnum);
        System.out.println("Month num: " + monthNum);
        System.out.println("Year: " + yearNum);
        System.out.println("Day num: " + dayNum);
        System.out.println();

        /*
        Task 5: Add and Subtract Time
        Task: From your birthday, add 100 days. Then subtract 2 years and 3 months.
        Expected Output Example:
        After 100 days: 1999-10-23
        Minus 2 years and 3 months: 1997-07-23
         */
        System.out.println("Task 5:");
        String birthdayStr = "2025-04-23";
        LocalDate ld5 = LocalDate.parse(birthdayStr);
        LocalDate ld5Modified = ld5.plusDays(100).minusYears(2).minusMonths(3);
        System.out.println("Original: " + ld5);
        System.out.println("Modified: " + ld5Modified);
        System.out.println();

        /*
        Task 6: Compare Dates
        Task: Compare two dates (e.g., your birthday and today). Check if one is before, after, or equal.
        Expected Output Example:
        Is birthday before today? true
        Is birthday after today? false
        Is birthday equal to today? false
         */
        System.out.println("Task 6: ");
        LocalDate ld6Now = LocalDate.now();
        LocalDate birthdayThisYear = LocalDate.of(2025, 6, 29);
        System.out.println("Now before birthday? ... " + ld6Now.isBefore(birthdayThisYear));
        System.out.println("Now after birthday? ... " + ld6Now.isAfter(birthdayThisYear));
        int comparisonResults = ld6Now.compareTo(birthdayThisYear);
        boolean comparisonResult = false;
        if (comparisonResults == 0) comparisonResult = true;
        System.out.println("Now equals birthday? ... " + comparisonResult);
        System.out.println();

        /*
        Task 7: Use with() to Change Fields
        Task: From today’s date, create:
        a date with the year changed to 2000
        a date with the first day of the month
        Expected Output Example:
        With year 2000: 2000-04-23
        With first day of month: 2025-04-01
         */
        System.out.println("Task 7: ");
        LocalDate ld7 = LocalDate.now();
        LocalDate ld7Year2000 = ld7.withYear(2000);
        LocalDate ld7FirstDayOfMonth = ld7.withDayOfMonth(1);
        System.out.println("Before: " + ld7);
        System.out.println("2000: " + ld7Year2000);
        System.out.println("FirstDayMonth: " + ld7FirstDayOfMonth);
        System.out.println();

        /*
        Task 8: Use TemporalAdjusters
        Task: Use TemporalAdjusters to find:
        the first day of next month
        the last day of the current month
        the next Sunday
        Expected Output Example:
        First day of next month: 2025-05-01
        Last day of this month: 2025-04-30
        Next Sunday: 2025-04-27
         */
        System.out.println("Task 8: ");
        LocalDate ld8 = LocalDate.of(2020, 11, 29);
        LocalDate ld8FirstDayNextMonth = ld8.with(TemporalAdjusters.firstDayOfNextMonth());
        LocalDate ld8LastDayCurrentMonth = ld8.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Original date: " + ld8);
        System.out.println("First day of next month: " + ld8FirstDayNextMonth);
        System.out.println("Last day of this month: " + ld8LastDayCurrentMonth);
        System.out.println();

        /*
        Task 9: Leap Year Check
        Task: Check whether the years 2020, 2023, and 2024 are leap years.
        Expected Output:
        2020 is leap year: true
        2023 is leap year: false
        2024 is leap year: true
         */
        System.out.println("Task 9: ");
        String check1 = "2020-12-30";
        String check2 = "2023-12-30";
        String check3 = "2024-12-30";
        LocalDate ld91 = LocalDate.parse(check1);
        LocalDate ld92 = LocalDate.parse(check2);
        LocalDate ld93 = LocalDate.parse(check3);
        System.out.println(ld91.getYear() + " is leap? ... " + ld91.isLeapYear());
        System.out.println(ld92.getYear() + " is leap? ... " + ld92.isLeapYear());
        System.out.println(ld93.getYear() + " is leap? ... " + ld93.isLeapYear());
        System.out.println();

        /*
        Task 10: Days Between Two Dates
        Task: Calculate how many days are between 2020-01-01 and 2025-04-23.
        Expected Output Example:
        Days between: 1939
         */
        System.out.println("Task 10:");
        LocalDate ld10Now = LocalDate.now();
        LocalDate ld102026 = ld10Now.withYear(2026);
//        Period betweenPeriod = Period.between(ld10Now, ld102026);
//        int daysBetween = betweenPeriod.getDays();
//        System.out.println("Days between " + ld10Now + " and " + ld102026 + " -> " + daysBetween);
//        RETURNED 0 BECAUSE IT COMPARES DAYS ONLY
        long daysBetween = ChronoUnit.DAYS.between(ld10Now, ld102026);
        System.out.println("Days between " + ld10Now + " and " + ld102026 + " -> " + daysBetween);

    }

}
