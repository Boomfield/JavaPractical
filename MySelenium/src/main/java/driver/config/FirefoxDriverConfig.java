package driver.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverConfig extends BaseDriverConfig{
    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.gecko.driver","C:\\P\\IntelliJ IDEA Community Edition 2021.3.1\\JavaPractical\\MySelenium\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        return driver;
    }
}
