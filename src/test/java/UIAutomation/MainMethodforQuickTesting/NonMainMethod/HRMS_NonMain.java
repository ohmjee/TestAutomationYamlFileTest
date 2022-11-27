package UIAutomation.MainMethodforQuickTesting.NonMainMethod;

import UIAutomation.CommonUtilities.CommonBrowserSelection;
import UIAutomation.CommonUtilities.CommonUtilities;
import UIAutomation.CommonUtilities.ExcelPOIReadWriteUtility;
import UIAutomation.MainMethodforQuickTesting.Action.ActionInterface;
import UIAutomation.MainMethodforQuickTesting.HRMSMain;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class HRMS_NonMain extends CommonBrowserSelection {

    public static Logger logger = Logger.getLogger(String.valueOf(HRMSMain.class));
    static WebDriverWait wait;
    @FindBy(xpath = "//div[@id='logInPanelHeading']")
    WebElement lblLoginScreen;
    @FindBy(xpath = "//input[@name='txtUsername']")
    WebElement inputboxLoginUsername;
    @FindBy(xpath = "//input[@name='txtPassword']")
    WebElement inputboxLoginPassword;
    @FindBy(xpath = "//input[@name='Submit']")
    WebElement btnlogin;
    @FindBy(xpath = "//h1[text()='Dashboard']")
    WebElement txtVerificationDashboard;
    @FindBy(xpath = "//a[@href='/index.php/admin/viewAdminModule']")
    WebElement locateUserAdmin;
    @FindBy(xpath = "//ul[@id='mainMenuFirstLevelUnorderedList']/child::li/a/b")
    WebElement FirstDataRow;
    @FindBy(xpath = "//input[@id='btnAdd']")
    WebElement addUserBtn;
    @FindBy(xpath = "//h1[contains(.,'Add User')]")
    WebElement AddUserScreenVerification;


    public static void browserlaunch(String BrowserName) throws IOException {
        LaunchGenericBrowser(BrowserName);
    }

    public void launchURL_Verify_LoginPage(String URL) {
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Page Factory Initialization
        PageFactory.initElements(driver, this);
        if (lblLoginScreen.isDisplayed()) {
            logger.info("Landed on Login Page");

        } else {
            logger.info("Still not landed");
        }
    }

    public void enterLoginCredential(String Username, String Password) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
        inputboxLoginUsername.sendKeys(Username);
        inputboxLoginPassword.sendKeys(Password);
        btnlogin.click();
        WebElement LoginSignupPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Dashboard']")));
    }

    public void CaptureFirstDataRowinList() {
        // ArrayList<WebElement> al=new ArrayList<WebElement>();
        List<WebElement> al = driver.findElements(By.xpath("//ul[@id='mainMenuFirstLevelUnorderedList']/child::li/a/b"));
        Iterator<WebElement> itr = al.iterator();
        String value = "";
        while (itr.hasNext()) {
            WebElement element = itr.next();
            value = element.getText();
            System.out.println(value);
        }
    }

    public void captureAdminMenuInArrayList() {
        PageFactory.initElements(driver, this);
        locateUserAdmin.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ArrayList<WebElement> al1 = (ArrayList<WebElement>) driver.findElements(By.xpath("//a[@id='menu_admin_viewAdminModule']/parent::li/ul/li/a"));
        Iterator<WebElement> itr1 = al1.iterator();
        String value;
        while (itr1.hasNext()) {
            WebElement element = itr1.next();
            value = element.getText();
            System.out.println(value);
            if (value.contains("Configuration")) {
                System.out.println("List contains Configuration Value:");
                break;
            } else {
                System.out.println("Doesnot Contain the Configuration value :");
            }
        }

    }
    public void addUsers() throws IOException {
     if(addUserBtn.isEnabled())
     {
         logger.info("User is correct Page and now able to create the user");
         addUserBtn.click();
     }
     else
     {
         logger.info("User is now wrong page");
     }
     WebElement addUserPage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(.,'Add User')]")));
        ExcelPOIReadWriteUtility POI=new ExcelPOIReadWriteUtility();
        String Filepath="C:/Personal/Learning/SeleniumCucumberFramework/src/test/resources/csvdatafromscreen";
        POI.readExcelData(Filepath,"TestData.xlsx","AddEmployee");



    }
    public void captureAddedUserfromListinHashMap()
    {
        HashMap<String,String>hm=new HashMap<String,String>();
        hm.put("Username","Aaliyah.Haq");
        hm.put("Username","Admin");
        hm.put("Username","Anthony.Nolan");
        for(Map.Entry<String,String> e: hm.entrySet())
        {
            System.out.println("Key "+e.getKey()+" "+"Value "+e.getValue());

        }


        /*
         ArrayList<WebElement> alw= (ArrayList<WebElement>) driver.findElements(By.xpath("//a[contains(.,'Username')]/ancestor::table[@id='resultTable']/descendant::tr/td[2][@class='left']"));
        Iterator<WebElement> itr=alw.iterator();
        String value;
        while (itr.hasNext())
        {
           WebElement ele= itr.next();
           value=ele.getText();


        }
         */




    }


}



