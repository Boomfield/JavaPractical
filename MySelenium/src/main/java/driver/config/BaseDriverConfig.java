package driver.config;

import org.openqa.selenium.WebDriver;
import java.time.Duration;

public abstract class BaseDriverConfig {

    public Duration TimePageLoad;
    public Duration TimeElementWait;

    public abstract WebDriver createDriver(String path);

    public void configureWaits(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(TimePageLoad);
        driver.manage().timeouts().implicitlyWait(TimeElementWait);
    }

}
