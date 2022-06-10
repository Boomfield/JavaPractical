package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;

public class NavigatorPage extends BasePage {

    public By topicSearchTextInput = By.xpath("//input[@name = 'topic']");
    public By topicSearchResultLabel = By.xpath("(//div[@class='simplebar-content'])[1]//span");
    public By allPageNumbers = By.xpath("//a[contains(@class,'PageLink__pageLink')]");

    public NavigatorPage(Driver driver) {
        super(driver);
    }

    public void enterTopicSearchText(String title) {
        driver.enterText(topicSearchTextInput,title);
    }

    public ArrayList<String> getTopicSearchResults() {
       return driver.getResultTextList(topicSearchResultLabel);
    }

    public void clickTopicFilter (String nameFilter) {

        driver.findElement(By.xpath("//span[.='"+nameFilter+"']")).click();
    }

    public int getPaginationSize () {
        int paginationSize = driver.findElements(allPageNumbers).size();
        return paginationSize;
    }


}
