package agile.testing.utils;

import java.time.LocalDateTime;

public class TimeMachineUtils {
    public static void useFixedClockAt(LocalDateTime date) {
        TimeMachine.useFixedClockAt(date);
    }
}
