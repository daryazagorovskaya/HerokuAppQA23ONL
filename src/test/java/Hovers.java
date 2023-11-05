import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Hovers {

    WebDriver driver;
    Actions action;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void hovers() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement hovers = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        Actions action = new Actions(driver);
        action.moveToElement(hovers).build().perform();
        WebElement user1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(user1.isDisplayed(), "");
        WebElement hoversLink = driver.findElement(By.linkText("View profile"));
        hoversLink.click();
        WebElement no404error = driver.findElement(By.xpath("//h1[contains(text(),'404')]"));
        Assert.assertFalse(no404error.isDisplayed());
        // других идей как првоерить через ui нет :)
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}



