package UIAutomation.ObjectRepository;

import org.openqa.selenium.By;

public class FlightSearchPageRepo
{
    public static By listBannerVerification=By.xpath("//li[contains(.,'ABOUT IXIGO')]");
    public static By txtfromdestination=By.xpath("//div[@class='u-ib swap-icon ixi-icon-swap u-v-align-middle']//preceding::input[@class='c-input u-v-align-middle']");
    public static By txtTodestination=By.xpath("//div[@class='u-ib swap-icon ixi-icon-swap u-v-align-middle']//following::div[3]/input[@class='c-input u-v-align-middle']");
    public static By btnsearch=By.xpath("//button[@class='c-btn u-link enabled' and contains(.,'Search')]");
    public static By correctdestinationverification=By.xpath("//div[@class='city u-text-ellipsis' and @title='Patna']//preceding::a[contains(.,'EDIT FARE ALERT')]");

}
