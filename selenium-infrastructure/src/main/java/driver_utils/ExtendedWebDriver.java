package driver_utils;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class ExtendedWebDriver {

    @Getter
    protected WebDriver driver;
    protected JavascriptExecutor js;

    protected WebDriverWait webDriverWait;
    private final int SLEEP_BEFORE_ACTION = 200;
    private final int SLEEP_AFTER_ACTION = 500;
    private Actions actions;

    @Getter
    @Setter
//    private String browserName;
    private CustomBy customBy;

    protected void initExtendedDriverTools(WebDriver webDriver) {
        this.driver = webDriver;
        webDriverWait = new WebDriverWait(driver, 2);
        js = (JavascriptExecutor) driver;
    }

    public WebElement findWebElement(CustomBy givenElementAttribute) {
        try {
            Thread.sleep(SLEEP_BEFORE_ACTION);
            customBy = givenElementAttribute;
            return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(givenElementAttribute.getBy()));
        } catch (TimeoutException | InterruptedException e1) {
            e1.printStackTrace();
            try {
                WebElement elementToFind = webDriverWait.until(ExpectedConditions
                        .presenceOfElementLocated(givenElementAttribute.getBy()));
                js.executeScript("arguments[0].scrollIntoView(true);", elementToFind);
                return elementToFind;
            } catch (TimeoutException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public WebElement findWebElement(CustomBy givenElementAttribute, WebElement fromElement) {
        try {
            Thread.sleep(SLEEP_BEFORE_ACTION);
            customBy = givenElementAttribute;
            return fromElement.findElement(givenElementAttribute.getBy());
        } catch (TimeoutException | InterruptedException e1) {
            e1.printStackTrace();
            try {
                WebElement elementToFind = webDriverWait.until(ExpectedConditions
                        .presenceOfNestedElementLocatedBy(fromElement, givenElementAttribute.getBy()));
                js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'nearest'});", elementToFind);
                return elementToFind;
            } catch (TimeoutException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public List<WebElement> findWebElements(CustomBy givenElementAttribute) {
        try {
            Thread.sleep(SLEEP_BEFORE_ACTION);
            customBy = givenElementAttribute;
            return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(givenElementAttribute.getBy()));
        } catch (TimeoutException | InterruptedException e1) {
            e1.printStackTrace();
            try {
                List<WebElement> elementsToFind = webDriverWait.until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(givenElementAttribute.getBy()));
                js.executeScript("arguments[0].scrollIntoView(true);", elementsToFind.get(0));
                return elementsToFind;
            } catch (TimeoutException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public List<WebElement> findWebElements(CustomBy givenElementAttribute, WebElement fromElement) {
        try {
            Thread.sleep(SLEEP_BEFORE_ACTION);
            customBy = givenElementAttribute;
            return webDriverWait.until(ExpectedConditions
                    .visibilityOfNestedElementsLocatedBy(fromElement, givenElementAttribute.getBy()));
        } catch (TimeoutException | InterruptedException e1) {
            e1.printStackTrace();
            try {
                List<WebElement> elementsToFind = webDriverWait.until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(givenElementAttribute.getBy()));
                js.executeScript("arguments[0].scrollIntoView(true);", elementsToFind.get(0));
                return elementsToFind;
            } catch (TimeoutException e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public String getTextFromElement(WebElement element) {
        try {
            if (element == null)
                return "";
            return element.getText();
        } catch (Exception e1) {
            e1.printStackTrace();
            try {
                return driver.findElement(customBy.getBy()).getText();
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    public String getTextFromElement(CustomBy givenElementAttribute) {
        return getTextFromElement(findWebElement(givenElementAttribute));
    }

    public String getTextFromElement(CustomBy givenElementAttribute, WebElement fromElement) {
        return getTextFromElement(findWebElement(givenElementAttribute, fromElement));
    }

    public void clickOnElement(WebElement element) {
        try {
            if (element != null)
                element.click();
                Thread.sleep(SLEEP_AFTER_ACTION);
        } catch (Exception e1) {
            e1.printStackTrace();
            try {
                if(isElementExists(customBy))
                    driver.findElement(customBy.getBy()).click();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void clickOnElement(CustomBy givenElementAttribute) {
        clickOnElement(findWebElement(givenElementAttribute));
    }

    public void clickOnElement(CustomBy givenElementAttribute, WebElement fromElement) {
        clickOnElement(findWebElement(givenElementAttribute, fromElement));
    }

    public boolean isElementExists(WebElement element) {
        try {
            return element != null && element.isDisplayed();
        } catch (Exception e1) {
            e1.printStackTrace();
            return false;
        }
    }

    public boolean isElementExists(CustomBy givenElementAttribute) {
        return isElementExists(findWebElement(givenElementAttribute));
    }

    public boolean isElementExists(CustomBy givenElementAttribute, WebElement fromElement) {
        return isElementExists(findWebElement(givenElementAttribute, fromElement));
    }

    public void sendKeysToElement(WebElement element, String keys) {
        try {
            if(element != null)
                actions.sendKeys(element, keys).perform();
        } catch (Exception e1) {
            e1.printStackTrace();
            try {
                element.sendKeys(keys);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void sendKeysToElement(CustomBy givenElementAttribute, String keys) {
        sendKeysToElement(findWebElement(givenElementAttribute), keys);
    }

    public void sendKeysToElement(CustomBy givenElementAttribute, WebElement fromElement, String keys) {
        sendKeysToElement(findWebElement(givenElementAttribute, fromElement), keys);
    }

    public void clearElement(WebElement element) {
        try {
            if(element != null)
                element.clear();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void clearElement(CustomBy givenElementAttribute) {
        clearElement(findWebElement(givenElementAttribute));
    }

    public void clearElement(CustomBy givenElementAttribute, WebElement fromElement) {
        clearElement(findWebElement(givenElementAttribute, fromElement));
    }

    public void pressEscape() {
        actions.sendKeys(Keys.ESCAPE).perform();
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
}
