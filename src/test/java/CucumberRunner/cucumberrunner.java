package CucumberRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/feature"},glue = {"stepdefinitition"},
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/Cucumber.json",
                "junit:target/Cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        dryRun=false,
        // tags="@regression or @important"//or is display any one   condition is available,
        //tags = "@regression and @important"//and is used for both condtion is available
        //tags = "not @regression and not @important"
        // tags = "@login"
        //tags = "@smoke and not @regression"
        //tags = "@login"
        tags="@smoke")
//tags = "@DataDriven")
public class cucumberrunner
{

}
