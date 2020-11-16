package runner_utils;

import com.aventstack.extentreports.Status;
import driver_utils.CustomBy;
import driver_utils.ExtendedWebDriver;
import org.openqa.selenium.WebElement;
import reporter.ExtentReporter;

public class CustomAssert {

    private final ExtendedWebDriver driverManager;
    private final ExtentReporter extentReporter;

    public CustomAssert(ExtendedWebDriver driverManager, ExtentReporter extentReporter) {
        this.driverManager = driverManager;
        this.extentReporter = extentReporter;
    }

    private void info(String message) {
        this.extentReporter.log(Status.INFO, message);
    }

    private void pass(String message) {
        this.extentReporter.log(Status.PASS, message);
    }

    private void warning(String message) {
        this.extentReporter.log(Status.WARNING, message);
    }

    private void skip(String message) {
        this.extentReporter.log(Status.SKIP, message);
    }

    private void fail(String message) {
        this.extentReporter.log(Status.FAIL, message);
    }

    public String getText(String message, WebElement element) {
        info(message);
        return this.driverManager.getTextFromElement(element);
    }

    public String getText(String message, CustomBy givenElementAttribute) {
        info(message);
        return this.driverManager.getTextFromElement(givenElementAttribute);
    }

    public String getText(String message, CustomBy givenElementAttribute, WebElement fromElement) {
        info(message);
        return this.driverManager.getTextFromElement(givenElementAttribute, fromElement);
    }

}
