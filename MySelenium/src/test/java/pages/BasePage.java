package pages;

import component.Locator;
import org.openqa.selenium.By;

public class BasePage {

    public By byXpath;

    public BasePage(By byXpath) {
        this.byXpath = byXpath;
    }

    public BasePage() {
    }

    public Locator getLocatorByXpath(String byXpath) {
        return new Locator(By.xpath(byXpath), this.byXpath);
    }

    public Locator getLocatorByCss(String css) {
        return new Locator(By.cssSelector(css), byXpath);
    }

}
