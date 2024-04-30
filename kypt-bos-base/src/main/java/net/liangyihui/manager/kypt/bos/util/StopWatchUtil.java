package net.liangyihui.manager.kypt.bos.util;

import org.springframework.util.StopWatch;

/**
 * @author liu_y
 */
public class StopWatchUtil {

    private static final ThreadLocal<StopWatch> THREAD_LOCAL = ThreadLocal.withInitial(StopWatch::new);


    public static void start(String name) {
        StopWatch stopWatch = THREAD_LOCAL.get();
        if (stopWatch.isRunning()) {
            stopWatch.stop();
        }
        stopWatch.start(name);
    }

    public static void stop() {
        StopWatch stopWatch = THREAD_LOCAL.get();
        if (stopWatch.isRunning()) {
            stopWatch.stop();
        }
    }

    public static String report() {
        StopWatch stopWatch = THREAD_LOCAL.get();
        if (stopWatch.isRunning()) {
            stopWatch.stop();
        }
        THREAD_LOCAL.remove();
        return stopWatch.prettyPrint();
    }

}
