package UIAutomation.StepDef;

import UIAutomation.CommonUtilities.CommonBrowserSelection;
import UIAutomation.CommonUtilities.CommonUtilities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class HRMSTestStefDef extends CommonBrowserSelection  {
    @Given("Launch the given Browser {string}")
    public void launchTheGivenBrowser(String Browser) throws IOException {
        CommonBrowserSelection.LaunchGenericBrowser(Browser);
    }

    @When("enter the URL {string} in the address bar of the browser")
    public void enterTheURLInTheAddressBarOfTheBrowser(String URL) throws IOException {
        CommonBrowserSelection.launchURL(URL);


    }

    @And("Login Page should be visible")
    public void loginPageShouldBeVisible() {

    }

    @Then("URL should be launched")
    public void urlShouldBeLaunched() {

    }

}
