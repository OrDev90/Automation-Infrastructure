package runner_utils;

import driver_utils.ExtendedWebDriver;

public abstract class TestBaseUtils {

    public static String getBaseUrl() {
        return String.format("%s", WebsiteConfiguration.BASE_URL);
    }

    public static void NavigateToBaseUrl(ExtendedWebDriver extendedWebDriver) {
        extendedWebDriver.getDriver().get(getBaseUrl());
    }
}
