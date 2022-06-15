package pages;

import configuration.Constants;
import driver.Driver;
import pages.component.CookieComponent;

public class NavigationSap extends BasePage{

    public CookieComponent cookieComponent = new CookieComponent();

    public void openPageAndAcceptCookies (String tutorials) {
        Driver.instance.get().navigate(Constants.SiteProperties + tutorials);
        cookieComponent.closeCookie();
    }

}
