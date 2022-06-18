package driver;

import component.Locator;
import driver.config.BaseDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;

public class Driver {

    private WebDriver driver;
    private BaseDriverConfig config;
    public static ThreadLocal<Driver> instance = new ThreadLocal<>();

    public WebDriver getDriver() {
        if (driver == null) {
            driver = config.createDriver();
        }
        return driver;
    }

    public Driver (BaseDriverConfig config) {
        this.config = config;
    }

    public void navigate (String url) {
        getDriver().navigate().to(url);
    }

    public WebElement findElement (Locator locator) {
        if(locator.parent != null) {
            return driver.findElement(locator.parent).findElement(locator.element);
        }
        return driver.findElement(locator.element);
    }

    public ArrayList <WebElement> findElements (Locator locator) {
        if(locator.parent != null) {
            return (ArrayList<WebElement>) getDriver().findElement(locator.parent).findElements(locator.element);
        }
        return (ArrayList<WebElement>) getDriver().findElements(locator.element);
    }


    public ArrayList <String> getResultTextList (Locator locator) {
       ArrayList<String> listResult = findElements(locator)
                .stream().map(x -> x.getText()).collect(toCollection(ArrayList::new));
       return listResult;
    }

    public void click (Locator locator) {
        WebElement button = findElement(locator);
        button.click();
    }

    public void enterText (Locator locator,String text) {
        WebElement search = findElement(locator);
        search.sendKeys(text);
    }

    public boolean exist(Locator locator) {
        try {
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            return getDriver().findElement(locator.element) != null;
        }
        catch (Exception ex) {
            return false;
        }
        finally {
            getDriver().manage().timeouts().implicitlyWait(config.TimeElementWait);
        }
    }

    public void close() {
        getDriver().close();
    }

}
