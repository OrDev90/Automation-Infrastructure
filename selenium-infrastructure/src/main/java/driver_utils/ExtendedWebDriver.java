package driver_utils;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class ExtendedWebDriver {

    @Getter
    protected WebDriver driver;

    protected WebDriverWait webDriverWait;
    private final int SLEEP_BEFORE_ACTION = 200;
    protected JavascriptExecutor js;

    @Getter
    @Setter
    private String driverInformation;
    private CustomBy customBy;

    public void initExtendedDriverTools(WebDriver webDriver) {
        this.driver = webDriver;
        webDriverWait = new WebDriverWait(driver, 2);
        js = (JavascriptExecutor) driver;
    }

    public String getBrowserName() {
        return getDriverInformation().split("&")[0];
    }

    public WebElement findWebElement(CustomBy givenElementAttribute) {
        try {
            Thread.sleep(SLEEP_BEFORE_ACTION);
            customBy = givenElementAttribute;
            return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(givenElementAttribute.getBy()));
        } catch (TimeoutException | InterruptedException e1) {
            try {
                WebElement elementToFind = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(givenElementAttribute.getBy()));
                js.executeScript("arguments[0].scrollIntoView(true);", elementToFind);
                return elementToFind;
            } catch (TimeoutException e2) {
                return null;
            }
        } catch (UnhandledAlertException e) {
            return null;
        }
    }

    protected abstract void startService();
    protected abstract void createDriver();
    protected abstract void stopService();

    public WebDriver initDriver() {
        if(null == driver) {
            System.out.println("#### Starting "
                    + getBrowserName().substring(0, 1).toUpperCase() + getBrowserName().substring(1) + " Driver Service ####");
            startService();
            try {
                System.out.println("#### Creating "
                        + getBrowserName().substring(0, 1).toUpperCase() + getBrowserName().substring(1) + " Driver ####");
                createDriver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("#### Completed initDriver() ####");
        return driver;
    }

    public void quitDriver() {
        if(null != driver) {
            driver.quit();
            stopService();
            driver = null;
        }
    }
}
