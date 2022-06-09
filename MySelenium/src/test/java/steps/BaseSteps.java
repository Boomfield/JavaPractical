package steps;

import driver.Driver;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    protected Driver driver;

    public BaseSteps (Driver driver){
        this.driver = driver;
    }
}
