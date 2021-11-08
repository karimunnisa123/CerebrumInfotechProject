package stepDefinitions;

import hooks.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginPage;
import util.BrowserFactory;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static util.ConfigReader.*;

public class LoginSteps {
    //public WebDriver driver;
    public LoginPage loginPage;
    BaseClass baseClass = new BaseClass();


    @Given("^User is on login page$")
    public void user_is_on_login_page() throws IOException {
        System.out.println("Driver should invoke");
        System.out.println(getUrl());
        System.out.println(getBrowser());
        System.out.println(getEmail());
        System.out.println(getPassword());

        // BrowserFactory.getDriver().get(getUrl());

        baseClass.launchBrowser();
        BrowserFactory.getDriver().manage().window().maximize();
        BrowserFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage();
    }

    @When("^User fill valid credentials and click on login button$")
    public void userFillValidCredentialsAndClickOnLoginButton() throws IOException{
        System.out.println(getEmail());
        BrowserFactory.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            loginPage.enterEmailInTextField(getEmail());
            loginPage.enterPasswordInTextField(getPassword());
            loginPage.clickOnLoginBtn();
        BrowserFactory.getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        baseClass.quitBrowser();
    }




    @Then("^Verify user is logged in$")
    public void verifyUserIsLoggedIn() throws IOException, InterruptedException {
      /*  String expectedWelcomeText = "Administrator";

        Assert.assertTrue(loginPage.getWelcomeText().contains(expectedWelcomeText));

       baseClass.tearDown("userFillValidCredentialsAndClickOnLoginButton");
       // baseClass.tearDown("verifyUserIsLoggedIn"); */

        String expectedWelcomeText = "Dashboard";
        Thread.sleep(5000);
        System.out.println(loginPage.getDashboardHeadingText());
        Thread.sleep(5000);
        Assert.assertTrue(loginPage.getDashboardHeadingText().contains(expectedWelcomeText));
        Thread.sleep(5000);
      baseClass.quitBrowser();
    }


    @When("^User fill username as \"([^\"]*)\" and password as \"([^\"]*)\" and click on login button$")
    public void userFillUsernameAsAndPasswordAsAndClickOnLoginButton(String email, String password) throws IOException {
        loginPage.enterEmailInTextField(email);
        loginPage.enterPasswordInTextField(password);
        loginPage.clickOnLoginBtn();
        //baseClass.tearDown("userFillUsernameAsAndPasswordAsAndClickOnLoginButton");
       baseClass.quitBrowser();
    }


    /*   @Then("^Verify the error message \"([^\"]*)\"$")
    public void verifyTheErrorMessage(String expectedErrorMessage) throws IOException {
     Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage , "Test Failed");
          // baseClass.tearDown("verifyTheErrorMessage");
           baseClass.quitBrowser();
          }  //alerts,drapdop,waits,windowhandles,
    */


    @Then("^Verify the error message \"([^\"]*)\" for this \"([^\"]*)\"$")
    public void verifyTheErrorMessageForThis(String expectedErrorMessage, String test) {
        switch (test) {
            case "email":
                Assert.assertEquals(loginPage.getEmailErrorMessage(), expectedErrorMessage, "Test Failed");
                break;
            case "password":
                Assert.assertEquals(loginPage.getPasswordErrorMessage(), expectedErrorMessage, "Test Failed");
                break;
            case "invalid":
                Assert.assertEquals(loginPage.getInvalidErrorMessage(), expectedErrorMessage, "Test Failed");
                break;
        }

    }

}