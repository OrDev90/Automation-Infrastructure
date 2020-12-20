package scenarios_utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import driver_utils.CustomBy;
import driver_utils.ExtendedWebDriver;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import reporter.ExtentReporter;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class CustomAssert {

    private final ExtendedWebDriver driverManager;
    private final ExtentReporter extentReporter;

    public CustomAssert(ExtendedWebDriver driverManager, ExtentReporter extentReporter) {
        this.driverManager = driverManager;
        this.extentReporter = extentReporter;
    }

    private void logToReport(Boolean isSuccess, String message) {
        if(isSuccess)
            pass(message);
        else
            fail(message, takeScreenshot());
    }

    private Media takeScreenshot() {
        File scp = ((TakesScreenshot) this.driverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            final byte[] bytes = FileUtils.readFileToByteArray(scp);
            String base64 = Base64.getEncoder().encodeToString(bytes);
            return MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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

    private void fail(String message, Media media) {
        this.extentReporter.log(Status.FAIL, message, media);
    }

    public void verifyUrl(String expectedUrl, String message) {
        String actualUrl = this.driverManager.getUrl();
        Boolean isSuccess = expectedUrl.contentEquals(actualUrl);
        logToReport(isSuccess, message);
    }

    public void click(WebElement element, String message) {
        Boolean isSuccess = this.driverManager.clickOnElement(new ImmutablePair<>(element, true));
        logToReport(isSuccess, message);
    }

    public void click(CustomBy givenElementAttribute, String message) {
        Boolean isSuccess = this.driverManager.clickOnElement(givenElementAttribute);
        logToReport(isSuccess, message);
    }

    public void click(CustomBy givenElementAttribute, WebElement fromElement, String message) {
        Boolean isSuccess = this.driverManager.clickOnElement(givenElementAttribute, fromElement);
        logToReport(isSuccess, message);
    }

    public void verifyString(WebElement element, String expectedString, String message) {
        String actualString = this.driverManager.getTextFromElement(new ImmutablePair<>(element, true)).getKey();
        Boolean isSuccess = expectedString.contentEquals(actualString);
        logToReport(isSuccess, message);
    }

    public void verifyString(CustomBy givenElementAttribute, String expectedString, String message) {
        String actualString = this.driverManager.getTextFromElement(givenElementAttribute).getKey();
        Boolean isSuccess = expectedString.contentEquals(actualString);
        logToReport(isSuccess, message);
    }

    public void verifyString(CustomBy givenElementAttribute, WebElement fromElement, String expectedString, String message) {
        String actualString = this.driverManager.getTextFromElement(givenElementAttribute, fromElement).getKey();
        Boolean isSuccess = expectedString.contentEquals(actualString);
        logToReport(isSuccess, message);
    }

    public void verifyElementExists(WebElement element, String message) {
        Boolean isSuccess = this.driverManager.isElementExists(new ImmutablePair<>(element, true)).getKey();
        logToReport(isSuccess, message);
    }

    public void verifyElementExists(CustomBy givenElementAttribute, String message) {
        Boolean isSuccess = this.driverManager.isElementExists(givenElementAttribute).getKey();
        logToReport(isSuccess, message);
    }

    public void verifyElementExists(CustomBy givenElementAttribute, WebElement fromElement, String message) {
        Boolean isSuccess = this.driverManager.isElementExists(givenElementAttribute, fromElement).getKey();
        logToReport(isSuccess, message);
    }

    public void sendText(WebElement element, String text, String message) {
        Boolean isSuccess = this.driverManager.sendKeysToElement(new ImmutablePair<>(element, true), text);
        logToReport(isSuccess, message);
    }

    public void sendText(CustomBy givenElementAttribute, String text, String message) {
        Boolean isSuccess = this.driverManager.sendKeysToElement(givenElementAttribute, text);
        logToReport(isSuccess, message);
    }

    public void sendText(CustomBy givenElementAttribute, WebElement fromElement, String text, String message) {
        Boolean isSuccess = this.driverManager.sendKeysToElement(givenElementAttribute, fromElement, text);
        logToReport(isSuccess, message);
    }

    public void clearText(WebElement element, String message) {
        Boolean isSuccess = this.driverManager.clearElement(new ImmutablePair<>(element, true));
        logToReport(isSuccess, message);
    }

    public void clearText(CustomBy givenElementAttribute, String message) {
        Boolean isSuccess = this.driverManager.clearElement(givenElementAttribute);
        logToReport(isSuccess, message);
    }

    public void clearText(CustomBy givenElementAttribute, WebElement fromElement, String message) {
        Boolean isSuccess = this.driverManager.clearElement(givenElementAttribute, fromElement);
        logToReport(isSuccess, message);
    }
}
