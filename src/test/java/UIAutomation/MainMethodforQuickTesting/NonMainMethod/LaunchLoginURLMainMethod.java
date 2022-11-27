package UIAutomation.MainMethodforQuickTesting.NonMainMethod;

import UIAutomation.MainMethodforQuickTesting.BrowserLaunch_Login_WaitTesting;

import java.io.IOException;

public class LaunchLoginURLMainMethod
{
    public static void main(String[] args) throws IOException
    {
        BrowserLaunch_Login_WaitTesting BLL =new BrowserLaunch_Login_WaitTesting();
        BLL.browserlaunch("Chrome");
        BLL.launchURL_Verify_LoginPage("https://www.makemytrip.com/");
        BLL.enterLoginCredential("ohmjee@gmail.com","April@2801");
        //BLL.dashboardVerification();


    }
}
