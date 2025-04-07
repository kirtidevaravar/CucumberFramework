package pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobject.basePage;

public class registerPage extends basePage
{

   // constructors

    public registerPage(WebDriver driver)
    {
        super(driver);


    }

    //locaters
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement txtfirstname;
    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement txtlastname;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement txtemail;
    @FindBy(xpath="//input[@id='input-telephone']")
    private WebElement txtphonenumber;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement txtpassword;
    @FindBy(xpath="//input[@id='input-confirm']")
    private  WebElement txtconfirmpassword;
     @FindBy(xpath = "//input[@value='0']")
    private WebElement txtsubcribeNo;
     @FindBy(xpath = "//input[@name='agree']")
    private WebElement txtagree;
     @FindBy(xpath="//input[@class='btn btn-primary']")
    private WebElement txtcontinuebutton;
     @FindBy(xpath = "//h1[text ()= 'Your Account Has Been Created!']")
    private WebElement youraccounhasbeentcreated;
    //actions

    public void setFirstname(String firstname)
    {
        txtfirstname.sendKeys(firstname);
    }

    public void setLastname(String lastname)
    {
        txtlastname.sendKeys(lastname);
    }
    public void setEmail(String email)
    {
        txtemail.sendKeys(email);
    }

    public void setPhonenumber(String phonenumber)
    {
        txtphonenumber.sendKeys(phonenumber);
    }
    public void setPassword(String password)
    {
       txtpassword.sendKeys(password);
    }
    public void setconfirmpass(String confirmpassword)
    {
        txtconfirmpassword.sendKeys(confirmpassword);
    }
     public void clickonsubscribe()
     {
        //Actions actions = new Actions(driver);
        // actions.moveToElement( txtsubcribeNo).click().perform();
         JavascriptExecutor jp= (JavascriptExecutor) driver;
         jp.executeScript("arguments[0].click()",txtsubcribeNo);
     }
     public void clickonagree()
     {
        // Actions actions = new Actions(driver);
         //actions.moveToElement( txtagree ).click().perform();
         txtagree.click();
     }
     public void clickoncontinue()
     {
         txtcontinuebutton.click();
     }

     public String getmessage()
     {
         return youraccounhasbeentcreated.getText();
     }

}
