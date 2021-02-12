# MTTPP_Seminar

Popis alata za izvođenje vježbe:
  - Development Kit: JAVA JDK (https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
  - IDE: IntelliJ (https://www.jetbrains.com/idea/download/#section=windows)
  - upravljački program:
        - za Google Chrome: ChromeDriver (https://chromedriver.chromium.org/downloads)
        - za Mozilla Firefox: GeckoDriver (https://github.com/mozilla/geckodriver/releases)
        - za Operu: OperaDriver (https://github.com/operasoftware/operachromiumdriver/releases)

Redoslijed instalacije:
    - Internet preglednik (Chrome, Firefox, Opera)
    - Java JDK
    - IntelliJ
    - upravljački program za preglednik (ChromeDriver, GeckoDriver, OperaDriver)
    
Postavke za upravljačke programe:
  - preuzeti neki od upravljačkih programa s interneta i spremiti ga u mapu C:\drivers\, ili u drugu po želji.
  - zatim dodati putanju mape u sistemsku varijablu putanje okoliša (Start -> Edit the system environment variables -> Environment Variables... -> User Variables for (ime korisnika) -> Path -> Edit... -> New), upisati C:\drivers\ ili putanju mape u kojoj se nalazi upravljački program.
  -ponovno pokrenuti program
  
NAPOMENA: Verziju upravljačkih programa odabrati u skladu s verzijom preglednika na računalu.

Zadatak
  1. Nakon uspješnog postavljanja razvojnog okruženja, prateći upute u nastavku, potrebno je napisati test koji će automatski izvršiti sljedeći scenarij:
      a) Otvoriti http://www.google.com u web pregledniku
      b) Potražiti polje za unos teksta i unijeti proizvoljan pojam (npr. demowebshop)
      c) Pokrenuti traženje unesenog pojma
      d) Pričekati da se učita stranica s rezultatima
      e) Provjeriti je li prvi link poveznica na Demowebshop - Tricentis
      
   2. Provjeriti izvješće koje se automatski stvorilo na sljedećoj lokaciji:
          <project_folder>/target/surefire-reports/index.html
          
          
          
Izvođenje vježbe:

   Otvoriti IntelliJ i stvoriti novi projekt klikom na File -> New->Project...
   Odabrati Maven vrstu projekta i kliknuti Dalje (Next)
   Ispuniti GroupId i ArtifactId, upisati po vlastitoj želji i kliknuti Dalje (Next).
   Proizvoljno upisati naziv projekta (Project name), odabrati mapu u koju će se projekt spremiti (Project location) i kliknuti Završi (Finish).
   Kada se projekt učita i otvori se IntelliJ alat, kliknuti na "Enable Auto-Import" (ova opcija automatski uvozi Maven ovisnosti u svoj projekt)
   Sada treba dodati Maven ovisnosti kao što su biblioteke Selenium i TestNG. Da bi se dobile te ovisnosti, treba otići na poveznice i provjeriti trenutne verzije:
   https://mvnrepository.com/artifact/org.testng/testng
   https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    
   Osim toga, ako treba automatski generirati izvješća o izvršenim testovima, treba dodati odjeljak "build" te koristiti plugin maven-surefire-plugin.
    
//POM.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>org.example</groupId>
    <artifactId>MTTPP_Projekt</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.12.0</version>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>6.14.3</version>
        </dependency>
        <dependency>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-report-plugin</artifactId>
            <version>3.0.0-M5</version>
        </dependency>
        <dependency>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.1</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M1</version>
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>testng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

   
   
Zatim je potrebno stvoriti testnu klasu. Da bi se stvorila testna klasa, desnom tipkom miša kliknuti na "java" mapu ispod mape "test" i odabrati New -> Java Class.
Naziv testne klase također može biti proizvoljan. (Primjer: Pretrazivanje.java)



    // Pretrazivanje.java      
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


Sada treba izgraditi projekt (Build -> Build Project). Zatim, ako se koristi IntelliJ, desnom tipkom miša kliknuti na testnu klasu i kliknuti na opciju "Create 'naziv testa'...

Nakon što se klikne na gumb "OK", u gornjem desnom kutu IntelliJ-a će biti ikonica "Run", kliknuti na nju i test će početi.

Ako se želi upotrijebiti ručno konfigurirana datoteka testng.xml, treba stvoriti datoteku testng.xml unutar projektne mape i izmijeniti je kako slijedi:

    // testng.xml
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
    <suite name="AllTestsSuite">
        <test name="Google Search">
            <classes>
                <class name="Pretrazivanje"/>
            </classes>
        </test>
    <suite>
  
  
Nakon toga, desnom tipkom miša kliknuti datoteku testng.xml i pokrenuti testove pritiskom na opciju "Run"...
Sada kada postoji testng.xml datoteka unutar projekta, testovi se mogu pokrenuti i iz komandne linije (Command Prompt) sa sljedećom naredbom:

>mvn test

NAPOMENA: naredbu izvršiti unutar projektne mape

Ako je korišten maven-surefire-plugin (provjeriti build odjeljak u datoteci POM.xml), tijekom izvršavanja testova trebala bi se stvoriti izvješća o izvršenim testovima na sljedećoj lokaciji:
    .../<project_folder>/target/surefire-reports/index.html
