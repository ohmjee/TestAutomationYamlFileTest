package UIAutomation.Page;

import UIAutomation.ObjectRepository.FlightSearchPageRepo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FlightSearchPage extends FlightSearchPageRepo
{
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    @FindBy(xpath = "//li[contains(.,'ABOUT IXIGO')]")
    WebElement CorrectLandingPage;

    @FindBy(xpath = "//div[@class='u-ib swap-icon ixi-icon-swap u-v-align-middle']//preceding::input[@class='c-input u-v-align-middle']")
    WebElement txtfromdestination;

    @FindBy(xpath = "//div[@class='u-ib swap-icon ixi-icon-swap u-v-align-middle']//following::div[3]/input[@class='c-input u-v-align-middle']")
    WebElement txtTodestination;

    @FindBy(xpath = "//button[@class='c-btn u-link enabled' and contains(.,'Search')]")
    WebElement btnSearchbutton;

    @FindBy(xpath = "//div[@class='city u-text-ellipsis' and @title='Patna']//preceding::a[contains(.,'EDIT FARE ALERT')]")
    WebElement correctDestinationPage;

    public void launchbrowser(String BrowserName) throws MalformedURLException {
        switch (BrowserName.toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
               options.addArguments("start-maximized");
                driver = new ChromeDriver(options);

                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "SAFARI":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }

    }
    public void launchURL(String url)
    {
     driver.get(url);
    }

    public  void waitforpagetoload()
    {
     PageFactory.initElements(driver,this);
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     if(CorrectLandingPage.isDisplayed())
     {
         System.out.println("Landed on Correct Page");

          }
     else
     {
         System.out.println("Landed on Wrong Page");
     }
    }
    public void practiceaction() throws InterruptedException {
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
        Thread.sleep(500);
        txtfromdestination.click();
        txtfromdestination.sendKeys(Keys.DELETE);
        Thread.sleep(200);
        txtfromdestination.sendKeys("Bangalore");
        Thread.sleep(200);
        actions.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(200);
        actions.sendKeys(Keys.ARROW_UP);
        actions.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        txtTodestination.clear();
        txtTodestination.sendKeys("PATNA");
        Thread.sleep(200);
        actions.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        actions.moveToElement(btnSearchbutton).click().build().perform();
        actions.sendKeys(Keys.getKeyFromUnicode('A'));
        Thread.sleep(2000);
        driver.quit();

    }

}
