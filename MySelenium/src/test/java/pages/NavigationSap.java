package pages;

import configuration.SiteProperties;
import driver.Driver;
import pages.component.CookieComponent;

public class NavigationSap extends BasePage{

    public CookieComponent cookieComponent = new CookieComponent();

    public void openPageAndAcceptCookies (String tutorials) {
        Driver.getDriver().navigate(SiteProperties.URL + tutorials);
        cookieComponent.closeCookie();
    }

}
