package high.traffic.forum.hotarticle.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.Duration;

class TimeCalculatorUtilsTest {
    @Test
    void test() {
        Duration duration = TimeCalculatorUtils.calculateDurationToMidnight();
        System.out.println("duration.getSeconds() / 60 = " + duration.getSeconds() / 60);
    }
}