package pages.component;

import driver.Driver;
import org.openqa.selenium.By;
import pages.BasePage;

public class CookieComponent extends BasePage {

    public By buttonCookie = By.xpath("//button[@id = 'truste-consent-required']");

    public void closeCookie () {
        Driver.instance.get().click(buttonCookie);
    }

}
