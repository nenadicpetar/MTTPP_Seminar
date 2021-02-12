//Test za dodavanje u košaricu

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

public class Kosarica
{
    public WebDriver driver;
    public String testURL = "http://demowebshop.tricentis.com/";

    @BeforeMethod
    public void setupTest()
    {
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
    public void addToCart()
    {
        //Max the window (delete two slashes from bellow code to maximize the window)
        //driver.manage().window().maximize();

        WebElement login = driver.findElement(By.linkText("Log in"));
        login.click();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("neka.osoba@yahoo.com");

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("12345678");

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        password.submit();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement search = driver.findElement(By.id("small-searchterms"));
        search.sendKeys("Smartphone");
        search.submit();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement image1 = driver.findElement(By.linkText("Smartphone"));
        image1.click();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement addToCart1 = driver.findElement(By.id("add-to-cart-button-43"));
        addToCart1.click();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement computers = driver.findElement(By.linkText("Computers"));
        computers.click();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement notebooks1 = driver.findElement(By.linkText("Notebooks"));
        notebooks1.click();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement laptop1 = driver.findElement(By.linkText("14.1-inch Laptop"));
        laptop1.click();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement addToCart2 = driver.findElement(By.id("add-to-cart-button-31"));
        addToCart2.click();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement shoppingCart = driver.findElement(By.linkText("Shopping cart"));
        shoppingCart.click();

        try
        {
            Thread.sleep(3000);
        } catch (InterruptedException e)
        {

            e.printStackTrace();
        }

    }

    @AfterMethod
    public void teardownTest()
    {
        driver.quit();
    }

}
