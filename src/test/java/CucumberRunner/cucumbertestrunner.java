package CucumberRunner;

//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/feature"},glue = {"stepdefinitition"},
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/Cucumber.json",
                "junit:target/Cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:target/parallel-threads",
                "rerun:target/failedrerun.txt"
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
public class cucumbertestrunner extends AbstractTestNGCucumberTests
{
  @Override
  @DataProvider(parallel = true)
  public Object[][] scenarios()
  {
          return super.scenarios();
  }
}
