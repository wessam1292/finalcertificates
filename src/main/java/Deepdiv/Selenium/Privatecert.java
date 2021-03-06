package Deepdiv.Selenium;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Privatecert {

    public static void main(String[] args) throws InterruptedException, AWTException {

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Upload//chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to("https://enrol.pki.vodafone.com/aspx/certificate/CertificateIssuancePkcs10View.aspx");
        Thread.sleep(10000);



        // handling choose file
        String csrname = "tapaspp.vodafone.com.csr";
        String csrpath = System.getProperty("user.dir")+"\\Uploads\\"+csrname;
        driver.findElement(By.id("ctl00_ContentPlaceHolder2_AsyncFileUpload1")).click();


        // code using Robotclass for file upload
        Robot robot = new Robot();

        // To copy csrpath
        StringSelection selection = new StringSelection(csrpath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        // click on crtl + v csrpath
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);

        // ctrl + c csrname
        StringSelection selection2 = new StringSelection(csrname);
        Clipboard clipboard2 = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);

        // ctrl + v csrname
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(4000);

        WebElement ServiceDescription = driver.findElement(By.id("ctl00_ContentPlaceHolder2_CustomFieldGridView_ctl02_CustomFieldTextBox"));
        ServiceDescription.sendKeys("certificate renewal");
        WebElement LocalMarket = driver.findElement(By.id("ctl00_ContentPlaceHolder2_CustomFieldGridView_ctl03_CustomFieldTextBox"));
        LocalMarket.sendKeys("GROUP");
        WebElement RequiredContacts  = driver.findElement(By.id("ctl00_ContentPlaceHolder2_TextBoxRecipientEmail"));
        RequiredContacts.sendKeys("wessam.gamal1@vodafone.com;amr.raafat@vodafone.com;dl-tsse-enablers-gasf@vodafone.com");
        WebElement Requestbutton  = driver.findElement(By.id("ctl00_ContentPlaceHolder2_RequestButton"));
        Requestbutton.click();




    }
}
