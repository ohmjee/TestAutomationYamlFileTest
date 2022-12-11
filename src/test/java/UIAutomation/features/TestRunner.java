package UIAutomation.features;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/UIAutomation/features/LoginHRMS.feature",glue = {"UIAutomation.StepDef"})
public class TestRunner
{

}

