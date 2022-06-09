package tests;

import configuration.Constants;
import data.ConstantPage;
import driver.Driver;
import driver.config.ChromeDriverConfig;
import helpers.PropertyHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.NavigatorPage;
import pages.component.CookieComponent;

import steps.NavigatorSteps;

import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;

public class AppTest {
    Driver driver = new Driver(new ChromeDriverConfig());
    String findElement = "Android";
    private NavigatorPage navigatorPage;
    private NavigatorSteps navigatorSteps;
    private CookieComponent cookieComponent;


    public AppTest() {
        cookieComponent = new CookieComponent(driver);
        navigatorPage = new NavigatorPage(driver);
        navigatorSteps = new NavigatorSteps(driver);
    }

    @Test
    public void shouldAnswerWithTrue() {
        driver.navigate(Constants.SiteProperties + ConstantPage.tutorials);
        cookieComponent.closeCookie();
        navigatorPage.enterTopicSearchText(findElement);
        navigatorSteps.VerifyAllTopicSearchResultsContains(findElement);
        driver.findElement(By.xpath("//span[.='Intermediate']")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int paginationSize = driver.findElements(By.xpath("//a[contains(@class,'PageLink__pageLink')]")).size();
        System.out.println(paginationSize);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




        ArrayList<WebElement> listHeaderExp = driver.findElements(By.xpath("//div[contains(@class,'Header__experience')]//text()"))
                .stream().collect(toCollection(ArrayList::new));

        listHeaderExp.stream().forEach(x-> System.out.println(x));

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

}

