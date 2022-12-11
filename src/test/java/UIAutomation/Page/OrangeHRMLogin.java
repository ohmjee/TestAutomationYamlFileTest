package UIAutomation.Page;

import UIAutomation.CommonUtilities.ReadValueFromCucumberYmlFile;
import UIAutomation.Page.HRMS.Page.Login.LoginHRMS;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class OrangeHRMLogin {

    public static Logger logger = Logger.getLogger(String.valueOf(OrangeHRMLogin.class));
    static WebDriver driver;
    static WebDriverWait wait;
    public static void BrowserLaunch()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        logger.info("Chrome Browser Launched");
    }
    public static void LaunchURL(String URL)
    {
        driver.get(URL);
        logger.info("URL launched in the Browser");
    }
    public static void LoginScreenVerification()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement UsernameLabel=driver.findElement(By.xpath("//label[contains(.,'Username')]"));
        if(UsernameLabel.isDisplayed())
        {
            logger.info("User is on the Correct Page");
        }
        else
        {
            logger.info("User is not on Correct Page");
        }


    }
    public static void UserLogin() throws InterruptedException {
        ReadValueFromCucumberYmlFile RVFCYF=new ReadValueFromCucumberYmlFile();
        String username = RVFCYF.propFile("Username");
        String password = RVFCYF.propFile("Password");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(500);
        logger.info("User inside");
    }


     public static void BrowserClose()
    {
        logger.info("Browser Close");

    }


}
