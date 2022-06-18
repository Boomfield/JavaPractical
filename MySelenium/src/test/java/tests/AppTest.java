package tests;

import data.ConstantPage;
import driver.Driver;
import org.testng.annotations.*;
import pages.NavigationSap;
import pages.NavigatorPage;
import pages.component.FilterFacet;
import pages.helpers.TypeFilterTitle;
import steps.NavigatorSteps;

public class AppTest extends BaseTest{

    private String findElement = "abap";
    private NavigatorPage navigatorPage;
    private NavigatorSteps navigatorSteps;
    private NavigationSap navigationSap;

    public AppTest() {
        navigatorPage = new NavigatorPage();
        navigatorSteps = new NavigatorSteps();
        navigationSap = new NavigationSap();
    }

    @Test
    public void shouldAnswerWithTrue1() {
        navigationSap.openPageAndAcceptCookies(ConstantPage.tutorials);
        navigatorPage.topic.enterTopicSearchText(findElement);
        navigatorSteps.VerifyAllTopicSearchResultsContains(findElement);
    }

    @Test
    public void shouldAnswerWithTrue2() {
        navigationSap.openPageAndAcceptCookies(ConstantPage.tutorials);
        navigatorPage.clickTopicFilter(TypeFilterTitle.Intermediate);
        navigatorSteps.VerifyAllHeaderExpResultsContains(TypeFilterTitle.Intermediate);
    }

}

