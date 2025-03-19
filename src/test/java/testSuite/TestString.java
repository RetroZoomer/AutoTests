package testSuite;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestString {

    @Test
    public void testString() {
        String string = "test";
        assertEquals("test", "test");
    }
}
