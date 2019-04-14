package agile.testing.utils;

import java.time.*;

/**
 * @author zen
 * @since 2017/06/07
 * <p>
 * https://stackoverflow.com/a/29360514
 */
public class TimeMachine {

    private static final Clock DEFAULT_CLOCK = Clock.system(ZoneOffset.ofHours(8));

    private static Clock clock = DEFAULT_CLOCK;
    private static ZoneId zoneId = ZoneId.of("Asia/Taipei");

    private TimeMachine() {
    }

    public static LocalDateTime now() {
        return LocalDateTime.now(getClock());
    }

    /**
     * WARNING!!
     * Do not use this function in product codes
     * this will fix {@link #now()} with the input `date`
     * Only permitted to use in test codes
     */
    static void useFixedClockAt(LocalDateTime date) {
        clock = Clock.fixed(date.atZone(zoneId)
                                .toInstant(), zoneId);
    }

    public static void useSystemDefaultZoneClock() {
        clock = DEFAULT_CLOCK;
    }

    private static Clock getClock() {
        return clock;
    }

}
