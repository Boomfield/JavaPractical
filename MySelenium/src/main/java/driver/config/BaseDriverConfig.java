package driver.config;

import org.openqa.selenium.WebDriver;

import java.sql.Driver;
import java.time.Duration;

public abstract class BaseDriverConfig {
    public Duration TimePageLoad ;
    public Duration TimeElementWait ;

    public abstract WebDriver creatDriver ();

}
