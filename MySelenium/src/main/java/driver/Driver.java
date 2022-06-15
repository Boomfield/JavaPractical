package driver;

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

    public WebElement findElement (By by) {
       return getDriver().findElement(by);
    }

    public ArrayList <WebElement> findElements (By by) {
        return (ArrayList<WebElement>) getDriver().findElements(by);
    }

    public ArrayList <String> getResultTextList (By by) {
       ArrayList<String> listResult = driver.findElements(by)
                .stream().map(x -> x.getText()).collect(toCollection(ArrayList::new));
       return listResult;
    }

    public void click (By by) {
        WebElement button = driver.findElement(by);
        button.click();
    }

    public void enterText (By by,String text) {
        WebElement search = driver.findElement(by);
        search.sendKeys(text);
    }

    public boolean exist(By by) {
        try {
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            return getDriver().findElement(by) != null;
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
