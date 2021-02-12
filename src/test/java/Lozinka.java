// Test za izmjenu lozinke

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lozinka {
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
    public void Password()
    {
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

        WebElement profil = driver.findElement(By.cssSelector("a.account"));
        profil.click();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement password2 = driver.findElement(By.linkText("Change password"));
        password2.click();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement oldPsw = driver.findElement(By.id("OldPassword"));
        oldPsw.sendKeys("12345678");

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement newPsw = driver.findElement(By.id("NewPassword"));
        newPsw.sendKeys("87654321");

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement cnfPsw = driver.findElement(By.id("ConfirmNewPassword"));
        cnfPsw.sendKeys("87654321");

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement confNewPsw = driver.findElement(By.cssSelector("input.button-1.change-password-button"));
        confNewPsw.click();

        try
        {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterMethod
    public void teardownTest()
    {
        driver.quit();
    }
}
