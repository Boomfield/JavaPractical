package driver;

import driver.config.BaseDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Driver {

    private WebDriver driver;
    private BaseDriverConfig config;


    public WebDriver getDriver() {
        if (driver == null) {
            driver = config.createDriver();
        }

        return driver;
    }

    public Driver (BaseDriverConfig config) {
        this.config = config;
    }

    public void navigate (String url) {
        getDriver().navigate().to(url);
    }

    public WebElement findElement (By by) {
       return getDriver().findElement(by);
    }

    public ArrayList <WebElement> findElements (By by) {
        return (ArrayList<WebElement>) getDriver().findElements(by);
    }

    public void enterText (By by,String text) {
        WebElement search = driver.findElement(by);
        search.sendKeys(text);
    }

    public void close() {
        getDriver().close();
    }

    public void closeCookie (By by) {
        WebElement buttonCloseCookie = driver.findElement(by);
        buttonCloseCookie.click();
    }
}
