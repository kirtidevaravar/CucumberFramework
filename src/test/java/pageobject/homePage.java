package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage {

    //constructor
    public homePage(WebDriver driver)
    {
        super(driver);


    }

    //locaters
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountLink;
    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerAccountLink;
    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginlink;

    //action
   public void clickonMyaccount()
   {
       myAccountLink.click();
   }
   public  void clickonRegisteraccount()
   {
       registerAccountLink.click();
   }
   public void clickonLoginaccout()
   {
       loginlink.click();
   }

   }
