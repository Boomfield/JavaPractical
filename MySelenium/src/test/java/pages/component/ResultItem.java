package pages.component;

import component.Locator;
import org.openqa.selenium.By;
import pages.BasePage;

public class ResultItem extends BasePage {
    public Locator headerTitle = getLocatorByXpath("//div[contains(@class,'Header__experience')]");
}
