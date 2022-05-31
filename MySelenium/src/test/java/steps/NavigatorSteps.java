package steps;

import driver.Driver;
import org.testng.Assert;
import pages.NavigatorPage;


public class NavigatorSteps extends BaseSteps{
    NavigatorPage navigatorPage = new NavigatorPage(driver);

    public NavigatorSteps(Driver driver){
        super(driver);
    }

    public void textEqualTopicList (String findElement) {
        Assert.assertTrue(navigatorPage.getTopicSearchResults().stream().allMatch(x->x.toLowerCase().contains(findElement.toLowerCase())));
    }
}
