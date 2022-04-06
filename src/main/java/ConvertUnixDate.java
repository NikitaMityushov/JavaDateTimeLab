import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ConvertUnixDate {
    // 11/14/2019 @ 10:00pm (UTC)
    public static final long UNIX_TIMESTAMP = 1573768800;
    public static final String ZONE_ID_MINSK = "Europe/Minsk";


    // Unix timestamp is seconds, Date pass millis, that's why you should multiply 1000
    public final void oldConvertToDate() {
        System.out.println("Before Java8:");
        // Before Java8
        Date date1 = new Date(UNIX_TIMESTAMP * 1000L);
        System.out.println("Date1: " + date1);  // output: Date: Fri Nov 15 01:00:00 MSK 2019
        Date date2 = new Date(TimeUnit.MILLISECONDS.convert(UNIX_TIMESTAMP, TimeUnit.SECONDS));
        System.out.println("Date2: " + date2);  // output: Date: Fri Nov 15 01:00:00 MSK 2019

        System.out.println("revers converting: date1 in long " + date1.getTime());
    }

    public final void newConvertToDate() {
        System.out.println("After Java8:");
        // Since Java8
        Instant instant = Instant.ofEpochSecond(UNIX_TIMESTAMP);
        // 1) Date
        Date date = Date.from(instant);
        System.out.println("Date: " + date); // output: Date: Fri Nov 15 01:00:00 MSK 2019
        // 2) LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of(ZONE_ID_MINSK));
        System.out.println("LocalDateTime: " + localDateTime);
        // 3) ZoneDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of(ZONE_ID_MINSK));
        System.out.println("ZonedDateTime: " + zonedDateTime);
    }

}
