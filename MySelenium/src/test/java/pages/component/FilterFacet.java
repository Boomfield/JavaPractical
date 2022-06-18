package pages.component;

import component.Locator;
import driver.Driver;
import org.openqa.selenium.By;
import pages.BasePage;

import java.util.ArrayList;

public class FilterFacet extends BasePage {

    public Locator resultLabelBy = getLocator(".//div[@class='simplebar-content']//span");
    public Locator filterSearchBy = getLocator(".//input[contains(@class,'SearchInput__input')]");

    public FilterFacet(By by) {
        super(by);
    }

    public FilterFacet () {}

    public void enterTopicSearchText(String title) {
        Driver.instance.get().enterText(filterSearchBy,title);
    }

    public ArrayList<String> getTopicSearchResults() {
        return Driver.instance.get().getResultTextList(resultLabelBy);
    }

}
