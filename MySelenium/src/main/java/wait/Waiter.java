package wait;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class Waiter {

    public static <T> boolean wait(Supplier<Boolean> action, int seconds) {
            LocalDateTime endDate = LocalDateTime.now().plusSeconds(seconds);

            while (LocalDateTime.now().isBefore(endDate)) {
                try {
                    boolean result = action.get();

                    if (result) {
                        return true;
                    }
                }
                finally {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }

            return false;
        }
}