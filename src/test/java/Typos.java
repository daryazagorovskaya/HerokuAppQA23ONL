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

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Typos {

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
    public void typos() {
        driver.get("https://the-internet.herokuapp.com/typos");
        WebElement typos = driver.findElement(By.tagName("p"));
        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]"));
        String text1 = text.getText();
        driver.navigate().refresh();
        Assert.assertEquals(text1, "Sometimes you'll see a typo, other times you won't.");
    }

    @Test
    public void typos2() {
        driver.get("https://the-internet.herokuapp.com/typos");
        WebElement typos = driver.findElement(By.tagName("p"));
        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]"));
        String text1 = text.getText();
        driver.navigate().refresh();
        Assert.assertEquals(text1, "Sometimes you'll see a typo, other times you won,t.");
    }

    @Test
    public void typos3() {
        driver.get("https://the-internet.herokuapp.com/typos");
        WebElement typos = driver.findElement(By.tagName("p"));
        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]"));
        String text1 = text.getText();
        for (int i = 0; i < 5; i++) {
            driver.navigate().refresh();
        }
        Assert.assertEquals(text1, "Sometimes you'll see a typo, other times you won,t.");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }
}


