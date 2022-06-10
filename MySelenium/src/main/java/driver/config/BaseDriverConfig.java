package driver.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public abstract class BaseDriverConfig {
    public Duration TimePageLoad ;
    public Duration TimeElementWait ;

    public abstract WebDriver createDriver();

    public void waitElementAndPage (WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(TimePageLoad);
        driver.manage().timeouts().implicitlyWait(TimeElementWait);
    }

}
