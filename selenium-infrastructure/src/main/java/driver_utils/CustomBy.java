package driver_utils;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

@Getter
@Setter
public class CustomBy {

    private By by;
    private String value;

    public static CustomBy cssSelector(String cssSelector) {
        CustomBy newElement = new CustomBy();
        newElement.setBy(By.cssSelector(cssSelector));
        newElement.setValue(cssSelector);
        return newElement;
    }

    public static CustomBy id(String id) {
        CustomBy newElement = new CustomBy();
        newElement.setBy(By.id(id));
        newElement.setValue(id);
        return newElement;
    }

    public static CustomBy xpath(String xpath) {
        CustomBy newElement = new CustomBy();
        newElement.setBy(By.xpath(xpath));
        newElement.setValue(xpath);
        return newElement;
    }

    public static CustomBy tagName(String tagName) {
        CustomBy newElement = new CustomBy();
        newElement.setBy(By.tagName(tagName));
        newElement.setValue(tagName);
        return newElement;
    }

    public static CustomBy name(String name) {
        CustomBy newElement = new CustomBy();
        newElement.setBy(By.name(name));
        newElement.setValue(name);
        return newElement;
    }

    public static CustomBy className(String className) {
        CustomBy newElement = new CustomBy();
        newElement.setBy(By.className(className));
        newElement.setValue(className);
        return newElement;
    }
}
