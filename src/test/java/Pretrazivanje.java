// Test za pretraživanje na Google-u

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Pretrazivanje {
    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "http://www.google.com";
    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
        //Create a new ChromeDriver
        driver = new ChromeDriver();

        //System.setProperty("webdriver.gecko.driver", "C:/Drivers/geckodriver.exe");
        //Create new FirefoxDriver (geckodriver.exe)
        //driver = new FirefoxDriver();

        //System.setProperty("webdriver.opera.driver", "C:/Drivers/operadriver.exe");
        //Create new OperaDriver (operadriver.exe)
        //driver = new OperaDriver();

        //Go to page from testURL
        driver.navigate().to(testURL);
    }
    @Test
    public void googleSearchTest() throws InterruptedException {
        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys("demowebshop");
        searchTextBox.submit();
        Thread.sleep(3000);
        WebElement testLink = driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[9]/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div/div[1]/a/h3/span"));
        Assert.assertEquals(testLink.getText(), "Demowebshop - Tricentis");
        System.out.print(testLink.getText());

        Thread.sleep(5000);

    }
    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}
