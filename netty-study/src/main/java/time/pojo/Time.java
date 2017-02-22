package time.pojo;

import java.util.Date;

/**
 * Created by listening on 2016/10/21.
 */
public class Time {
    private final long value;

    public Time() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public Time(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Time{" +
                "value=" + new Date((getValue() - 2208988800L) * 1000L) +
                '}';
    }
}
