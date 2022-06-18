package pages.component;

import component.Locator;
import driver.Driver;
import org.openqa.selenium.By;
import pages.BasePage;

public class CookieComponent extends BasePage {

    public String buttonCookie = "//button[@id = 'truste-consent-required']";
    public Locator cookie = getLocator(buttonCookie);

    public void closeCookie () {
        Driver.instance.get().click(cookie);
    }

}
