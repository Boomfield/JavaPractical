package pages.component;

import component.Locator;
import driver.Driver;
import pages.BasePage;

public class CookieComponent extends BasePage {

    public Locator cookie = getLocatorByXpath("//button[@id = 'truste-consent-required']");

    public void closeCookie() {
        Driver.getDriver().click(cookie);
    }

}
