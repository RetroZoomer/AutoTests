

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class Timeout {
    Random rand = new Random();
    int[] arr = rand.ints(1000000, 100000,1000000).toArray();

    @Test
    void timeout() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            int[] sorted = Arrays.stream(arr).sorted().toArray();
            Thread.sleep(1000);
        });
    }

}
