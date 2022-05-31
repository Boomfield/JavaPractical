package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;

public class NavigatorPage extends BasePage {

    public By topicSearchTextInput = By.xpath("//input[@name = 'topic']");
    public By topicSearchResultLabel = By.xpath("(//div[@class='simplebar-content'])[1]//span");

    public NavigatorPage(Driver driver) {
        super(driver);
    }

    public void enterTopicSearchText(String title) {
        WebElement search = driver.findElement(topicSearchTextInput);
        search.sendKeys(title);
    }

    public ArrayList<String> getTopicSearchResults() {
        ArrayList<String> allResultElements = driver.findElements(topicSearchResultLabel).stream().map(x -> x.getText()).collect(toCollection(ArrayList::new));

        return allResultElements;
    }
}
