package UIAutomation.MainMethodforQuickTesting.Action;

import UIAutomation.CommonUtilities.CommonBrowserSelection;
import UIAutomation.CommonUtilities.CommonUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
public class AbstractImplementation extends CommonBrowserSelection implements ActionInterface
{
    public void launchBrowser(String browserName) throws IOException {
        LaunchGenericBrowser(browserName);


    }

    @Override
    public void selectbySendKeys(String value, WebElement ele)
    {


    }

    @Override
    public void isDisplayed(WebDriver driver, WebElement ele) {

    }

    @Override
    public void clickElement(WebDriver driver, WebElement ele) {

    }

    @Override
    public void isEnabled(WebDriver driver, WebElement ele) {

    }

    @Override
    public void getURL(String URL)
    {
        driver.get(URL);
    }
}
