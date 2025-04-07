package stepdefinitition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.driverFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import utils.configReader;

public class hooks
{
    private static final Logger logger= LogManager.getLogger(hooks.class);
    private static configReader configReader;
    @Before
  public void setup()
    {
        //logger=LogManager.getLogger(this.getClass());

        logger.info("Base class initiated");
        String environment=System.getProperty("environment","dev");
        String path="src/test/resources/config-"+environment+".properties";
       configReader=new configReader(path);
        WebDriver driver= driverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void teardown(Scenario scenario)
    {
        if (scenario.isFailed())
        {
            logger.error("test scenario failed:" + scenario.getName());
            try {
                TakesScreenshot takesScreenshot = (TakesScreenshot) driverFactory.getDriver();
                final byte[] sourcefile = takesScreenshot.getScreenshotAs(OutputType.BYTES);
                scenario.attach(sourcefile, "image/png", scenario.getName());
                captureScreenshot(scenario.getName());
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
            else
            {
                logger.info("Scenario is passed:"+scenario.getName());
            }
            driverFactory.quitDriver();
        }

        public String captureScreenshot(String testcasename)
        {
            String timestamp=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            String fileName=testcasename + timestamp + ".png";
            TakesScreenshot takesScreenshot=(TakesScreenshot) driverFactory.getDriver();
            File sourcefile=takesScreenshot.getScreenshotAs(OutputType.FILE);
            String path=System.getProperty("user.dir")+ "\\Screenshots\\" +fileName;
            File targetfile=new File(path);
            sourcefile.renameTo(targetfile);
            return path;
        }

        public static String getConfigValue(String key)
        {
            return configReader.getProperty(key);
        }
    }
