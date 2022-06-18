package pages;

import component.Locator;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.component.FilterFacet;
import pages.component.Title;
import pages.helpers.TypeFilterTitle;
import wait.Waiter;
import java.util.ArrayList;

public class NavigatorPage extends BasePage {

    public FilterFacet topic = new FilterFacet(By.xpath("(//div[contains(@class,'FilterFacets__filterFacetsColumn')])[1]"));
    public Locator allPageNumber = getLocator( "//a[contains(@class,'PageLink__pageLink')]");
    public Title title = new Title();

    public NavigatorPage(By by) {
        super(by);
    }

    public NavigatorPage () {

    }

    public void clickTopicFilter (TypeFilterTitle nameFilter) {
        Waiter.wait(()->Driver.instance.get().exist(title.headerTitle),10);
        Driver.instance.get().findElement(getLocator(String.format("//span[.='%s']", nameFilter))).click();
    }

    public int getPaginationSize () {
        int paginationSize = Driver.instance.get().findElements(allPageNumber).size();
        return paginationSize;
    }

    public void clickPageLinkNumber (int pageNumber) {
        ArrayList<WebElement> listAllNumberPageLink = Driver.instance.get().findElements(allPageNumber);
        listAllNumberPageLink.get(pageNumber).click();
    }

}
