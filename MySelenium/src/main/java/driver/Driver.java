package driver;

import driver.config.BaseDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Driver {

    private WebDriver driver;
    private BaseDriverConfig config;

    public WebDriver getDriver() {
        if (driver == null) {
            driver = config.creatDriver();
            driver.manage().window().maximize();
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

    public void close() {
        getDriver().close();
    }
}
