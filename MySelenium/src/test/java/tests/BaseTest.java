package tests;

import driver.Driver;
import driver.config.BaseDriverConfig;
import driver.config.ChromeBuilder;
import driver.config.DriverConfigFactory;
import helpers.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static BaseDriverConfig baseDriverBuilder = new DriverConfigFactory().getConfig(BrowserType.Chrome);

    @BeforeMethod
    public void setUp() {
        Driver.instance.set(new Driver(baseDriverBuilder));
    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().close();
    }

}
