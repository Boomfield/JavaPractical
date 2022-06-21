package tests;

import component.Locator;
import data.PageUrls;
import driver.Driver;
import org.testng.annotations.*;
import pages.NavigationSap;
import pages.NavigatorPage;
import pages.helpers.ExperienceType;
import steps.NavigatorSteps;

public class TestTutorialPage extends BaseTest{

    private String searchFilterText = "abap";
    private NavigatorPage navigatorPage;
    private NavigatorSteps navigatorSteps;
    private NavigationSap navigationSap;

    public TestTutorialPage() {
        navigatorPage = new NavigatorPage();
        navigatorSteps = new NavigatorSteps();
        navigationSap = new NavigationSap();
    }

    @Test
    public void shouldAnswerWithTrue1() {
        navigationSap.openPageAndAcceptCookies(PageUrls.tutorials);
        navigatorPage.topicFacetSection.enterTopicSearchText(searchFilterText);
        navigatorSteps.VerifyAllTopicSearchResultsContains(searchFilterText);
    }

    @Test
    public void shouldAnswerWithTrue2() {
        navigationSap.openPageAndAcceptCookies(PageUrls.tutorials);
        navigatorPage.experienceFacetSection.clickExperienceFilter(ExperienceType.Intermediate);
        navigatorSteps.VerifyAllHeaderExpResultsContains(ExperienceType.Intermediate);
    }

}

