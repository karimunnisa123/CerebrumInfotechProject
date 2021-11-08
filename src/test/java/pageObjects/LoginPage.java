package pageObjects;

import hooks.BaseClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.BrowserFactory;
import util.PageUtils;


public class LoginPage {

     public LoginPage() {
         PageFactory.initElements(BrowserFactory.getDriver(), this);

          }


    @FindBy(id = "email")
    public WebElement emailTextField;
  //  @Step("login with username: {0} step")
    public void enterEmailInTextField(String username){
        emailTextField.sendKeys(username);
    }

    @FindBy(id = "password")
    WebElement passwordTextField;
  //  @Step("login with password:{0} step")
    public void enterPasswordInTextField(String password){
        passwordTextField.sendKeys(password);
    }

    @FindBy(xpath = "//*[@id='loginForm']/button")
    WebElement loginBtn;
  //  @Step("clicking on login button steo")
    public void clickOnLoginBtn(){
        loginBtn.click();
    }

  /* @FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/div/a/div/div[1]/p")  //*[@id="navbarSupportedContent"]/div/a/div/div[1]/h6
    WebElement welcomeText;
    @Step("Verifying login successful step")
    public String getWelcomeText(){
        return welcomeText.getText();
    }
*/
  @FindBy(css = ".page-heading h3")
  WebElement dashboardHeadingText;

    public String getDashboardHeadingText(){
        return dashboardHeadingText.getText();
    }

   /* @FindBy(xpath = "/html/body/div[1]")
    WebElement errorMessages;
   // @Step("Verifying invalid credentials msg step")
    public String getErrorMessage(){
        return errorMessages.getText();
    }
*/

    @FindBy(css = "label[for='email']")
    WebElement emailErrorMessages;

    public String getEmailErrorMessage(){
        return emailErrorMessages.getText();
    }

    @FindBy(css = "label[for='password']")
    WebElement passwordErrorMessages;

    public String getPasswordErrorMessage(){
        return passwordErrorMessages.getText();
    }

    @FindBy(css = "div[class='toastify on error toastify-center toastify-top']")
    WebElement invalidErrorMessages;

    public String getInvalidErrorMessage(){
        PageUtils.waitUntilVisible(invalidErrorMessages,10);
        return invalidErrorMessages.getText();
    }


}





