package steps;

import driver.Driver;
import org.testng.Assert;
import pages.NavigatorPage;
import pages.component.ResultItem;
import pages.helpers.ExperienceType;
import wait.Waiter;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NavigatorSteps {

   private NavigatorPage navigatorPage = new NavigatorPage();
   public ResultItem resultItem = new ResultItem();

    public void VerifyAllTopicSearchResultsContains(String text) {
        ArrayList <String> list = navigatorPage.topicFacetSection.getTopicSearchResults();
        assertThat(list, everyItem(containsStringIgnoringCase(text)));
    }

    public void VerifyAllHeaderExpResultsContains (ExperienceType nameFilter){
        for (int i = 0; i < navigatorPage.getPaginationSize(); i++) {
            navigatorPage.clickPaginationLinkByNumber(i);
            ArrayList <String> allHeaderTitle = Driver.getDriver().getResultTextList(resultItem.headerTitle);
            assertThat(allHeaderTitle, everyItem(equalTo(nameFilter.toString())));
        }
    }

}
