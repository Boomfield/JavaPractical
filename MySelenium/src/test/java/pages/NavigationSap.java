package pages;

import configuration.Constants;
import data.ConstantPage;
import driver.Driver;
import pages.component.CookieComponent;

public class NavigationSap extends BasePage{
    public CookieComponent cookieComponent = new CookieComponent(driver);

    public NavigationSap(Driver driver) {
        super(driver);
    }

    public void openPageAndAcceptCookies (String url) {
        driver.navigate(url);
        cookieComponent.closeCookie();
    }

}
