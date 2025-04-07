package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import stepdefinitition.hooks;

public class driverFactory
{
    public static Logger logger= LogManager.getLogger(hooks.class);
    private static ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    public static WebDriver getDriver()
    {
        logger.info("in this function we are getting webdriver");
        if(driver.get()==null)
        {
            initDriver();
        }
        return driver.get();
    }
    private static  void initDriver()
    {
        logger.info("in this function we are initiating webdriver");
        System.setProperty("browser","chrome");
        String browser=System.getProperty("browser");
            switch (browser.toLowerCase())
            {
                case "chrome":
                    driver.set(new ChromeDriver());
                    break;
                case "edge":
                    driver.set(new EdgeDriver());
                    break;
                case "firefox":
                    driver.set(new FirefoxDriver());
                    break;
                default:
                    System.out.println("Please select valid browser");
                    break;
        }

    }

    //this method is used to quit the driver object
    public static void quitDriver()
    {
        logger.info("In this we are quiting webdriver");
        if(driver.get()!=null)
        {
            driver.get().quit();
            driver.remove();
        }
    }

}
