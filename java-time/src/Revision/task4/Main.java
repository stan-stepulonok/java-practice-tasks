package Revision.task4;

/*
Task 4: Time Zone Conversion
Local: Europe/Warsaw
Target: Asia/Tokyo
Output:
Current time in Warsaw: 2025-04-29T14:30+02:00
Current time in Tokyo: 2025-04-29T21:30+09:00
 */

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("Create from scratch Warsaw: ");
        ZoneId zoneWarsaw = ZoneId.of("Europe/Warsaw");
        ZonedDateTime zdtWarsaw = ZonedDateTime.now(zoneWarsaw).truncatedTo(ChronoUnit.SECONDS);
        System.out.println("Current time in Warsaw: " + zdtWarsaw);
        System.out.println();

        System.out.println("Create from scratch Tokyo: ");
        ZoneId zoneTokyo = ZoneId.of("Asia/Tokyo");
        ZonedDateTime zdtTokyo = ZonedDateTime.now(zoneTokyo).truncatedTo(ChronoUnit.SECONDS);
        System.out.println("Current time in Tokyo: " + zdtTokyo);
        System.out.println();

        System.out.println("Conversion Warsaw -> Tokyo: ");
        ZonedDateTime zdtWarsawToTokyo = zdtWarsaw.withZoneSameInstant(zoneTokyo).truncatedTo(ChronoUnit.SECONDS);
        System.out.println("Converted: " + zdtWarsawToTokyo);
        System.out.println();

    }

}


