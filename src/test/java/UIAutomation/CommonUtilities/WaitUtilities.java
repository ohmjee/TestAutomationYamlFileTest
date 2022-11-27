package UIAutomation.CommonUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitUtilities
{
    static WebDriver driver;
    static WebDriverWait wait;
    public static void implicitWait(int waitingTime)
    {
     driver.manage().timeouts().implicitlyWait(waitingTime,TimeUnit.SECONDS);

    }
    public static void explicitWait(By ExpectedConditionLocator, int timeout)
    {
        wait=new WebDriverWait(driver,timeout);
        WebElement elementname=wait.until(ExpectedConditions.visibilityOfElementLocated(ExpectedConditionLocator));


    }

}
