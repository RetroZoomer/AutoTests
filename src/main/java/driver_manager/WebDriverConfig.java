package driver_manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

public class WebDriverConfig {

    public static ChromeOptions configEdge() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption(CapabilityType.BROWSER_NAME, BrowserType.EDGE);
        options.setExperimentalOption(CapabilityType.ACCEPT_SSL_CERTS, true);

        return options;
    }
}
