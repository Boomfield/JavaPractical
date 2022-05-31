package pages.component;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

public class CookieComponent extends BasePage {

    By buttonCookie = By.xpath("//button[@id = 'truste-consent-required']");

    public CookieComponent(Driver driver) {
        super(driver);
    }
    public void closeCookie () {
        WebElement buttonCloseCookie = driver.findElement(buttonCookie);
        buttonCloseCookie.click();
    }
}
