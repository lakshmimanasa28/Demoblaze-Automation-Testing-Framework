package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

  
    By signupBtn = By.id("signin2");
    By loginBtn = By.id("login2");
    By logoutBtn = By.id("logout2");
    By welcomeUser = By.id("nameofuser");

    By phonesCategory = By.linkText("Phones");
    By laptopsCategory = By.linkText("Laptops");

   
    public void clickSignUp() {
        click(signupBtn);
    }

    public void clickLogin() {
        click(loginBtn);
    }

    public void clickLogout() {
        click(logoutBtn);
    }

    public void clickPhones() {
        click(phonesCategory);
    }

    public void clickLaptops() {
        click(laptopsCategory);
    }

   
    public String getLoggedInUser() {
        return getText(welcomeUser);
    }

    public boolean isUserLoggedIn() {
        try {
            return getText(welcomeUser).contains("Welcome");
        } catch (Exception e) {
            return false;
        }
    }

    
    public void waitForUserLogin() {
        waitForVisibility(welcomeUser);
    }

    public void waitForLogout() {
        waitForVisibility(loginBtn);
    }
}