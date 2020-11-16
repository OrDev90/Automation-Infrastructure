package driver_utils;

import enums.DriverType;
import lombok.Getter;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Collections;
import java.util.logging.Level;

@Getter
public class ChromeDriverManager extends ExtendedWebDriver {

    private ChromeDriverService chromeDriverService;
    private final boolean isHeadless;

    public ChromeDriverManager(boolean isHeadless) {
        this.isHeadless = isHeadless;
    }

    @Override
    public void startService() {
        if(null == chromeDriverService) {
            try {
                if (SystemUtils.IS_OS_WINDOWS) {
                    chromeDriverService = new ChromeDriverService.Builder()
                            .usingDriverExecutable(new File(System
                                    .getProperty("user.dir") + "\\..\\selenium-infrastructure\\src\\main\\java\\drivers\\chromedriver.exe"))
                            .usingAnyFreePort()
                            .build();
                }
                assert chromeDriverService != null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if(null != chromeDriverService && chromeDriverService.isRunning()) {
            chromeDriverService.stop();
        }
    }

    @Override
    public void createDriver() {
        try {
            DesiredCapabilities desiredCapabilities = DriverFactory.setDesiredCapabilitiesByBrowserName(DriverType.CHROME);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            LoggingPreferences loggingPreferences = new LoggingPreferences();
            loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
            loggingPreferences.enable(LogType.BROWSER, Level.ALL);
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.setCapability("goog:loggingPrefs", loggingPreferences);
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.merge(desiredCapabilities);
            chromeOptions.setHeadless(isHeadless);
            chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            driver = new ChromeDriver(chromeDriverService, chromeOptions);
            initExtendedDriverTools(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
