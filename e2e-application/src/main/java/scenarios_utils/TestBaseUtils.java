package scenarios_utils;

import org.openqa.selenium.WebDriver;

public abstract class TestBaseUtils {

    public static String getBaseUrl() {
        return String.format("%s", WebsiteConfiguration.BASE_URL);
    }

    public static void NavigateToBaseUrl(WebDriver webDriver) {
        webDriver.get(getBaseUrl());
    }
}
