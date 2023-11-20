import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class SortableDataTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void sortableDataTables() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List <WebElement> johnSmith = driver.findElements(By.xpath("//table//tr[1]//td"));
        for (WebElement element: johnSmith) {
            assertEquals(johnSmith.get(0).getText(), "Smith");
            assertEquals(johnSmith.get(1).getText(), "John");
            assertEquals(johnSmith.get(2).getText(), "jsmith@gmail.com");
            assertEquals(johnSmith.get(3).getText(), "$50.00");
            assertEquals(johnSmith.get(4).getText(), "http://www.jsmith.com");
            assertEquals(johnSmith.get(5).getText(), "edit delete");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
