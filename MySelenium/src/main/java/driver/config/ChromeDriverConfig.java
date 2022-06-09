package driver.config;

import helpers.PropertyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverConfig extends BaseDriverConfig {
    public String extensionPath;
    BaseDriverConfig baseDriverBuilder = new ChromeBuilder().withTimePageLoad(60).withTimeElementWait(40).build();
    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\P\\IntelliJ IDEA Community Edition 2021.3.1\\JavaPractical\\MySelenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        waitElementAndPage(baseDriverBuilder.TimePageLoad,baseDriverBuilder.TimeElementWait);
        maximizeBrowser();

        return driver;
    }

}
