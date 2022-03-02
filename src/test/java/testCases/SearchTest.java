package testCases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class SearchTest {

    private static WebDriver driver;

    String nodeURL = "http://localhost:4444/wd/hub";

    @BeforeTest
    @Parameters("browser")
    void setup(String br) throws MalformedURLException
    {

        if(br.equals("chrome"))
        {
            ChromeOptions cap = new ChromeOptions();
            driver = new RemoteWebDriver(new URL(nodeURL), cap);
        }
        else if (br.equals("firefox"))
        {
            FirefoxOptions cap = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL(nodeURL), cap);
        }

        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    void searchTest()
    {
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("neder medium");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//h3[contains(text(),'neder - Medium')]")).click();

        String aboutMe = driver.getCurrentUrl();
        Assert.assertEquals(aboutMe, "https://medium.com/@_gabrielneder");
    }

    @AfterTest
    void teardown()
    {
        driver.quit();
    }
}