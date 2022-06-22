package pages;

import component.Locator;
import driver.Driver;
import org.openqa.selenium.By;
import pages.component.FilterFacet;
import pages.component.FilterFacetSearch;

public class NavigatorPage extends BasePage {

    public FilterFacetSearch topicFacetSection = new FilterFacetSearch(By.xpath("(//div[contains(@class,'FilterFacets__filterFacetsColumn')])[1]"));
    public FilterFacet experienceFacetSection = new FilterFacet(By.xpath("(//div[contains(@class,'FilterFacets__filterFacetsColumn')])[3]"));
    public Locator paginationNumberLink = getLocatorByXpath("//a[contains(@class,'PageLink__pageLink')]");

    public NavigatorPage(By by) {
        super(by);
    }

    public NavigatorPage() {
    }

    public int getPaginationSize() {
        int paginationSize = Driver.getDriver().findElements(paginationNumberLink).size();
        return paginationSize;
    }

    public void clickPaginationLinkByNumber(int pageNumber) {
        Driver.getDriver().clickPaginationByIndex(pageNumber, paginationNumberLink);
    }

}
