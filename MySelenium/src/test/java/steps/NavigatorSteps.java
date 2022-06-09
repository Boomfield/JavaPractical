package steps;

import driver.Driver;
import org.testng.Assert;
import pages.NavigatorPage;


public class NavigatorSteps extends BaseSteps{
   private NavigatorPage navigatorPage = new NavigatorPage(driver);

    public NavigatorSteps(Driver driver){
        super(driver);
    }

    public void VerifyAllTopicSearchResultsContains(String text) {
        Assert.assertTrue(navigatorPage.getTopicSearchResults().stream().allMatch(x->x.toLowerCase().contains(text.toLowerCase())));
    }


}
