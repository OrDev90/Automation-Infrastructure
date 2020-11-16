package driver_utils;

import enums.DriverType;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class FirefoxDriverManager extends ExtendedWebDriver {

    private GeckoDriverService geckoDriverService;
    private final boolean isHeadless;

    public FirefoxDriverManager(boolean isHeadless) {
        this.isHeadless = isHeadless;
    }

    @Override
    public void startService() {
        if(null == geckoDriverService) {
            try {
                if (SystemUtils.IS_OS_WINDOWS) {
                    geckoDriverService = new GeckoDriverService.Builder()
                            .usingDriverExecutable(new File(System
                                    .getProperty("user.dir") + "\\..\\selenium-infrastructure\\src\\main\\java\\drivers\\geckodriver.exe"))
                            .usingAnyFreePort()
                            .build();
                }
                assert geckoDriverService != null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if(null != geckoDriverService && geckoDriverService.isRunning()) {
            geckoDriverService.stop();
        }
    }

    @Override
    public void createDriver() {
        try {
            DesiredCapabilities desiredCapabilities = DriverFactory.setDesiredCapabilitiesByBrowserName(DriverType.FIREFOX);
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(isHeadless);
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
            firefoxOptions.merge(desiredCapabilities);
            driver = new FirefoxDriver(geckoDriverService, firefoxOptions);
            initExtendedDriverTools(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
