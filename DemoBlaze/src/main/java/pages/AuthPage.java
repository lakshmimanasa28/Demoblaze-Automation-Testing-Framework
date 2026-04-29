package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage extends BasePage {

    public AuthPage(WebDriver driver) {
        super(driver);
    }

  
    By loginBtn = By.id("login2");
    By signupBtn = By.id("signin2");

    By loginUsername = By.id("loginusername");
    By loginPassword = By.id("loginpassword");
    By loginSubmit = By.xpath("//button[text()='Log in']");

    By signupUsername = By.id("sign-username");
    By signupPassword = By.id("sign-password");
    By signupSubmit = By.xpath("//button[text()='Sign up']");

   

    public void clickLogin() {
        click(loginBtn);
    }

    public void login(String username, String password) {
        type(loginUsername, username);
        type(loginPassword, password);
        click(loginSubmit);
    }

   

    public void clickSignUp() {
        click(signupBtn);
    }

    public void signup(String username, String password) {
        type(signupUsername, username);
        type(signupPassword, password);
        click(signupSubmit);
    }



    public void enterSignupUsername(String username) {
        type(signupUsername, username);
    }

    public void enterSignupPassword(String password) {
        type(signupPassword, password);
    }

    public String getSignupUsernameValue() {
        return driver.findElement(signupUsername).getAttribute("value");
    }

    public String getSignupPasswordValue() {
        return driver.findElement(signupPassword).getAttribute("value");
    }

   

    public String getAlertTextIfPresent() {
        return super.getAlertTextIfPresent(); 
    }

    public void acceptAlertIfPresent() {
        super.acceptAlertIfPresent(); 
    }
}