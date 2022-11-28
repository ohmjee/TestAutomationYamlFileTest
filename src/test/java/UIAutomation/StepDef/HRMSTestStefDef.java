package UIAutomation.StepDef;

import UIAutomation.Page.OrangeHRMLogin;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HRMSTestStefDef extends OrangeHRMLogin {

    @Given("Launch the given Browser with URL {string}")
    public void launchTheGivenBrowserWithURL( String URL) {
        OrangeHRMLogin.BrowserLaunch();
        OrangeHRMLogin.LaunchURL(URL);
        OrangeHRMLogin.LoginScreenVerification();

    }

    @When("user has Username and Password")
    public void userHasUsernameAndPassword() throws InterruptedException {
        OrangeHRMLogin.UserLogin();

    }

    @Then("User should be able to login")
    public void userShouldBeAbleToLogin() {
    }

}
