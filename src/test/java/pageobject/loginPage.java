package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage
{
    //constructors
    public loginPage(WebDriver driver) {
        super(driver);
    }

    //locaters
    @FindBy(xpath = "//input[@id='input-email']")
   private WebElement emailadressele;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordele;
    @FindBy(xpath = "//input[@class='btn btn-primary']")
     private WebElement loginbutton;
    @FindBy(xpath = "(//div[@class='form-group']//a[contains(text(),'Forgotten Password')])")
    private WebElement forgottenPasswordele;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement warningMessage;
    //actions
    public void setEmail(String Emailaddrss)
    {
        emailadressele.sendKeys(Emailaddrss);
    }
    public void setPassword(String password)
    {
        passwordele.sendKeys(password);
    }
    public void clickonlogin()
    {
        loginbutton.click();
    }
    public void clickonforgotPasswordLink()
    {
        forgottenPasswordele.click();
    }


    public String getWarningMessage()
    {
       return warningMessage.getText();
    }
}
