package tests;

import data.ConstantPage;
import driver.Driver;
import driver.config.ChromeDriverConfig;
import helpers.PropertyHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NavigatorPage;
import pages.component.CookieComponent;
import wait.Waiter;

import javax.xml.soap.Text;
import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;

public class FilterFacetTest {
    Driver driver = new Driver(new ChromeDriverConfig());
    CookieComponent cookieComponent = new CookieComponent(driver);
    NavigatorPage navigatorPage = new NavigatorPage(driver);


    @Test
    public void shouldAnswerWithTrue() {
        driver.navigate("https://developers.sap.com/tutorial-navigator.html");
        cookieComponent.closeCookie();
        navigatorPage.clickTopicFilter("Intermediate");

        for (int i = 1; i <= navigatorPage.getPaginationSize(); i++) {
            String byXpath = "(//a[contains(@class,'PageLink__pageLink')])["+i+"]";
            WebElement buttonPageLink = driver.findElement(By.xpath(byXpath));
            buttonPageLink.click();

            ArrayList<String> listHeaderExp = driver.findElements(By.xpath("//div[contains(@class,'Header__experience')]"))
                    .stream().map(x -> x.getText()).collect(toCollection(ArrayList::new));

            Assert.assertTrue(listHeaderExp.stream().allMatch(x->x.equals("Intermediate")));
        }
    }
}
