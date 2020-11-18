package scenarios_utils;

import com.aventstack.extentreports.Status;
import driver_utils.CustomBy;
import driver_utils.ExtendedWebDriver;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.openqa.selenium.WebElement;
import reporter.ExtentReporter;

import java.util.List;

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
            fail(message);
//            Assert.fail();
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

    public void verifyUrlInNewTab(String expectedUrl, String message) {
        this.driverManager.changeFocusToOpenedTab();
        String actualUrl = this.driverManager.getUrl();
        this.driverManager.closeLastTab();
        this.driverManager.changeFocusToSavedTab();
        Boolean isSuccess = expectedUrl.contentEquals(actualUrl);
        logToReport(isSuccess, message);
    }

    public void verifyUrl(String expectedUrl, String message) {
        String actualUrl = this.driverManager.getUrl();
        Boolean isSuccess = expectedUrl.contentEquals(actualUrl);
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

    public void verifyClassNameOfElementInPosition(CustomBy givenElementAttribute, int position, String expectedClassName, String message) {
        ImmutablePair<List<WebElement>, Boolean> elementList = this.driverManager.findWebElements(givenElementAttribute);
        String actualClassName = elementList.getKey().get(position).getAttribute("class");
        Boolean isSuccess = elementList.getValue() && expectedClassName.contentEquals(actualClassName) ||
                actualClassName.contains(expectedClassName);
        logToReport(isSuccess, message);
    }

    public void verifyClassNameOfElementInPositionByAttribute(CustomBy givenElementAttribute, String attribute, int position,
                                                              String expectedClassName, String message) {
        boolean isSuccess = false;
        ImmutablePair<List<WebElement>, Boolean> elementList = this.driverManager.findWebElements(givenElementAttribute);
        for(WebElement element: elementList.getKey()) {
            if(position == Integer.parseInt(element.getAttribute(attribute))) {
                isSuccess = element.getAttribute("class").contains(expectedClassName);
                break;
            }
        }
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

    public void runJsScript(String script, String offset, String message) {
        String actualOffset = this.driverManager.executeJsScript(script);
        Boolean isSuccess = actualOffset.contentEquals(offset);
        logToReport(isSuccess, message);
    }

    public void saveCurrentTabReference(String message) {
        this.driverManager.saveCurrentTabReference();
    }
}
