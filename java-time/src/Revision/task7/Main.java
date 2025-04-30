package Revision.task7;

/*
Task 7: Add and Subtract Time
Base: 2025-01-01
Add 6 months
Subtract 2 weeks
Output:
After 6 months: 2025-07-01
2 weeks earlier: 2024-12-18
 */

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        LocalDateTime ldtBase = LocalDateTime.of(2025, 12, 28, 22, 13, 5);
        System.out.println("LocalDateTime Before: " + ldtBase);

        LocalDateTime ldtModif = ldtBase.plusMonths(6).plusWeeks(2);
        System.out.println("LocalDateTime Modified: " + ldtModif);

    }

}
