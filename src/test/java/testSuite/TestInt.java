package testSuite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInt {

    @Test
    public void testInt() {
        int result = 5 + 3;
        assertEquals(8, result);
    }

}
