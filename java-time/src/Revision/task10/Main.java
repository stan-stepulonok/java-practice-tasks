package Revision.task10;

/*
Task 10: Flight Duration
From: 2025-04-30 10:00 (Europe/London)
To: 2025-04-30 13:30 (Asia/Dubai)
Output:
Flight duration: 6 hours 30 minutes
 */

import java.time.*;

public class Main {

    public static void main(String[] args) {

        ZoneId zoneLondon = ZoneId.of("Europe/London");
        LocalDate ldLond = LocalDate.of(2025, 4, 30);
        LocalTime ltLond = LocalTime.of(10, 0, 0);
        ZonedDateTime zdtFrom = ZonedDateTime.of(ldLond, ltLond, zoneLondon);
        Instant instLond = zdtFrom.toInstant();
        System.out.println(instLond);

        ZoneId zoneDubai = ZoneId.of("Asia/Dubai");
        LocalDate ldDub = LocalDate.of(2025, 4, 30);
        LocalTime ltDub = LocalTime.of(13, 30, 0);
        ZonedDateTime zdtTo = ZonedDateTime.of(ldDub, ltDub, zoneDubai);
        Instant instDub = zdtTo.toInstant();
        System.out.println(instDub);

        Duration durFlight = Duration.between(instLond, instDub);
        long minutes = (durFlight.getSeconds() % 3600) / 60;
        long hours = durFlight.getSeconds() / 3600;
        System.out.println("Flight duration: " + hours + " hours " + minutes + " minutes.");

    }

}
