package TemporalAdjustersClass;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1: Get the First Day of the Month
        Use TemporalAdjusters.firstDayOfMonth() on the current date.
        Output format: First day of this month: 2025-04-01
         */
        System.out.println("Task 1:");
        LocalDate ld1 = LocalDate.of(2025, 4, 25);
        System.out.println("Before: " + ld1);
        TemporalAdjuster taFirstDayNextMonth = TemporalAdjusters.firstDayOfMonth();
        LocalDate ldNextDay1 = ld1.with(taFirstDayNextMonth);
        System.out.println("After adjuster: " + ld1);
        System.out.println();

        /*
        Task 2: Find the Next Friday
        Use TemporalAdjusters to find the next Friday after today.
        Output format: Next Friday after today: 2025-05-02
         */
        System.out.println("Task 2:");
        LocalDate ld2 = LocalDate.now();
        System.out.println("Now: " + ld2);
        DayOfWeek friday2 = DayOfWeek.FRIDAY;
        TemporalAdjuster taNextFriday2 = TemporalAdjusters.next(friday2);
        LocalDate ldNextFriday2 = ld2.with(taNextFriday2);
        System.out.println("Next Friday: " + ldNextFriday2);
        System.out.println();

        /*
        Task 3: Find the Last Day of the Year
        Use TemporalAdjusters to get December 31st of the current year.
        Output format: Last day of this year: 2025-12-31
         */
        System.out.println("Task 3:");
        LocalDate ld3Now = LocalDate.now();
        System.out.println("Now: " + ld3Now);
        TemporalAdjuster taLastDayThisYear = TemporalAdjusters.lastDayOfYear();
        LocalDate ld3LastDayYear = ld3Now.with(taLastDayThisYear);
        System.out.println("Last day of year: " + ld3LastDayYear);
        System.out.println();

        /*
        Task 4: Get the Previous Monday
        Use TemporalAdjusters for the previous Monday from today.
        Output format: Previous Monday: 2025-04-28
         */
        System.out.println("Task 4:");
        LocalDate ld4Now = LocalDate.now();
        System.out.println("Now: " + ld4Now);
        DayOfWeek monday44 = DayOfWeek.MONDAY;
        TemporalAdjuster taPreviousMond = TemporalAdjusters.previous(monday44);
        LocalDate ldLastMon4 = ld4Now.with(taPreviousMond);
        System.out.println("Last(previous) Monday from today: " + ldLastMon4);
        System.out.println();

        /*
        Task 5: First Monday of a Given Month
        Input: LocalDate.of(2025, 10, 1)
        Use TemporalAdjusters
        Output: First Monday in October 2025: 2025-10-06
         */
        System.out.println("Task 2: ");
        LocalDate ld5 = LocalDate.of(2025, 10, 1);
        System.out.println("LocalDate before: " + ld5);
        DayOfWeek monday5 = DayOfWeek.MONDAY;
        TemporalAdjuster taFirstMondayThisMonth = TemporalAdjusters.firstInMonth(monday5);
        LocalDate ldFirstMondMonth = ld5.with(taFirstMondayThisMonth);
        System.out.println("First Monday in October 2025: " + ldFirstMondMonth);
        System.out.println();

        /*
        Task 6: Last Sunday of the Month Input:
        Use the current date
        Use TemporalAdjusters
        Output: Last Sunday of this month: 2025-04-27
         */
        System.out.println("Task 6: ");
        LocalDate ld6 = LocalDate.now();
        System.out.println("Now: " + ld6);
        ld6 = ld6.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println("Last Sunday in current month: " + ld6);
        System.out.println();

        /*
        Task 7: Nth Day of Week in Month
        Input: LocalDate.of(2025, 6, 1)
        Get the 3rd Wednesday using TemporalAdjusters.
        Output: 3rd Wednesday of June 2025: 2025-06-18
         */
        System.out.println("Task 7: ");
        LocalDate ldJune2025 = LocalDate.of(2025, 6, 18);
        DayOfWeek wednesday7 = DayOfWeek.WEDNESDAY;
        TemporalAdjuster taThirdWednesday = TemporalAdjusters.dayOfWeekInMonth(3, wednesday7); // 3 - ordinal порядковый номер
        LocalDate ldThirdWedn = ldJune2025.with(taThirdWednesday);
        System.out.println("Third Wednesday: " + ldThirdWedn);
        System.out.println();

        /*
        Task 8: Custom Adjuster – Next Working Day
        Create a custom TemporalAdjuster that returns the next working day (Mon–Fri).
        Skip Saturdays and Sundays.
        Output example:
        Today: 2025-04-26 (Saturday)
        Next working day: 2025-04-28 (Monday)
         */
        System.out.println("Task 8: ");
        LocalDate ldDay = LocalDate.of(2025, 4, 25);
        System.out.println("Day: " + ldDay);
        TemporalAdjuster customTempAdjNextWorkday = new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                LocalDate ld = LocalDate.from(temporal);
                DayOfWeek currentDay = ld.getDayOfWeek();
                if (currentDay.equals(DayOfWeek.FRIDAY)) {
                    ld = ld.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                    return ld;
                }
                ld = ld.withDayOfYear(ld.getDayOfYear()+1);
                return ld;
            }
        };
        LocalDate ldNextWorkday = ldDay.with(customTempAdjNextWorkday);
        System.out.println("Next workday: " + ldNextWorkday);
        System.out.println();


    }

}
