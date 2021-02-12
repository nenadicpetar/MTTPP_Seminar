//Test za potvrdu narudžbe

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Potvrda
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
    public void ShoppingCart()
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

        WebElement shoppingCart = driver.findElement(By.linkText("Shopping cart"));
        shoppingCart.click();

        WebElement termsOfService = driver.findElement(By.id("termsofservice"));
        termsOfService.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement address = driver.findElement(By.id("billing-address-select"));
        address.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Select newAddr = new Select(driver.findElement(By.id("billing-address-select")));
        newAddr.selectByVisibleText("New Address");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        country.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Select country2 = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        country2.selectByIndex(24);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
        city.sendKeys("Osijek");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement homeAddr = driver.findElement(By.id("BillingNewAddress_Address1"));
        homeAddr.sendKeys("Kneza Trpimira 2B");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement postalCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        postalCode.sendKeys("31000");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement phoneNum = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        phoneNum.sendKeys("1234567890");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cont = driver.findElement(By.cssSelector("input.button-1.new-address-next-step-button"));
        cont.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
