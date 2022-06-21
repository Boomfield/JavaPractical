package driver;

import component.Locator;
import driver.config.BaseDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;

public class Driver {

    private WebDriver driver;
    private BaseDriverConfig config;
    public static ThreadLocal<Driver> instance = new ThreadLocal<>();

    private WebDriver getStandardDriver() {
        if (driver == null) {
            driver = config.createDriver(System.getenv("CHROME_DRIVER"));
        }
        return driver;
    }

    public static Driver getDriver() {
        return Driver.instance.get();
    }

    public Driver (BaseDriverConfig config) {
        this.config = config;
    }

    public void navigate (String url) {
        getStandardDriver().navigate().to(url);
    }

    public WebElement findElement (Locator locator) {
        if(locator.parent != null) {
            return driver.findElement(locator.parent).findElement(locator.element);
        }
        return driver.findElement(locator.element);
    }

    public ArrayList <WebElement> findElements (Locator locator) {
        if(locator.parent != null) {
            return (ArrayList<WebElement>) getStandardDriver().findElement(locator.parent).findElements(locator.element);
        }
        return (ArrayList<WebElement>) getStandardDriver().findElements(locator.element);
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

    public void clickByText(Locator locator, String nameFilter) {
        ArrayList <WebElement> listFilterEqualsNameF = Driver.getDriver().findElements(locator)
                .stream().filter(x->x.getText().equals(nameFilter)).collect(toCollection(ArrayList::new));
        listFilterEqualsNameF.get(0).click();
    }

    public void clickPaginationByIndex(int pageNumber, Locator locator) {
        ArrayList<WebElement> listAllNumberPageLink = Driver.getDriver().findElements(locator);
        listAllNumberPageLink.get(pageNumber).click();
    }

    public void enterText (Locator locator, String text) {
        WebElement search = findElement(locator);
        search.sendKeys(text);
    }

    public boolean exist(Locator locator) {
        try {
            getStandardDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            return getStandardDriver().findElement(locator.element) != null;
        }
        catch (Exception ex) {
            return false;
        }
        finally {
            getStandardDriver().manage().timeouts().implicitlyWait(config.TimeElementWait);
        }
    }

    public void close() {
        getStandardDriver().close();
    }

}
