package UIAutomation.ObjectRepository.HRMS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HRMSRepo {
    public static By loginVerificationScreenElement = By.xpath("//h5[contains(.,'Login')]");
    public static By inputboxLoginUsername = By.xpath("//input[@name='username']");
    public static By inputboxLoginPassword = By.xpath("//input[@name='password']");
    public static By btnlogin = By.xpath("//input[@name='Submit']");
    public static By txtVerificationDashboard = By.xpath("//h1[text()='Dashboard']");
    public static By txtTopMenuNames = By.xpath("//li[@class='main-menu-first-level-list-item']/child::*/b");


}
