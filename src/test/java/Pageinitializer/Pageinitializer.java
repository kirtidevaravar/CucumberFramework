package Pageinitializer;

import org.openqa.selenium.WebDriver;
import pageobject.accountPage;
import pageobject.homePage;
import pageobject.loginPage;
import stepdefinitition.hooks;
import utils.driverFactory;

import java.time.Duration;

public class Pageinitializer {
    protected WebDriver driver;

    protected hooks hooks;
    protected homePage homePage;
    protected accountPage ap;
    protected loginPage loginPage;


    public Pageinitializer()
    {
        this.driver = driverFactory.getDriver();

       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        hooks hooks = new hooks();
       // WebDriver driver = driverFactory.getDriver();
        homePage = new homePage(driver);
        ap = new accountPage(driver);
         loginPage = new loginPage(driver);
    }
}
