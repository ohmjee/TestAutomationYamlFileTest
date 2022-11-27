package UIAutomation.CommonUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.logging.Logger;

public class CommonBrowserSelection  {
    public static WebDriver driver;
    public static final Logger logger = Logger.getLogger(String.valueOf(CommonBrowserSelection.class));

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

    public static void launchURL(String URL) {
        driver.get(URL);
    }

    public static void browserQuit() {
        driver.quit();
    }

}
