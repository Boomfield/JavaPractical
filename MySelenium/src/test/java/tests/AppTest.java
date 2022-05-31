package tests;

import driver.Driver;
import driver.config.ChromeDriverConfig;
import helpers.PropertyHelper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.NavigatorPage;
import pages.component.CookieComponent;

import steps.NavigatorSteps;

public class AppTest {
    Driver driver = new Driver(new ChromeDriverConfig());
    String findElement = "Android";
    private NavigatorPage navigatorPage;
    private NavigatorSteps navigatorSteps;
    private CookieComponent cookieComponent;


    public AppTest() {
        cookieComponent = new CookieComponent(driver);
        navigatorPage = new NavigatorPage(driver);
        navigatorSteps = new NavigatorSteps(driver);
    }

    @Test
    public void shouldAnswerWithTrue() {
        driver.navigate(PropertyHelper.getProperty("url"));
        cookieComponent.closeCookie();
        navigatorPage.enterTopicSearchText(findElement);
        navigatorSteps.textEqualTopicList(findElement);

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}

