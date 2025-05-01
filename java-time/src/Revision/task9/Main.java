package Revision.task9;

/*
Task 9: Leap Year Check
Years: 2020, 2021, 2024
Output:
2020 is a leap year: true
2021 is a leap year: false
2024 is a leap year: true
 */

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LocalDate ld = LocalDate.of(2020, 1, 1);
        System.out.println(ld.getYear() + " is leap? ... " + ld.isLeapYear());

        ld = ld.withYear(2021);
        System.out.println(ld.getYear() + " is leap? ... " + ld.isLeapYear());

        ld = ld.withYear(2024);
        System.out.println(ld.getYear() + " is leap? ... " + ld.isLeapYear());

    }

}
