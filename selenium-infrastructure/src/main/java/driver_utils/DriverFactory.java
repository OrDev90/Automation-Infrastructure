package driver_utils;

import enums.DriverType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {

    public static ExtendedWebDriver getDriverManager(String browser, boolean isHeadless) {
        ExtendedWebDriver driver;
        if(browser.contentEquals("chrome")) {
            driver = setChromeLocalDriver(isHeadless);
        } else {
            driver = setFirefoxLocalDriver(isHeadless);
        }
        return driver;
    }

    private static ExtendedWebDriver setChromeLocalDriver(boolean isHeadless) {
        return new ChromeDriverManager(isHeadless);
    }

    private static ExtendedWebDriver setFirefoxLocalDriver(boolean isHeadless) {
        return new FirefoxDriverManager(isHeadless);
    }

    public static DesiredCapabilities setDesiredCapabilitiesByBrowserName(DriverType browser) {
        switch (browser) {
            case CHROME -> {
                return DesiredCapabilities.chrome();
            }
            case FIREFOX -> {
                return DesiredCapabilities.firefox();
            }
            default -> {
                return null;
            }
        }
    }
}
