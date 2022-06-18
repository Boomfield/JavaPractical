import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class Main{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\P\\IntelliJ IDEA Community Edition 2021.3.1\\JavaPractical\\MySelenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
        // identify element
        WebElement c=driver.findElement(By.xpath("//li[@class='heading']"));
        //identify parent element with ./.. expression in xpath
        WebElement p = c.findElement(By.xpath("./.."));
        //getTagName to get tagname of parent
        System.out.println("Parent tagname is: " + p.getText());
        driver.close();
    }
}
