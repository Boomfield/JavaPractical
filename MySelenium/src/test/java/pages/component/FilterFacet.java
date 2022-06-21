package pages.component;

import component.Locator;
import driver.Driver;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.helpers.ExperienceType;
import wait.Waiter;

import java.util.ArrayList;

public class FilterFacet extends BasePage {

    public Locator resultLabelBy = getLocatorByCssSelector("div.simplebar-content span");
    public Locator filterSearchBy = getLocatorByXpath(".//input[contains(@class,'SearchInput__input')]");
    public ResultItem resultItem = new ResultItem();

    public FilterFacet(By by) {
        super(by);
    }

    public FilterFacet() {
    }

    public void enterTopicSearchText(String title) {
        Driver.getDriver().enterText(filterSearchBy, title);
    }

    public ArrayList<String> getTopicSearchResults() {
        return Driver.getDriver().getResultTextList(resultLabelBy);
    }

    public void clickExperienceFilter(ExperienceType nameFilterExperience) {
        Waiter.wait(() -> Driver.getDriver().exist(resultItem.headerTitle), 10);
        Driver.getDriver().clickByText(resultLabelBy,nameFilterExperience.toString());
    }

}
