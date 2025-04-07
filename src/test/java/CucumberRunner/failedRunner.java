package CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"@target/failedrerun.txt"},glue = {"stepdefinitition"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/Cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                //"timeline:target/parallel-threads",
                //"rerun:target/failedrerun.txt"
        },
        monochrome = true,
        dryRun=false,
        // tags="@regression or @important"//or is display any one   condition is available,
        //tags = "@regression and @important"//and is used for both condtion is available
        //tags = "not @regression and not @important"
        // tags = "@login"
        //tags = "@smoke and not @regression"
        //tags = "@login"
        tags="@regression")
//tags = "@DataDriven")
public class failedRunner extends AbstractTestNGCucumberTests
{

}
