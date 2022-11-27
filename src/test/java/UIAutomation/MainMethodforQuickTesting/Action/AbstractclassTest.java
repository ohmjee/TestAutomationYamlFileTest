package UIAutomation.MainMethodforQuickTesting.Action;

import UIAutomation.CommonUtilities.CommonUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public abstract class AbstractclassTest extends CommonUtilities implements ActionInterface
{
       public abstract void isEnabled(WebDriver driver, WebElement ele);

    public abstract void getURL(String URL);


    public static void takescreenshot(String ImageName) throws IOException {
        takescreenshot("ImageName");

    }
}
