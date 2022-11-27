package UIAutomation.MainMethodforQuickTesting;

import UIAutomation.CommonUtilities.CommonBrowserSelection;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BrowserLaunch_Login_WaitTesting extends CommonBrowserSelection {
    public static Logger logger = Logger.getLogger(String.valueOf(BrowserLaunch_Login_WaitTesting.class));
    //static WebDriver driver;
    static WebDriverWait wait;
    @FindBy(xpath = "//li[text()='OneWay']")
    WebElement lblMakeMytripScreen;
    @FindBy(xpath = "//p[contains(.,'Login or Create Account')]")
    WebElement btnReachLoginScreenWindow;
    @FindBy(xpath = "//label[@text()='Login with Phone/Email']")
    WebElement labelbtnLoginWithPhoneEmail;
    @FindBy(xpath = "//input[@name='username']")
    WebElement inputboxLoginUsername;
    @FindBy(xpath = "//span[@text()='Login With Password']")
    WebElement labelloginwithPassword;
    @FindBy(xpath = "//input[@name='password']")
    WebElement inputboxLoginPassword;
    @FindBy(xpath = "//span[@text='Login']")
    WebElement btnloginMakemyTrip;

    public static void browserlaunch(String BrowserName) throws IOException {
        LaunchGenericBrowser(BrowserName);
    }

    public void launchURL_Verify_LoginPage(String URL) {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Page Factory Initialization
        PageFactory.initElements(driver, this);
        if (lblMakeMytripScreen.isDisplayed()) {
            logger.info("Landed on Login Page");

        } else {
            logger.info("Still not landed");
        }
    }

    public void enterLoginCredential(String Username, String Password) {
        PageFactory.initElements(driver, this);
        wait=new WebDriverWait(driver,20);
        btnReachLoginScreenWindow.click();
        labelbtnLoginWithPhoneEmail.click();
        WebElement LoginSignupPopup=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Login with Phone/Email']")));
        inputboxLoginUsername.sendKeys(Username);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        inputboxLoginPassword.sendKeys(Password);
        btnloginMakemyTrip.click();
    }



}
