package driver.config;

import helpers.PropertyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverConfig extends BaseDriverConfig {
    public String extensionPath;
    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\P\\IntelliJ IDEA Community Edition 2021.3.1\\JavaPractical\\MySelenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        waitElementAndPage(driver);
        driver.manage().window().maximize();

        return driver;
    }

}
