package UIAutomation.MainMethodforQuickTesting.Action;

import UIAutomation.CommonUtilities.CommonUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface
{
    String URL=null;
    //Add All User actions abstract methods to Achieve Extration
    public void selectbySendKeys(String value, WebElement ele);
    public void isDisplayed(WebDriver driver,WebElement ele);
    public void clickElement(WebDriver driver,WebElement ele);
    public void isEnabled(WebDriver driver,WebElement ele);
    public void getURL(String URL);

    /*
    //Interface must not have any method with the body
    public void getmethod()
    {

    }
     */

}
