import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

public class Parameterized {

    public boolean isPalindrome(String word) {
        StringBuilder strB = new StringBuilder(word);
        String reversed = strB.reverse().toString();

        if (word.isBlank()) {
            return false;
        } else {
            return reversed.equals(word);
        }
    }

    @ParameterizedTest(name = "{index} - {0} is a palindrome")
    @ValueSource(strings = {"12321", "poop"})
    public void testPalindromeTrue(String word) {
        assertTrue(isPalindrome(word));
    }

    @ParameterizedTest(name = "{index} - {0} isn't a palindrome")
    @ValueSource(strings = {" ", "", "fuck"})
    public void testPalindromeNegativeWay(String word) {
        assertFalse(isPalindrome(word));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "alex, 30",
            "brian, 35"
    })
    void testWithCsvSource(String name, int age) {
        assertNotNull(name);
        assertTrue(age > 0);
    }

}
