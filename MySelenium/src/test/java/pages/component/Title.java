package pages.component;

import component.Locator;
import pages.BasePage;

public class Title extends BasePage {

    public Locator headerTitle = getLocator("//div[contains(@class,'Header__experience')]");

}
