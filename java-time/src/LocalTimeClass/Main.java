package LocalTimeClass;

import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        /*
        Task 1: Create Current Time
        Task: Create a LocalTime object that stores the current system time and print it.
        Expected Output Example:
        Current time: 14:45:10.382
         */
        System.out.println("Task 1: ");
        LocalTime lt1 = LocalTime.now();
        System.out.println("Current time: " + lt1);
        System.out.println();

        /*
        Task 2: Create Specific Time
        Task: Create a LocalTime for 13:30:45 using the of(...) method.
        Expected Output:
        Time created: 13:30:45
         */
        System.out.println("Task 2: ");
        LocalTime lt2 = LocalTime.of(13, 30, 45);
        System.out.println("13:30:45 -> " + lt2);
        System.out.println();

        /*
        Task 3: Parse a Time from String
        Task: Parse "18:15:30" into a LocalTime object.
        Expected Output:
        Parsed time: 18:15:30
         */
        System.out.println("Task 3: ");
        String timeToParse = "18:15:30";
        LocalTime lt3 = LocalTime.parse(timeToParse);
        System.out.println("Parsed time: " + lt3);
        System.out.println();

        /*
        Task 4: Get Time Components
        Task: From a LocalTime.now(), print:
        Hour
        Minute
        Second
        Nano
        Expected Output Example:
        Hour: 14
        Minute: 45
        Second: 22
        Nano: 379000000
         */
        System.out.println("Task 4: ");
        LocalTime lt4 = LocalTime.now();
        int hour = lt4.getHour();
        int minute = lt4.getMinute();
        int second = lt4.getSecond();
        int nano = lt4.getNano();
        System.out.println("Time: " + lt4);
        System.out.println("Hour: " + hour);
        System.out.println("Minute: " + minute);
        System.out.println("Second: " + second);
        System.out.println("Nano: " + nano);
        System.out.println();

        /*
        Task 5: Add and Subtract Time
        Task: From 10:00:00:
        Add 2 hours, 15 minutes
        Subtract 30 seconds
        Expected Output Example:
        Original: 10:00:00
        After Add/Subtract: 12:14:30
         */
        System.out.println("Task 5: ");
        LocalTime lt5Original = LocalTime.of(10, 0, 0);
        LocalTime lt5Modif = lt5Original.plusHours(2).plusMinutes(15).minusSeconds(30);
        System.out.println("Original: " + lt5Original);
        System.out.println("Modified: " + lt5Modif);
        System.out.println();

        /*
        Task 6: Compare Times
        Task: Compare LocalTime.of(14, 0) and current time.
        Print if:
        First is before now
        First is after now
        First equals now
        Expected Output Example:
        14:00 is before now? true
        14:00 is after now? false
        14:00 equals now? false
         */
        System.out.println("Task 6: ");
        LocalTime lt6 = LocalTime.now();
        LocalTime lt6Comp = LocalTime.of(14, 0, 0);
        System.out.println(lt6 + " is before " + lt6Comp + " ? ... " + lt6.isBefore(lt6Comp));
        System.out.println(lt6 + " is after " + lt6Comp + " ? ... " + lt6.isAfter(lt6Comp));
        int compResult = lt6.compareTo(lt6Comp);
        boolean compResultBool = (compResult == 0);
        System.out.println(lt6 + " equals " + lt6Comp + " ? ... " + compResultBool);
        System.out.println();



    }

}
