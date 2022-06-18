package pages;

import component.Locator;
import org.openqa.selenium.By;

public class BasePage {

    public By by;

    public BasePage(By by) {
        this.by = by;
    }

    public BasePage () {

    }

    public Locator getLocator (String xPathElement) {
        return new Locator(By.xpath(xPathElement),by);
    }

}
