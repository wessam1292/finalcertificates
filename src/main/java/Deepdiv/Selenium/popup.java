package Deepdiv.Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;

public class popup {
    WebDriver driver;
   public String crx = System.getProperty("user.dir")+"//extension//auth.crx";

    @BeforeTest
    public void authentication () {
        
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Upload//chromedriver.exe");

            ChromeOptions op = new ChromeOptions();
            op.addExtensions(new File(crx));
             WebDriver driver = new ChromeDriver(op);
            driver.get("chrome-extension://enhldmjbphoeibbpdhmjkchohnidgnah/popin.html");
    }
    @Test
    public void start () {

        driver.findElement(By.id("url")).sendKeys("https://enrol.pki.vodafone.com/aspx/certificate/CertificateIssuancePkcs10View.aspx");
        driver.findElement(By.id("username")).sendKeys("wessam.gamal1@vodafone.com");
        driver.findElement(By.id("password")).sendKeys("Maha123456");
        driver.findElement(By.xpath("//button[.='Add']")).click();
        driver.get("https://enrol.pki.vodafone.com/aspx/certificate/CertificateIssuancePkcs10View.aspx");
    }
    }


