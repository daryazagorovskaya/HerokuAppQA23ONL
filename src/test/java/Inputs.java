import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Inputs {
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
    public void inputsChar () {
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys("Lera");
        String charResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(charResult, "");
    }

    @Test
    public void inputsNumbers () {
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        String numberResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(numberResult, "1");
    }

    @Test
    public void inputNegativeNumbers () {
        driver.get("https://the-internet.herokuapp.com/inputs");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        String numberResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(numberResult, "-1");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}
