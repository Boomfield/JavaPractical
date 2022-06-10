package tests;

import configuration.Constants;
import data.ConstantPage;
import driver.Driver;
import driver.config.BaseDriverConfig;
import driver.config.ChromeBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.NavigationSap;
import pages.NavigatorPage;
import pages.component.CookieComponent;
import steps.NavigatorSteps;

public class AppTest {
    BaseDriverConfig baseDriverBuilder = new ChromeBuilder().withTimePageLoad(60).withTimeElementWait(40).build();
    Driver driver = new Driver(baseDriverBuilder);
    String findElement = "Android";
    private NavigatorPage navigatorPage;
    private NavigatorSteps navigatorSteps;
    private NavigationSap navigationSap;


    public AppTest() {
        navigatorPage = new NavigatorPage(driver);
        navigatorSteps = new NavigatorSteps(driver);
        navigationSap = new NavigationSap(driver);
    }

    @Test
    public void shouldAnswerWithTrue() {
        navigationSap.openPageAndAcceptCookies(Constants.SiteProperties + ConstantPage.tutorials);
//        driver.navigate(Constants.SiteProperties + ConstantPage.tutorials);
//        cookieComponent.closeCookie();
        navigatorPage.enterTopicSearchText(findElement);
        navigatorSteps.VerifyAllTopicSearchResultsContains(findElement);
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}

