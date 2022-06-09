package driver.config;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class BaseDriverConfig {
    public Duration TimePageLoad ;
    public Duration TimeElementWait ;
    WebDriver driver;

    public abstract WebDriver createDriver();

    public void waitElementAndPage (Duration TimePageLoad,Duration TimeElementWait){
        driver.manage().timeouts().pageLoadTimeout(TimePageLoad);
        driver.manage().timeouts().implicitlyWait(TimeElementWait);
    }

    public void maximizeBrowser () {
        driver.manage().window().maximize();
    }

}
