package gani.ms.rrs.tracing;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Utility class which stores ThreadLocal (Request) correlation Id.
 */
public class RequestCorrelation {

    public static final String CORRELATION_ID_HEADER = "correlationId";


    private static final ThreadLocal<String> id = new ThreadLocal<String>();
    private static final ThreadLocal<LocalDateTime> startTime = new ThreadLocal<LocalDateTime>();

    public static String getId() {
        return id.get();
    }

    public static void setId(String correlationId) {
        id.set(correlationId);

    }

    public static void setStartTime(LocalDateTime time){
        startTime.set(time);
    }

    public static ThreadLocal<LocalDateTime> getStartTime() {
        return startTime;
    }
}
