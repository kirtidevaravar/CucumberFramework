package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import stepdefinitition.hooks;

public class accountPage extends basePage {
    //constructers
    public static Logger logger= LogManager.getLogger(hooks.class);
    public accountPage(WebDriver driver) {
        super(driver);
    }

    //locaters
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement Myaccount;

    @FindBy(xpath = "//a[@class='list-group-item'][text()='Logout']")
    WebElement logoutele;

    public boolean isMyaccount() {
        logger.info("in this functio we are verifying the myaccounts page opened or not");
        try {
            return Myaccount.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
        public void clickonLogout()
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(logoutele).click().perform();
        }
    }

