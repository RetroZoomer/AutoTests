package docs;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Junit5Annotations {

    @BeforeAll
    static void setup() {
        System.out.println("setup here");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("   beforeEach here");
    }

    @AfterEach
    void after() {
        System.out.println("   afterEach here");
    }

    @AfterAll
    static void shutDown() {
        System.out.println("shutdown here");
    }

    @Test
    @DisplayName("Some test")
    void someTest() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Another test")
    void anotherTest() {
        assertTrue(true);
    }



}
