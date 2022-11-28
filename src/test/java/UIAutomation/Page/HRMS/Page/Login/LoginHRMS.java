package UIAutomation.Page.HRMS.Page.Login;

import UIAutomation.CommonUtilities.CommonBrowserSelection;
import UIAutomation.CommonUtilities.ReadValueFromCucumberYmlFile;
import UIAutomation.ObjectRepository.HRMS.HRMSRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.logging.Logger;

public class LoginHRMS  {
    public static ReadValueFromCucumberYmlFile readYmlValue;
    public static Logger logger = Logger.getLogger(String.valueOf(LoginHRMS.class));
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//input[@name='username']")
    WebElement inputboxLoginUsername;
    @FindBy(xpath = "//input[@name='password']")
    WebElement inputboxLoginPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnlogin;
    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement txtVerificationDashboard;

    public void LoginPageVerification() {
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.elementToBeClickable(btnlogin));
    }

    public void Userlogin() {
        String username = readYmlValue.propFile("Username");
        String password = readYmlValue.propFile("Password");
        PageFactory.initElements(driver, this);
        inputboxLoginUsername.sendKeys(username);
        inputboxLoginPassword.sendKeys(password);
        btnlogin.click();
        wait.until(ExpectedConditions.visibilityOf(txtVerificationDashboard));
    }

    public void DashboardLoggedInPage() {
        PageFactory.initElements(driver, this);
        if (txtVerificationDashboard.isDisplayed()) {
            logger.info("User is landed on the Dashboard");
        } else {
            logger.info("User is not landed");
        }

    }


}
