package wait;


import java.time.Clock;
import java.time.ZonedDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Supplier;

public class Waiter {

    public static <T> boolean wait(Supplier<Boolean> action, int seconds) {
        final boolean[] timeOver = {false};
        final boolean[] result = new boolean[1];
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (timeOver[0] = true){
                    timer.cancel();

                        boolean resul = action.get();
                    }
                }

        };
        timer.schedule(timerTask,seconds);
        return false;
    }
}