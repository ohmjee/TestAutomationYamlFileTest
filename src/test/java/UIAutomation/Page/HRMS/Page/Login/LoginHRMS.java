package UIAutomation.Page.HRMS.Page.Login;

import UIAutomation.ObjectRepository.HRMS.HRMSRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class LoginHRMS
{
    public static Logger logger =Logger.getLogger(String.valueOf(LoginHRMS.class));
    static WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//input[@name='txtUsername']")
    WebElement inputboxLoginUsername;
    @FindBy(xpath = "//input[@name='txtPassword']")
    WebElement inputboxLoginPassword;
    @FindBy(xpath = "//input[@name='Submit']")
    WebElement btnlogin;
    @FindBy(xpath = "//h1[text()='Dashboard']")
    WebElement txtVerificationDashboard;

    public void Userlogin(String Username, String Password)
    {
        PageFactory.initElements(driver,this);
        inputboxLoginUsername.sendKeys(Username);
        inputboxLoginPassword.sendKeys(Password);
        btnlogin.click();
    }
    public void userLoginVerification()
    {
        PageFactory.initElements(driver,this);
        if(txtVerificationDashboard.isDisplayed())
        {
            logger.info("User is landed on the Dashboard");
        }
        else
        {
            logger.info("User is not landed");
        }

    }







}
