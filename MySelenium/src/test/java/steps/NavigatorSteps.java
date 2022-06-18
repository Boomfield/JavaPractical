package steps;

import driver.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.NavigatorPage;
import pages.component.FilterFacet;
import pages.component.Title;
import pages.helpers.TypeFilterTitle;
import wait.Waiter;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NavigatorSteps {

   private NavigatorPage navigatorPage = new NavigatorPage();
   public Title title = new Title();

    public void VerifyAllTopicSearchResultsContains(String text) {
        ArrayList <String> list = navigatorPage.topic.getTopicSearchResults();
        assertThat(list, everyItem(containsStringIgnoringCase(text)));
    }

    public void VerifyAllHeaderExpResultsContains (TypeFilterTitle nameFilter){
        for (int i = 0; i < navigatorPage.getPaginationSize(); i++) {
            navigatorPage.clickPageLinkNumber(i);
            boolean condition = Waiter.wait(()->Driver.instance.get().getResultTextList(title.headerTitle).stream().allMatch(x->x.equals(nameFilter.toString())),10);
            Assert.assertTrue(condition);
        }
    }

}
