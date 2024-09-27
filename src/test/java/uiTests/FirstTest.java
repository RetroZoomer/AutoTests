package uiTests;

import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void checkYandexStartPage() {
        driver.get("https://yandex.com");
    }

    @Test
    public void checkGoogleStartPage() {
        driver.get("https://google.com");
    }
}
