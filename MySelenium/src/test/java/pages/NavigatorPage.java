package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.helpers.TypeFilterTitle;
import wait.Waiter;
import java.util.ArrayList;

public class NavigatorPage extends BasePage {

    public By topicSearchTextInput = By.xpath("//input[@name = 'topic']");
    public By topicSearchResultLabel = By.xpath("(//div[@class='simplebar-content'])[1]//span");
    public By allPageNumbers = By.xpath("//a[contains(@class,'PageLink__pageLink')]");
    public By headerExp = By.xpath("//div[contains(@class,'Header__experience')]");

    public void enterTopicSearchText(String title) {
        Driver.instance.get().enterText(topicSearchTextInput,title);
    }

    public ArrayList<String> getTopicSearchResults() {
       return Driver.instance.get().getResultTextList(topicSearchResultLabel);
    }

    public void clickTopicFilter (TypeFilterTitle nameFilter) {
        Waiter.wait(()->Driver.instance.get().exist(headerExp),10);
        Driver.instance.get().findElement(By.xpath("//span[.='"+nameFilter+"']")).click();
    }

    public int getPaginationSize () {
        int paginationSize = Driver.instance.get().findElements(allPageNumbers).size();
        return paginationSize;
    }

    public void clickPageLinkNumber (int pageNumber) {
        ArrayList<WebElement> listAllNumberPageLink = Driver.instance.get().findElements(allPageNumbers);
        listAllNumberPageLink.get(pageNumber).click();
    }

}
