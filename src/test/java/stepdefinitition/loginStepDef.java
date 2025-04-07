package stepdefinitition;

import Pageinitializer.Pageinitializer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobject.accountPage;
import pageobject.homePage;
import pageobject.loginPage;
import utils.driverFactory;

public class loginStepDef extends Pageinitializer
{
    public static Logger logger= LogManager.getLogger(loginStepDef.class);
    //hooks hooks=new hooks();
    //WebDriver driver=driverFactory.getDriver();
   // loginPage loginPage=new loginPage(driver);
    //homePage homePage=new homePage(driver);
    //accountPage ap=new accountPage(driver);


    @Given("As a user I want to launch the application")
    public void as_a_user_i_want_to_launch_to_the_application() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
       // driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
        driver.get(hooks.getConfigValue("url"));
        logger.info("open cart application launched successfully");
    }

    @When("I enter a valid username")
    public void i_enter_a_valid_username() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        //loginPage.setEmail("vidu1@gmail.com");
        loginPage.setEmail(hooks.getConfigValue("username"));
        logger.info("i am able to enter email");


    }

    @When("I enter a valid password")
    public void i_enter_a_valid_password() {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
        //loginPage.setPassword("vidu123");
        loginPage.setPassword(hooks.getConfigValue("password "));
        logger.info(" i am able to enter password");
    }

    @Then("I should login successfully")
    public void i_should_login_successfully() {
        logger.info("we are verifying login is sucess or not");
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        boolean Actualvalue = ap.isMyaccount();
        Assert.assertTrue(Actualvalue);
    }


    @And("I need to click on login link")
    public void iNeedToClickOnLoginLink() throws InterruptedException {

        homePage.clickonMyaccount();
        Thread.sleep(3000);
        homePage.clickonLoginaccout();
        logger.info("i am able to  click on login button");
    }


    @And("I need to click on login button")
    public void iNeedToClickOnLoginButton()
    {
        loginPage.clickonlogin();
    }

    @When("I enter a invalid username")
    public void iEnterAInvalidUsername()
    {
        loginPage.setEmail("vidu1@gmail.com");
        logger.info("i am able to enter email address");
    }

    @And("I enter a invalid password")
    public void iEnterAInvalidPassword()
    {
        loginPage.setPassword("vidu123");
        logger.info("i am able to enter password");

    }

    @Then("I should not login successfully")
    public void iShouldNotLoginSuccessfully()
    {
        boolean status = ap.isMyaccount();
        Assert.assertTrue(!status);
    }



        @When("user enters email {string} and password {string}")
        public void user_enters_email_and_password(String email, String password)
        {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();

        loginPage.setEmail(email);
        loginPage.setPassword(password);

    }

        @Then("The login {string} should be displayed")
        public void the_login_should_be_displayed(String expectedResult )
        {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        switch (expectedResult)
        {
            case "success":
                Assert.assertTrue(ap.isMyaccount());
                break;
            case "login error":
                Assert.assertTrue(loginPage.getWarningMessage().contains("No match for E-Mail Address and/or Password."));
                break;

        }
    }

}
