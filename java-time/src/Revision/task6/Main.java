package Revision.task6;

/*
Task 6: Next Wednesday
Input date: 2025-04-28
Output:
Next Wednesday is on 2025-04-30
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Main {

    public static void main(String[] args) {
        LocalDate ldNow = LocalDate.now();
        System.out.println("Now: " + ldNow);
        DayOfWeek wednesday = DayOfWeek.WEDNESDAY;
        TemporalAdjuster taNextWedn = TemporalAdjusters.next(wednesday);
        LocalDate nextWednesday = ldNow.with(taNextWedn);
        System.out.println("Next Wednesday: " + nextWednesday);
        System.out.println();

    }

}
