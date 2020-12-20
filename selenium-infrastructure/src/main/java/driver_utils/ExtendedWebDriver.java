package driver_utils;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class ExtendedWebDriver {

    @Getter
    protected WebDriver driver;
    @Getter
    protected JavascriptExecutor js;

    protected WebDriverWait webDriverWait;
    private Actions actions;

    @Getter
    @Setter
    private CustomBy customBy;
    private String currentTab;

    protected void initExtendedDriverTools(WebDriver webDriver) {
        this.driver = webDriver;
        webDriverWait = new WebDriverWait(driver, 5);
        js = (JavascriptExecutor) driver;
    }

    public String getUrl() {
        return this.driver.getCurrentUrl();
    }

    public ImmutablePair<WebElement, Boolean> findWebElement(CustomBy givenElementAttribute) {
        try {
            WebElement elementToFind;
            customBy = givenElementAttribute;
            elementToFind = webDriverWait.until(ExpectedConditions
                    .presenceOfElementLocated(givenElementAttribute.getBy()));
            js.executeScript("arguments[0].scrollIntoView(true);", elementToFind);
            return new ImmutablePair<>(elementToFind, true);
        } catch (TimeoutException e1) {
            e1.printStackTrace();
            try {
                WebElement elementToFind = webDriverWait.until(ExpectedConditions
                        .presenceOfElementLocated(givenElementAttribute.getBy()));
                js.executeScript("arguments[0].scrollIntoView(true);", elementToFind);
                return new ImmutablePair<>(elementToFind, true);
            } catch (TimeoutException e2) {
                e2.printStackTrace();
                return new ImmutablePair<>(null, false);
            }
        }
    }

    public ImmutablePair<WebElement, Boolean> findWebElement(CustomBy givenElementAttribute, WebElement fromElement) {
        try {
            WebElement elementToFind;
            customBy = givenElementAttribute;
            elementToFind = fromElement.findElement(givenElementAttribute.getBy());
            js.executeScript("arguments[0].scrollIntoView(true);", elementToFind);
            return new ImmutablePair<>(elementToFind, true);
        } catch (TimeoutException e1) {
            e1.printStackTrace();
            try {
                WebElement elementToFind = webDriverWait.until(ExpectedConditions
                        .presenceOfNestedElementLocatedBy(fromElement, givenElementAttribute.getBy()));
                js.executeScript("arguments[0].scrollIntoView(true);", elementToFind);
                return new ImmutablePair<>(elementToFind, true);
            } catch (TimeoutException e2) {
                e2.printStackTrace();
                return new ImmutablePair<>(null, false);
            }
        }
    }

    public ImmutablePair<List<WebElement>, Boolean> findWebElements(CustomBy givenElementAttribute) {
        try {
            List<WebElement> elementsToFind;
            customBy = givenElementAttribute;
            elementsToFind = webDriverWait.until(ExpectedConditions
                    .visibilityOfAllElementsLocatedBy(givenElementAttribute.getBy()));
            js.executeScript("arguments[0].scrollIntoView(true);", elementsToFind.get(0));
            return new ImmutablePair<>(elementsToFind, true);
        } catch (TimeoutException e1) {
            e1.printStackTrace();
            try {
                List<WebElement> elementsToFind = webDriverWait.until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(givenElementAttribute.getBy()));
                js.executeScript("arguments[0].scrollIntoView(true);", elementsToFind.get(0));
                return new ImmutablePair<>(elementsToFind, true);
            } catch (TimeoutException e2) {
                e2.printStackTrace();
                return new ImmutablePair<>(null, false);
            }
        }
    }

    public ImmutablePair<List<WebElement>, Boolean> findWebElements(CustomBy givenElementAttribute, WebElement fromElement) {
        try {
            List<WebElement> elementsToFind;
            customBy = givenElementAttribute;
            elementsToFind = webDriverWait.until(ExpectedConditions
                    .visibilityOfNestedElementsLocatedBy(fromElement, givenElementAttribute.getBy()));
            js.executeScript("arguments[0].scrollIntoView(true);", elementsToFind.get(0));
            return new ImmutablePair<>(elementsToFind, true);
        } catch (TimeoutException e1) {
            e1.printStackTrace();
            try {
                List<WebElement> elementsToFind = webDriverWait.until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(givenElementAttribute.getBy()));
                js.executeScript("arguments[0].scrollIntoView(true);", elementsToFind.get(0));
                return new ImmutablePair<>(elementsToFind, true);
            } catch (TimeoutException e2) {
                e2.printStackTrace();
                return new ImmutablePair<>(null, false);
            }
        }
    }

    public ImmutablePair<String, Boolean> getTextFromElement(ImmutablePair<WebElement, Boolean> element) {
        try {
            if (element.getKey() == null && !element.getValue())
                return new ImmutablePair<>("", false);
            assert element.getKey() != null;
            return new ImmutablePair<>(element.getKey().getText(), true);
        } catch (Exception e1) {
            e1.printStackTrace();
            try {
                return new ImmutablePair<>(driver.findElement(customBy.getBy()).getText(), true);
            } catch (Exception e2) {
                e2.printStackTrace();
                return new ImmutablePair<>("", false);
            }
        }
    }

    public ImmutablePair<String, Boolean> getTextFromElement(CustomBy givenElementAttribute) {
        return getTextFromElement(findWebElement(givenElementAttribute));
    }

    public ImmutablePair<String, Boolean> getTextFromElement(CustomBy givenElementAttribute, WebElement fromElement) {
        return getTextFromElement(findWebElement(givenElementAttribute, fromElement));
    }

    public Boolean clickOnElement(ImmutablePair<WebElement, Boolean> element) {
        try {
            if (element.getKey() != null && element.getValue())
                element.getKey().click();
                return true;
        } catch (Exception e1) {
            e1.printStackTrace();
            try {
                driver.findElement(customBy.getBy()).click();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    public Boolean clickOnElement(CustomBy givenElementAttribute) {
        return clickOnElement(findWebElement(givenElementAttribute));
    }

    public Boolean clickOnElement(CustomBy givenElementAttribute, WebElement fromElement) {
        return clickOnElement(findWebElement(givenElementAttribute, fromElement));
    }

    public ImmutablePair<Boolean, Boolean> isElementExists(ImmutablePair<WebElement, Boolean> element) {
        boolean isExists = false;
        try {
            if (element.getKey() != null && element.getValue())
                isExists = element.getKey().isDisplayed();
                return new ImmutablePair<>(isExists, true);
        } catch (Exception e1) {
            e1.printStackTrace();
            return new ImmutablePair<>(isExists, false);
        }
    }

    public ImmutablePair<Boolean, Boolean> isElementExists(CustomBy givenElementAttribute) {
        return isElementExists(findWebElement(givenElementAttribute));
    }

    public ImmutablePair<Boolean, Boolean> isElementExists(CustomBy givenElementAttribute, WebElement fromElement) {
        return isElementExists(findWebElement(givenElementAttribute, fromElement));
    }

    public Boolean sendKeysToElement(ImmutablePair<WebElement, Boolean> element, String keys) {
        try {
            if(element.getKey() != null && element.getValue())
                element.getKey().sendKeys(keys);
            return true;
        } catch (Exception e1) {
            e1.printStackTrace();
            try {
                actions.sendKeys(element.getKey(), keys).perform();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
    }

    public Boolean sendKeysToElement(CustomBy givenElementAttribute, String keys) {
        return sendKeysToElement(findWebElement(givenElementAttribute), keys);
    }

    public Boolean sendKeysToElement(CustomBy givenElementAttribute, WebElement fromElement, String keys) {
        return sendKeysToElement(findWebElement(givenElementAttribute, fromElement), keys);
    }

    public Boolean clearElement(ImmutablePair<WebElement, Boolean> element) {
        try {
            if(element.getKey() != null && element.getValue())
                element.getKey().clear();
            return true;
        } catch (Exception e1) {
            e1.printStackTrace();
            return false;
        }
    }

    public Boolean clearElement(CustomBy givenElementAttribute) {
        return clearElement(findWebElement(givenElementAttribute));
    }

    public Boolean clearElement(CustomBy givenElementAttribute, WebElement fromElement) {
        return clearElement(findWebElement(givenElementAttribute, fromElement));
    }

    @SneakyThrows
    public String executeJsScript(String script) {
        return this.getJs().executeScript("return " + script).toString();
    }

    protected abstract void startService();
    protected abstract void createDriver();
    protected abstract void stopService();

    public void initDriver(String browser) {
        if(null == driver) {
            System.out.println("#### Starting "
                    + browser.substring(0, 1).toUpperCase() + browser.substring(1) + " Driver Service ####");
            startService();
            try {
                System.out.println("#### Creating "
                        + browser.substring(0, 1).toUpperCase() + browser.substring(1) + " Driver ####");
                createDriver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("#### Completed initDriver() ####");
    }

    public void quitDriver() {
        if(null != driver) {
            driver.quit();
            stopService();
            driver = null;
        }
    }

    public void changeFocusToOpenedTab() {
        this.driver.switchTo().window((String) this.getDriver().getWindowHandles()
                .toArray()[this.getDriver().getWindowHandles().size() - 1]);
    }

    public void closeLastTab() {
        this.driver.close();
    }

    public void saveCurrentTabReference() {
        this.currentTab = this.driver.getWindowHandle();
    }

    public void changeFocusToSavedTab() {
        this.driver.switchTo().window(this.currentTab);
    }
}
