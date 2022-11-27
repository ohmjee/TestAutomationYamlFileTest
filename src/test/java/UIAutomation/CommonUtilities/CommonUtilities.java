package UIAutomation.CommonUtilities;


import UIAutomation.Page.BrowserSelection;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class CommonUtilities  {
static WebDriver driver;
    public static Logger logger=Logger.getLogger(String.valueOf(CommonUtilities.class));
    public static void takescreenshot( String filename) throws IOException {
        //1.Take the Screenshot and Save in the file format
        File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        logger.info("Reached File"+filename);
        //2.Copy the Screenshot to the desired location using copy file method
        FileUtils.copyFile(file,new File("C:/Personal/Learning/SeleniumCucumberFramework/src/test/resources/Screenshots"+filename+".png"));
    }

}

