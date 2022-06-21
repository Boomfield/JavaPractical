package pages;

import component.Locator;
import org.openqa.selenium.By;

public class BasePage {

    public By byXpath;

    public BasePage(By byXpath) {
        this.byXpath = byXpath;
    }

    public BasePage () {
    }

    public Locator getLocatorByXpath(String xPathElement) {
        return new Locator(By.xpath(xPathElement), byXpath);
    }

    public Locator getLocatorByCssSelector(String xPathElement) {
        return new Locator(By.cssSelector(xPathElement), byXpath);
    }

}
