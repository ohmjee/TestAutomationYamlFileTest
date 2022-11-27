package UIAutomation.MainMethodforQuickTesting;

import UIAutomation.CommonUtilities.CommonBrowserSelection;
import UIAutomation.MainMethodforQuickTesting.NonMainMethod.HRMS_NonMain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class HRMSMain
{

    public static void main(String[] args) throws IOException
    {
        HRMS_NonMain HNM=new HRMS_NonMain();
        HNM.browserlaunch("Chrome");
        HNM.launchURL_Verify_LoginPage("https://opensource-demo.orangehrmlive.com/");
        HNM.enterLoginCredential("Admin","admin123");
        HNM.CaptureFirstDataRowinList();
        HNM.captureAdminMenuInArrayList();
        HNM.addUsers();

    }
}

