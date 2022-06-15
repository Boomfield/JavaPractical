package tests;

import driver.Driver;
import driver.config.BaseDriverConfig;
import driver.config.ChromeBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private static BaseDriverConfig baseDriverBuilder = new ChromeBuilder().withTimePageLoad(60).withTimeElementWait(40).build();

    @BeforeMethod
    public void setUp() {
        Driver.instance.set(new Driver(baseDriverBuilder));
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        Driver.instance.get().close();
    }

}
