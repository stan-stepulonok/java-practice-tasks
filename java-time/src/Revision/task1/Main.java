package Revision.task1;

/*
Task 1: LocalDate and Period
Goal: Calculate a person’s age.
Input: a birth date (LocalDate.of(1999, 5, 10)).
Use Period.between() to find out how old the person is.
 */

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        System.out.println("LocalDate - Now: " + now);

        LocalDate birthday = LocalDate.of(1999, 5, 10);
        System.out.println("LocalDate - Birthday: " + birthday);

        Period periodBetweenNowAndBirthday = Period.between(birthday, now);
        System.out.println("Period as is: " + periodBetweenNowAndBirthday);

        int yearsOld = periodBetweenNowAndBirthday.getYears();
        System.out.println("Full years: " + yearsOld);

        System.out.println("Total age: " + periodBetweenNowAndBirthday.getYears() + " years; " + periodBetweenNowAndBirthday.getMonths() + " months; " + periodBetweenNowAndBirthday.getDays() + " days.");

    }

}
