package UIAutomation.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.logging.Logger;

public abstract class CommonBrowserSelection  {
    public static WebDriverWait driverWait;
    public static final Logger logger = Logger.getLogger(String.valueOf(CommonBrowserSelection.class));
    public static WebDriver driver;
    public static ReadValueFromCucumberYmlFile readYmlValue;
    static WebDriverWait wait;
    @FindBy(xpath = "//input[@name='username']")
    static
    WebElement inputboxLoginUsername;
    @FindBy(xpath = "//input[@name='password']")
    static
    WebElement inputboxLoginPassword;
    @FindBy(xpath = "//button[@type='submit']")
    static
    WebElement btnlogin;
    @FindBy(xpath = "//h6[text()='Dashboard']")
    static
    WebElement txtVerificationDashboard;

    public static void LaunchGenericBrowser(String BrowserName) throws IOException {
        switch (BrowserName.toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions cop = new ChromeOptions();
                cop.addArguments("start-maximized");
                cop.addArguments("incognito");
                driver = new ChromeDriver(cop);
                logger.info("CHROME OPENED");

                break;

            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fop = new FirefoxOptions();
                fop.addArguments("start-maximized");
                fop.addArguments("incognito");
                logger.info("FIREFOX OPENED");
                driver = new FirefoxDriver(fop);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions cop1 = new ChromeOptions();
                cop1.addArguments("start-maximized");
                cop1.addArguments("incognito");
                driver = new ChromeDriver(cop1);
                logger.info("DEFAULT CHROME OPENED");
                break;

        }
    }
    public static void launchURL(String URL) throws InterruptedException {
        driver.get(URL);
        logger.info("URL Launched");
        Thread.sleep(10000);

            }

            /*
             public void LoginPageVerification() throws InterruptedException {
        System.out.println("Test Passed Till now");
        PageFactory.initElements(driver, this);
        Thread.sleep(10000);
        System.out.println(driver.getTitle());
       // wait.until(ExpectedConditions.elementToBeClickable(btnlogin));
    }
             */
    public void LoginPageVerification() throws InterruptedException {
        System.out.println("Test Passed Till now");
        PageFactory.initElements(driver, this);
        Thread.sleep(10000);
        System.out.println(driver.getTitle());
       // wait.until(ExpectedConditions.elementToBeClickable(btnlogin));
    }

    public void Userlogin() {
        String username = readYmlValue.propFile("Username");
        String password = readYmlValue.propFile("Password");
        PageFactory.initElements(driver, this);
        inputboxLoginUsername.sendKeys(username);
        inputboxLoginPassword.sendKeys(password);
        btnlogin.click();
        wait.until(ExpectedConditions.visibilityOf(txtVerificationDashboard));
    }
    public void BrowserClose()
    {
        driver.close();
    }

    public void DashboardLoggedInPage() {
        PageFactory.initElements(driver, this);
        if (txtVerificationDashboard.isDisplayed()) {
            logger.info("User is landed on the Dashboard");
        } else {
            logger.info("User is not landed");
        }

    }

}
