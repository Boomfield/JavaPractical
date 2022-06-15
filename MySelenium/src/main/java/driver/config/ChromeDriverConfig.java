package driver.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverConfig extends BaseDriverConfig {

    public String extensionPath;

    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\P\\IntelliJ IDEA Community Edition 2021.3.1\\JavaPractical\\MySelenium\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);

        waitElementAndPage(driver);
        driver.manage().window().maximize();

        return driver;
    }

}
