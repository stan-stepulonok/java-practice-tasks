package Revision.task8;

/*
Task 8: Start and End of Month
Output:
First day: 2025-04-01 (TUESDAY)
Last day: 2025-04-30 (WEDNESDAY)
 */

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Main {

    public static void main(String[] args) {

        LocalDate ldNow = LocalDate.now();
        System.out.println("LocalDateTime Now: " + ldNow);

        TemporalAdjuster taFirstDayOfMonth = TemporalAdjusters.firstDayOfMonth();
        LocalDate firstDayOfMonth = ldNow.with(taFirstDayOfMonth);
        System.out.println("First Day Of Month: " + firstDayOfMonth);

        TemporalAdjuster taLastDayOfMonth = TemporalAdjusters.lastDayOfMonth();
        LocalDate lastDayOfMonth = ldNow.with(taLastDayOfMonth);
        System.out.println("Last Day Of Month: " + lastDayOfMonth);

    }

}
