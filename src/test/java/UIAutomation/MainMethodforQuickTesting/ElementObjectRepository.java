package UIAutomation.MainMethodforQuickTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementObjectRepository
{
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

}
